package com.cathayunitedbank.interview.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cathayunitedbank.interview.entity.CoinEntity;

@Repository
public class CoinDao {
    
    @Autowired
    private RepositoryContainer.Container repo;

    public void delete(Long id){
        repo.getCoinRepo().deleteById(id);
    }

    public void update(CoinEntity pojo){
        repo.getCoinRepo().save(pojo);
    }

    public CoinEntity select(Long id){
        return repo.getCoinRepo().findById(id).get();
    }

    public void save(CoinEntity pojo){
        repo.getCoinRepo().save(pojo);
    }

    public void saveAll(List<CoinEntity> pojo){
        repo.getCoinRepo().saveAll(pojo);
    }

    public List<CoinEntity> findAll(){
        return repo.getCoinRepo().findAll();
    }
}
