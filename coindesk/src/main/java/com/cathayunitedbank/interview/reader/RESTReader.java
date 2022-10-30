// package com.cathayunitedbank.interview.reader;

// import java.util.HashMap;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;
// import org.springframework.web.client.RestTemplate;

// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Component
// public class RESTReader{
    
//     @Autowired
//     private RestTemplate restTemplate;

//     @Autowired
//     private ObjectMapper objectMapper;

//     @Value("${coin.refreshcurrency.api}")
//     private String url;

//     public List<HashMap<String, Object>> getFetchData() throws Exception {
//         log.info("Fetching data from the url: {}", url);
//         String json = restTemplate.getForObject(url, String.class);
	
// 		HashMap<String, Object> map = objectMapper.readValue(json, new TypeReference<HashMap<String, Object>>(){});

//         // HashMap<String, Object> inside = objectMapper.convertValue(map.get("bpi"), new TypeReference<HashMap<String, Object>>(){});

//         return map.entrySet()
//                 .stream()
//                 .map(e -> objectMapper.convertValue(e.getValue(), new TypeReference<HashMap<String, Object>>(){}))
//                 .toList();
//     }
// }
