package ua.com.kisit.course2026np.converter;


import org.springframework.stereotype.Component;
import ua.com.kisit.course2026np.dto.CategoryDto;
import ua.com.kisit.course2026np.entity.Categories;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {

    public CategoryDto toCategoryDto(Categories category){
        if(category==null){
            return null;
        }
        return new CategoryDto(category.getId(), category.getName(), category.getDescription(), category.getImage());
    }

    public Categories toCategory(CategoryDto categoryDto){
       if(categoryDto==null){
           return null;
       }
       return new Categories(categoryDto.getId(), categoryDto.getName(), categoryDto.getDescription(), categoryDto.getImage());
    }

    public List<CategoryDto> toCategoryDtoList(List<Categories> categories){
        if(categories==null || categories.isEmpty()){
            return new ArrayList<>();
        }

        return categories
                .stream()
                .map(this::toCategoryDto)
                .toList();
    }

    public List<Categories> toCategoryList(List<CategoryDto> categoryDto){
        if(categoryDto==null||categoryDto.isEmpty()){
            return List.of();
        }

        return categoryDto
                .stream()
                .map(this::toCategory)
                .toList();
    }
}
