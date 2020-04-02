package com.codegym.repository;

import java.util.List;

public interface GeneralRepository<T> {
    void add(T t);
    List<T> findAll();
}
