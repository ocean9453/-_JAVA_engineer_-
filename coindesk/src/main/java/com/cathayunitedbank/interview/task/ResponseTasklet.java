package com.cathayunitedbank.interview.task;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ResponseTasklet implements Tasklet, InitializingBean{

    private String uuid;

    @Qualifier("reponseMap")
    @Autowired
    private HashMap<String ,HttpServletResponse> reponseMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(reponseMap, "directory must be set");       
    }

    @Override
    @Nullable
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {     
        reponseMap.entrySet().removeIf(e-> e.getKey().equals(uuid) );
        return RepeatStatus.FINISHED;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
}
