package com.cathayunitedbank.interview.reader;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cathayunitedbank.interview.entity.CoinEntity;
import com.cathayunitedbank.interview.entity.CoinEntity.Bpi;
import com.cathayunitedbank.interview.entity.CoinEntity.UpdateTime;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Scope("prototype")
public class RESTReader{
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${coin.refreshcurrency.api}")
    private String url;

    private CoinEntity coinEntity;

    public ListItemReader<Bpi> FetchBpi(){
        return new ListItemReader<>(this.coinEntity.getBpi());
    }

    public ListItemReader<UpdateTime> FetchTime(){
        return  new ListItemReader<>(Arrays.asList(this.coinEntity.getUpdateTime()));
    }
    @PostConstruct
    public void init() throws Exception {
        log.info("Fetching data from the url: {}", url);
        String json = restTemplate.getForObject(url, String.class);
		this.coinEntity = objectMapper.readValue(json, new TypeReference<CoinEntity>(){});
    }
}
