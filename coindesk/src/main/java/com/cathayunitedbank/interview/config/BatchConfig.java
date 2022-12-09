package com.cathayunitedbank.interview.config;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cathayunitedbank.interview.entity.CoinEntity.Bpi;
import com.cathayunitedbank.interview.entity.CoinEntity.UpdateTime;
import com.cathayunitedbank.interview.processor.CoinProcessor;
import com.cathayunitedbank.interview.processor.DateFormatterProcessor;
import com.cathayunitedbank.interview.reader.DBReader;
import com.cathayunitedbank.interview.reader.RESTReader;
import com.cathayunitedbank.interview.task.ResponseTasklet;
import com.cathayunitedbank.interview.writer.DBWiter;
import com.cathayunitedbank.interview.writer.RestWrite;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    
    @Autowired
    private StepBuilderFactory stepBuilderFactory; 
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("reponseMap")
    public HashMap<String ,HttpServletResponse> reponseMap(){
        return new HashMap<String ,HttpServletResponse>();
    }

    /******************************* refresh Currency **********************************************/

	@Bean
	public Step refreshCurrencyStep(RESTReader reader, DBWiter<Bpi, Long> writer) {
        return stepBuilderFactory
                .get("refreshCurrencyStep")
                .<Bpi, Bpi> chunk(100)
                .reader(reader.FetchBpi())
                .writer(writer)
                .build();
    }
	@Bean
	public Step refreshUpdateTimeStep(RESTReader reader, DBWiter<UpdateTime, Long> writer) {
        return stepBuilderFactory
                .get("refreshUpdateTimeStep")
                .<UpdateTime, UpdateTime> chunk(100)
                .reader(reader.FetchTime())
                .writer(writer)
                .build();
    }
	
	@Bean("refreshCurrency")
	public Job refreshCurrencyJob(@Qualifier("refreshCurrencyStep") Step step, @Qualifier("refreshUpdateTimeStep") Step step2){
		return jobBuilderFactory.get("refreshCurrencyJob").start(step).next(step2).build();
	}
    
    // /******************************* export data **********************************************/

    @Bean
	@JobScope
    public Step deleteResponseStep( @Value("#{jobParameters[uuid]}") String uuid, ResponseTasklet tasklet) {
		return stepBuilderFactory.get("deleteArchiveStep")
				.tasklet(tasklet)
				.build();
    }

    @Bean
	@JobScope
	public Step bpiDataFromDBStep(DBReader<Bpi> reader, CoinProcessor processor, 
        @Value("#{jobParameters[uuid]}") String uuid,  HashMap<String ,HttpServletResponse> respMap) {
        RestWrite<Bpi> writer = new RestWrite<>(respMap.get(uuid));
		return stepBuilderFactory.get("bpiDataFromDBStep")
				.<Bpi, Bpi>chunk(100)
				.reader(reader.reader(Bpi.class))
                .processor(processor)
				.writer(writer)
				.build();
	}
    
    @Bean
	@JobScope
	public Step timeDataFromDBStep(DBReader<UpdateTime> reader, DateFormatterProcessor processor,
        @Value("#{jobParameters[uuid]}") String uuid,  HashMap<String ,HttpServletResponse> respMap) {
        RestWrite<UpdateTime> writer = new RestWrite<>(respMap.get(uuid));
		return stepBuilderFactory.get("timeDataFromDBStep")
				.<UpdateTime, UpdateTime>chunk(100)
				.reader(reader.reader(UpdateTime.class))
                .processor(processor)
				.writer(writer)
				.build();
	}

    @Bean("export")
	public Job coinDataFromDBJob(@Qualifier("bpiDataFromDBStep") Step step,  @Qualifier("timeDataFromDBStep")Step step2, 
        @Qualifier("deleteResponseStep")Step step3) {
		return jobBuilderFactory.get("coinDataFromDBJob").start(step).next(step2).next(step3).build();
	}
}
