package com.codegym.Service.ProvinceService;

import com.codegym.Model.Province;
import com.codegym.Repository.ProvinceRepository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProvinceService implements IProvinceService{

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return (List<Province>) provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long provinceId) {
        return provinceRepository.findById(provinceId);
    }

    @Override
    public boolean save(Province province) {
        if(provinceRepository.save(province)!=null){
            return true;
        }else return false;
    }

    @Override
    public void remove(Long provinceId) {
        provinceRepository.deleteById(provinceId);
    }
}
