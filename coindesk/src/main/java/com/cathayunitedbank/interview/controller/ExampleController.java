package com.cathayunitedbank.interview.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Transient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathayunitedbank.interview.entity.CoinEntity.Bpi;
import com.cathayunitedbank.interview.repository.BpiDao;
import com.cathayunitedbank.interview.util.ResponseJobExecuteUtil;

@RestController
@RequestMapping("/load")
public class ExampleController {

    @Qualifier("export")
    @Autowired
    private Job job;
    @Autowired
    private ResponseJobExecuteUtil excuteUtil;
    @Transient
    private UUID corrId = UUID.randomUUID();

    @Autowired
    private BpiDao dao;

    @PostMapping("/export")
    public void export(HttpServletResponse response) throws Exception{
        String uuid = corrId.toString();
        excuteUtil.execute(uuid, job, response);
    }

    @PostMapping("/delete/{code}")
    public void delete(@PathVariable String code){
        dao.delete(code);
    }
    @PostMapping("/select/{code}")
    public Bpi select(@PathVariable String code){
        return dao.selectByCode(code);
    }
}
