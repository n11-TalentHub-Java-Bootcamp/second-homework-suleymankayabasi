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

//  @Mapping(target = "ustKategori.id", source = "ustKategoriId", expression = "java(null))
//  @Mapping(target = "ustKategori.id", source = "ustKategoriId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
//  @Mapping(target = "ustKategori.id", expression = "java(kategoriDto.getUstKategoriId() == null ? null : " + "kategoriDto.getUstKategoriId())")
//  @Mapping(target = "topCategoryId.id",source = "topCategoryId")
    Category convertCategoryDtoToCategory(CategoryDto categoryDto);
}
