package com.cathayunitedbank.interview.entity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.batch.core.JobParameter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class ResponseJob extends JobParameter{
    private HttpServletRequest request;

    public ResponseJob(HttpServletRequest request){
        super("");
        this.request = request;
    }
    public HttpServletRequest getRequest(HttpServletRequest request){
        return request;
    }
}
