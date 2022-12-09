// package com.cathayunitedbank.interview.listener;

// import org.springframework.batch.core.annotation.OnReadError;
// import org.springframework.stereotype.Component;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Component
// public class BaseStepListener {
//     // @BeforeChunk
//     // public void beforeChunk(ChunkContext context) {
//     //     log.info("before chunk excute: " + context.getStepContext().getStepName());
//     // }

//     // @AfterChunk
//     // public void afterChunk(ChunkContext context) {
//     //     log.info("after chunk excute: " + context.getStepContext().getStepName());
//     // }

//     // @BeforeStep
//     // public void breforeStep(StepExecution stepExecution) {
//     //     log.info("before step execute: " + stepExecution.getStepName());
//     // }

//     // @AfterStep
//     // public void afterStep(StepExecution stepExecution) {
//     //     log.info("after step execute: " + stepExecution.getStepName());
//     // }

//     // @BeforeRead
//     // public void beforeRead() {
//     //     log.info("before read excute: @@@");
//     // }

//     // @AfterRead
//     // public <T> void afterRead(T item) {
//     //     log.info("after read excute: " + item.getClass());
//     // }
    
//     // @BeforeProcess
//     // public <T> void beforeProcess(T item) {
//     //     log.info("before process excute: " + item.getClass());
//     // }

//     // @AfterProcess
//     // public <T, S> void afterProcess(T item, S result) {
//     //     log.info("after process excute: " + item.getClass() + " to " + result.getClass());
//     // }
//     // @BeforeWrite
//     // public void beforeWrite(List<? extends BaseEntity> list) {
//     //     log.info("before write excute: " + list.size());
//     // }
//     // @AfterWrite
//     // public void afterWrite(List<? extends BaseEntity> list) {
//     //     log.info("after write excute: " + list.size());
//     // }
//     // @OnReadError
//     // public void onReadError(Exception exception){
//     //     log.debug("on Read Error: " + exception.getMessage());
//     // }
// }
