package com.suleymankayabasi.springboot.dao;

import com.suleymankayabasi.springboot.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends CrudRepository<Category,Long> {

    List<Category> findAllByTopCategoryIsNullOrderByNameDesc();

    List<Category> findAllByNameEndingWith(String name);
}
