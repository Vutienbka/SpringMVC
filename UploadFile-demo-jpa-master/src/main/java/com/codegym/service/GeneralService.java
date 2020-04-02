package com.codegym.service;

import java.util.List;

public interface GeneralService<T> {
    void add(T t);
    List<T> findAll();
}
