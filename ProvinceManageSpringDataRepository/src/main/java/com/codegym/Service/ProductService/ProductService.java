package com.codegym.Service.ProductService;

import com.codegym.Model.Product;
import com.codegym.Repository.ProductRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class ProductService implements IProductService{

    @Autowired
    ProductRepository productRepository;
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public void save(Product product) {
        if(product.getId()!=null){
            em.merge(product);
        }else {
            em.persist(product);
        }
    }

    @Override
    public void remove(Long productId) {
        productRepository.delete(productId);
    }
}
