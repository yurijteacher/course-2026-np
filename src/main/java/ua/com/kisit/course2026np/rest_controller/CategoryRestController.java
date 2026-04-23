package ua.com.kisit.course2026np.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.kisit.course2026np.converter.CategoryConverter;
import ua.com.kisit.course2026np.dto.CategoryDto;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.service.CategoriesService;

import java.util.List;
import java.util.Optional;

// ResponseEntity (ResponseBody, HttpStatus, title)

@RestController
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoriesService categoryService;
    private final CategoryConverter categoryConverter;

    @GetMapping("/category-rest")
    public ResponseEntity<List<CategoryDto>> getListCategoryDto() {

        try {
            List<Categories> categories = categoryService.findAllCategory();

            if (categories == null || categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(categoryConverter.toCategoryDtoList(categories), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/category-rest/{id}")
    public ResponseEntity<CategoryDto> getCategoryDto(@PathVariable("id") Long id) {

        try {
            Optional<Categories> categories = categoryService.findById(id);

            return categories.map(e -> new ResponseEntity<>(categoryConverter.toCategoryDto(e), HttpStatus.OK)).orElseGet(
                    () -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/category-rest")
    public ResponseEntity<CategoryDto> saveNewCategory(@RequestBody CategoryDto categoryDto) {
        try {
            Categories category = categoryService.addNewCategory(categoryConverter.toCategory(categoryDto));

            return new ResponseEntity<>(categoryConverter.toCategoryDto(category), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/category-rest/{id}")
    public ResponseEntity<CategoryDto> saveNewCategory(
            @PathVariable("id") Long id,
            @RequestBody CategoryDto categoryDto) {

        if (categoryService.findById(id).isPresent()) {

            Categories category = categoryService.findById(id).get();
            category.setId(categoryDto.getId());
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            category.setImage(categoryDto.getImage());

            Categories category1 = categoryService.addNewCategory(category);

            return new ResponseEntity<>(categoryConverter.toCategoryDto(category1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/category-rest/{id}")
    public ResponseEntity<CategoryDto> deleteCategoryByIdRest(@PathVariable("id") Long id) {

        try {
            categoryService.deleteCatById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


//    @GetMapping("/category-rest-test")
//    public List<Categories> getCategories(){
//        return categoryService.findAllCategories();
//    }


}
