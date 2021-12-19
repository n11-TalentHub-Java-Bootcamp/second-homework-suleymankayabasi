package com.suleymankayabasi.springboot.converter;

import com.suleymankayabasi.springboot.dto.CategoryDto;
import com.suleymankayabasi.springboot.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter  {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(target="topCategoryId",source = "topCategory.id")
    CategoryDto convertCategoryToCategoryDto(Category category);

    @Mapping(target = "topCategoryId", source = "topCategory.id")
    List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList);

    Category convertCategoryDtoToCategory(CategoryDto categoryDto);
}
