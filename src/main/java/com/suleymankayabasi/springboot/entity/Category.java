 package com.suleymankayabasi.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

    @SequenceGenerator(name = "generator",sequenceName = "CATEGORY_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID",nullable = false)
    private Long id;

    @Column(name = "NAME",nullable = false, length = 50)
    private String name;

    @Column(name = "BREAKDOWN")
    private Long breakDown;

    // A Top-Category can have many Categories
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TOP_CATEGORY")
    private Category topCategory;

    public Category() {
    }

    public Category(Long id, String name, Long breakDown, Category topCategoryId) {
        this.id = id;
        this.name = name;
        this.breakDown = breakDown;
        this.topCategory = topCategory;
    }

    public Category getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(Category topCategory) {
        this.topCategory = topCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBreakDown() {
        return breakDown;
    }

    public void setBreakDown(Long breakDown) {
        this.breakDown = breakDown;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id == null ? "" : id.toString();
    }
}
