package com.lxl.repository;

import java.io.Serializable;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/27
 */
public interface BaseRepository<T, PK extends Serializable> {
//    T load(PK id);

    T get(PK id);

//    List<T> findAll();
//
//    void persist(T entity);
//
//    PK save(T entity);
//
//    void saveOrUpdate(T entity);
//
//    void delete(PK id);
//
//    void flush();
}
