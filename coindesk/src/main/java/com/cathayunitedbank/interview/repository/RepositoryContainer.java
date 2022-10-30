package com.cathayunitedbank.interview.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cathayunitedbank.interview.entity.CoinEntity;

import lombok.Getter;

@Repository
public class RepositoryContainer {
    // @Repository
    // public interface ExampleRepo extends BaseRepo<ExampleEntity, Long>{};
    @Repository
    public interface CoinRepo extends BaseRepo<CoinEntity, Long>{};

    @Getter
    @Component
    public class Container{
        @Autowired 
        public CoinRepo myUserRepo;

    }
}
