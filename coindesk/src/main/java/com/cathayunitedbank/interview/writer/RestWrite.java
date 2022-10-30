package com.cathayunitedbank.interview.writer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.batch.item.ItemWriter;

import com.cathayunitedbank.interview.entity.CoinEntity;

public class RestWrite implements ItemWriter<CoinEntity>{

    private HttpServletRequest request;

    @Override
    public void write(List<? extends CoinEntity> items) throws Exception {
        request.setAttribute("data", items);     
    }

    public RestWrite(HttpServletRequest request){
        this.request = request;
    }
    
}
