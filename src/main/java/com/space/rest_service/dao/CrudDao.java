package com.space.rest_service.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {

    void create(T value);

    boolean update(T value,Integer id);

    boolean delete(Integer id);

    T read(Integer id);

    List<T> readAll();

}
