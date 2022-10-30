// package com.cathayunitedbank.interview.service;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.cathayunitedbank.interview.entity.CoinEntity;
// import com.cathayunitedbank.interview.reader.RESTReader;
// import com.cathayunitedbank.interview.repository.CoinDao;
// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @Service
// public class TranService {
//     @Autowired
//    private CoinDao dao;

//    @Autowired
//    private RESTReader reader;

//    @Autowired
//    private ObjectMapper objectMapper;

//    public void delete(Long id){
//        dao.delete(id);;
//     }

//     public void update(CoinEntity pojo){
//        dao.save(pojo);
//     }

//     public List<HashMap<String, Object>> select(Long id) throws Exception{
//         CoinEntity pojo = dao.select(id);
//         List<HashMap<String, Object>> data = reader.getFetchData();
//         List<HashMap<String, Object>> rtMap = new  ArrayList<>();
//         data.forEach(e -> {
//             rtMap.add(e.get("code").equals(pojo.getEname()) ? e : null);
//         });
//         return rtMap;
//     }

//     public void save(CoinEntity pojo){
//         dao.save(pojo);
//     }

//     public List<HashMap<String, Object>> findAll() throws Exception{
//         List<CoinEntity> list = dao.findAll();
//         List<HashMap<String, Object>> data = reader.getFetchData();
//         HashMap<String, Object> map = objectMapper.convertValue(list, new TypeReference< HashMap<String, Object>>() {});
//         data.forEach(e -> e.put("code", map.get(e.get("code"))));
        
//         return data;
//     }

//     public void saveAll(Object object) {
//     }
// }
