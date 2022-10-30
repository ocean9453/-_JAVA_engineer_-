package com.cathayunitedbank.interview.config;

// @Configuration
// @EnableBatchProcessing
public class BatchConfig {
    
    // @Autowired
    // private StepBuilderFactory stepBuilderFactory; 
    // @Autowired
    // private JobBuilderFactory jobBuilderFactory;

    // @Bean
    // public RestTemplate restTemplate() {
    //     return new RestTemplate();
    // }

    /******************************* refresh Currency **********************************************/

    // @Bean
    // public ListItemReader<CoinEntity> listObjectReader(RESTReader reader) {
    //     try {
    //         return new ListItemReader<>(reader.getFetchData());
    //     } catch (Exception e) {}
    //     return null;
    // }

	// @Bean
	// public Step refreshCurrencyStep(ListItemReader<CoinEntity> reader, DBWiter<CoinEntity, Long> writer) {
    //     return stepBuilderFactory
    //             .get("refreshCurrencyStep")
    //             .<CoinEntity, CoinEntity> chunk(100)
    //             .reader(reader)
    //             .writer(writer)
    //             .build();
    // }
	
	// @Bean("refreshCurrency")
	// public Job refreshCurrencyJob(@Qualifier("refreshCurrencyStep") Step step){
	// 	return jobBuilderFactory.get("refreshCurrencyJob").start(step).build();
	// }
    
    // /******************************* export data **********************************************/

    // @Bean
	// @JobScope
	// public Step coinDataFromDBStep(HttpServletRequest request, DBReader<CoinEntity> reader, CoinProcessor processor, @Value("#{jobParameters[model]}") ResponseJob responseJob) {
    //     RestWrite writer = new RestWrite(responseJob.getRequest(request));
	// 	return stepBuilderFactory.get("coinDataFromDBStep")
	// 			.<CoinEntity, CoinEntity>chunk(100)
	// 			.reader(reader.reader(CoinEntity.class))
    //             .processor(processor)
	// 			.writer(writer)
	// 			.build();
	// }

    // @Bean("export")
	// public Job coinDataFromDBJob(@Qualifier("coinDataFromDBStep") Step step) {
	// 	return jobBuilderFactory.get("coinDataFromDBJob").start(step).build();
	// }
}
