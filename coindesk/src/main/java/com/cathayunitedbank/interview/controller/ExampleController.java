package com.cathayunitedbank.interview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathayunitedbank.interview.entity.CoinEntity;
import com.cathayunitedbank.interview.entity.ResponseJob;
import com.cathayunitedbank.interview.reader.RESTReader;

@RestController
@RequestMapping("/load")
public class ExampleController {

    @Autowired
    private JobLauncher jobLauncher;

    @Qualifier("export")
    @Autowired
    private Job job;

    @Autowired
    private RESTReader reader;
    
    @PostMapping("/fetch")
    public String fetch(HttpServletRequest request) throws Exception {
        ResponseJob reponseJob = new ResponseJob(request);
        JobParameters paramJobParameters = new JobParametersBuilder()
                                                .addParameter("model", reponseJob)
                                                .addLong("dateTime", System.currentTimeMillis())
                                                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(job, paramJobParameters);
        
        System.out.println("JobExecution: " + jobExecution.getStatus());
        return "ok";
    }

    @PostMapping("/test")
    public void name() throws Exception {
        List<CoinEntity> t = reader.getFetchData();
        t.forEach(e-> System.out.println(e));
    }
}
