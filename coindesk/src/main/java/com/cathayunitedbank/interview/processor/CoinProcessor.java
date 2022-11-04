package com.cathayunitedbank.interview.processor;


import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.cathayunitedbank.interview.entity.CoinEntity.Bpi;

@Component
public class CoinProcessor implements ItemProcessor<Bpi,Bpi>{

    private static final Map<String, String> COIN_DESCRIBE = new HashMap<>();

    public CoinProcessor() {
        COIN_DESCRIBE.put("USD", "美金");
        COIN_DESCRIBE.put("GBP", "英鎊");
        COIN_DESCRIBE.put("EUR", "歐元");
        COIN_DESCRIBE.put("&#36;", "\u0024");
        COIN_DESCRIBE.put("&pound;", "\u00A3");
        COIN_DESCRIBE.put("&euro;", "\u20AC");
    }

    @Override
    @Nullable
    public Bpi process(@NonNull Bpi item) throws Exception {
        String code = item.getCode();
        String convString = code != null ? COIN_DESCRIBE.get(item.getCode()) : "null";
        item.setCode(convString);
        item.setSymbol(COIN_DESCRIBE.get(item.getSymbol()));
        return item;
    }
    
}
