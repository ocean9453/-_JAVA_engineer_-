package com.cathayunitedbank.interview.writer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.item.ItemWriter;

import com.cathayunitedbank.interview.entity.BaseEntity;

public class RestWrite<T> implements ItemWriter<BaseEntity>{

    private HttpServletResponse response;

    @Override
    public void write(List<? extends BaseEntity> items) throws Exception {
        items.forEach(e -> {
            try {
                response.getWriter().write(e.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
    
    public RestWrite(HttpServletResponse response) {
        this.response = response;
    }

}
