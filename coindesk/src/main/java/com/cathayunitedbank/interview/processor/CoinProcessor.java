package com.cathayunitedbank.interview.processor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.cathayunitedbank.interview.entity.CoinEntity;

@Component
public class CoinProcessor implements ItemProcessor<CoinEntity,CoinEntity>{

    private static final Map<String, String> COIN_DESCRIBE = new HashMap<>();

    public CoinProcessor() {
        COIN_DESCRIBE.put("USD", "美金");
        COIN_DESCRIBE.put("GBP", "英鎊");
        COIN_DESCRIBE.put("EUR", "歐元");
    }

    @Override
    @Nullable
    public CoinEntity process(@NonNull CoinEntity item) throws Exception {
        // item.setCode(COIN_DESCRIBE.get(item.getCode()));
        return item;
    }
    
}
