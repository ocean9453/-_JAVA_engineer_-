package com.cathayunitedbank.interview.util;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResponseJobExecuteUtil {

    @Autowired
    private JobLauncher jobLauncher;
    @Qualifier("reponseMap")
    @Autowired
    private HashMap<String ,HttpServletResponse> reponseMap;

    public void execute(String uuid, Job job, HttpServletResponse response){
        try {
            response.setCharacterEncoding("UTF-8");
            reponseMap.put(uuid, response);
            JobExecution jobExecution =  jobLauncher.run(job, new JobParametersBuilder()
                    .addString("uuid", uuid)
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters());
            log.info("Status" + jobExecution.getStatus());
            log.info("CreateTime" + jobExecution.getCreateTime());
            log.info("EndTime" + jobExecution.getEndTime());
            log.info("Status" + jobExecution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
