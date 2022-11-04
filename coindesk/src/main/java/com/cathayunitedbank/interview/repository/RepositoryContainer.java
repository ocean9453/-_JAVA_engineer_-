package com.cathayunitedbank.interview.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cathayunitedbank.interview.entity.ConvertEntity;
import com.cathayunitedbank.interview.entity.CoinEntity.Bpi;
import com.cathayunitedbank.interview.entity.CoinEntity.UpdateTime;

import lombok.Getter;

@Repository
public class RepositoryContainer {
    // @Repository
    // public interface ExampleRepo extends BaseRepo<ExampleEntity, Long>{};
    @Repository
    public interface UpdateTimeRepo extends BaseRepo<UpdateTime, Long>{};
    @Repository
    public interface BpiRepo extends BaseRepo<Bpi, Long>{};
    @Repository
    public interface ConvertEntityRepo extends BaseRepo<ConvertEntity, Long>{};

    @Getter
    @Component
    public class Container{
        @Autowired 
        public UpdateTimeRepo UpdateTimeRepo;
        @Autowired 
        public BpiRepo BpiRepo;
        @Autowired 
        public ConvertEntityRepo ConvertEntityRepo;

    }
}
