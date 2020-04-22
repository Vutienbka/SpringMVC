package com.codegym.Service.CategoriesService;

import com.codegym.Entity.Book;
import com.codegym.Entity.Categories;
import com.codegym.Repository.CategoriesRepository.ICategoriesRepository;
import com.codegym.Service.BookService.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class CategoriesService implements ICategoriesService {

    @Autowired
    ICategoriesRepository categoriesRepository;
    @Autowired
    IBookService bookService;

    @Override
    public List<Categories> findAll() {
        return (List<Categories>) categoriesRepository.findAll();
    }

    @Override
    public Categories findById(Long categoryId) {
        return categoriesRepository.findOne(categoryId);
    }

    @Override
    public Categories save(Categories category) {
        return categoriesRepository.save(category);
    }

    @Override
    public Categories findCategoriesByCategoryCode(String code) {
        return categoriesRepository.findCategoriesByCategoryCode(code);
    }

    @Override
    public void remove(Long categoryId) {
        categoriesRepository.delete(categoryId);
    }

//    @Override
//    public Categories addCategory(Categories category, Book book) {
//
//        Book newBook = new Book();
//        newBook.setCode(book.getCode());
//        newBook.setName(book.getName());
//        newBook.setDetail(book.getDetail());
//        newBook.setImage(book.getImage());
//        newBook.setLanguage(book.getLanguage());
//        newBook.setQuantity(book.getQuantity());
//        newBook.setPrice(book.getPrice());
//        newBook.setStatus(book.getStatus());
//        Categories newCategory;
//        newCategory = findCategoriesByCategoryCode(category.getCategoryCode());
//        if(newCategory==null) {
//            newCategory = new Categories();
//            newCategory.setCategoryCode(category.getCategoryCode());
//            newCategory.setCategoryName(category.getCategoryName());
//
//        }
//        newCategory.setBookList(Arrays.asList(book));
//        //book.setCategories(newCategory);
//        bookService.addBook(book);
//        return categoriesRepository.save(newCategory);
//    }


}
