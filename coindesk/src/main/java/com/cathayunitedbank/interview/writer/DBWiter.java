// package com.cathayunitedbank.interview.writer;

// import java.io.Serializable;
// import java.util.List;

// import org.springframework.batch.item.ItemWriter;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import com.cathayunitedbank.interview.entity.BaseEntity;
// import com.cathayunitedbank.interview.repository.BaseRepo;

// @Component
// public class DBWiter<T extends BaseEntity, E extends Serializable> implements ItemWriter<T>  {
    
//     @Autowired
//     private BaseRepo<T, E> repo;

//     @Override
//     public void write(List<? extends T> items) throws Exception {
//         repo.saveAll(items);
//     }
// }
