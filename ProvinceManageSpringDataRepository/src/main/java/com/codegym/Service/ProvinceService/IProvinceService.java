package com.codegym.Service.ProvinceService;

import com.codegym.Model.Province;

import java.util.List;
import java.util.Optional;

public interface IProvinceService {
    List<Province> findAll();
    Optional<Province> findById(Long provinceId);
    boolean save(Province province);
    void remove(Long provinceId);
}
