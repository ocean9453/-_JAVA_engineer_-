// package com.cathayunitedbank.interview.repository;

// import java.io.Serializable;
// import java.util.List;

// import org.springframework.context.annotation.Primary;
// import org.springframework.data.jpa.repository.JpaRepository;

// import com.cathayunitedbank.interview.entity.BaseEntity;

// @Primary
// public interface BaseRepo<T extends BaseEntity, E extends Serializable> extends JpaRepository<T, E> {
//     public abstract List<T> findAll();
// }