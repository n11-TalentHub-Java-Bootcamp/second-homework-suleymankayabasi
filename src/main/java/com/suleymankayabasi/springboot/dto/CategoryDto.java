package com.suleymankayabasi.springboot.dto;

public class CategoryDto {

    private Long id;
    private String name;
    private Long breakDown;
    private Long topCategoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTopCategoryId() {
        return topCategoryId;
    }

    public void setTopCategoryId(Long topCategoryId) {
        this.topCategoryId = topCategoryId;
    }
}
