package com.cathayunitedbank.interview.schedule;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RefreshTasks {

    @Qualifier("refreshCurrency")
    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    @Scheduled(cron = "0 0/1 * * * *")
	public void perform() throws Exception {

		log.info("Job Started at :" + new Date());

		JobParameters param = new JobParametersBuilder().addString("dateTime", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();

		JobExecution execution = jobLauncher.run(job, param);

		log.info("Job finished with status :" + execution.getStatus());
	}
}
