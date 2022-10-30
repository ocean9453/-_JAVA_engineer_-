package com.cathayunitedbank.interview.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cathayunitedbank.interview.service.TranService;

@RestController
@RequestMapping("/load")
public class ExampleController {

   @Autowired
   private TranService dao;
    
    @PostMapping("/fetchAll")
    @ResponseBody
    public List<HashMap<String, Object>> fetchALl() throws Exception {
        return dao.findAll();
    }
    
    @PostMapping("/initialize")
    @ResponseBody
    public void initialize() throws Exception {
        // 建立 幣別對應enum 遍歷 建立coinEntity 在saveAll
        dao.saveAll(null);
    }
}
