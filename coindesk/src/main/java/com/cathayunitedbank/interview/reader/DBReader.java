package com.cathayunitedbank.interview.reader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.cathayunitedbank.interview.repository.RepositoryContainer;

@Service
public class DBReader<T>{

    @Autowired
    private RepositoryContainer.Container container;

    public RepositoryItemReader<T> reader(Class<T> clazz){
        try {
            String methodName = "get" + clazz.getSimpleName() + "Repo";
            Method method = container.getClass().getDeclaredMethod(methodName);
            return new RepositoryItemReaderBuilder<T>()
                    .saveState(true)
                    .name("test")
                    .repository( (PagingAndSortingRepository<?, ?>) method.invoke(container))
                    .methodName("findAll")
                    .sorts(Map.of("id", Direction.ASC))
                    .arguments(new ArrayList<>())
                    .pageSize(10)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
