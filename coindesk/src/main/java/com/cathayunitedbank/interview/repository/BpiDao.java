package com.cathayunitedbank.interview.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cathayunitedbank.interview.entity.CoinEntity.Bpi;

@Repository
@Transactional
public class BpiDao {
    
    @Autowired
    private RepositoryContainer.Container repo;

    public void delete(String code){
        Bpi pojo = repo.getBpiRepo().findByCode(code);
        repo.getBpiRepo().delete(pojo);
    }

    public Bpi selectByCode(String code){
        return repo.getBpiRepo().findByCode(code);
    }

}
