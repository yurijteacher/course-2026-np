package ua.com.kisit.course2026np.controller;


import org.springframework.ui.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.service.CategoriesService;

@Controller
@RequiredArgsConstructor
public class CategoryManager {

    private final CategoriesService categoryService;

    @GetMapping("/category-manager")
    public String getCategoryPageForManager(Model model){
        model.addAttribute("categories", categoryService.findAllCategories());
        return "category-manager";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategoryToDb(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "description") String description,
                                      @RequestParam(name = "image") String image
                                      ){

        Categories category = new Categories();
        category.setName(name);
        category.setDescription(description);
        category.setImage(image);

        categoryService.saveNewCategory(category);

        return "redirect:/category-manager";
    }


    @PostMapping("/updateCategory")
    public String updateCategory(
                                      @RequestParam(name = "id") Long id,
                                      @RequestParam(name = "name") String name,
                                      @RequestParam(name = "description") String description,
                                      @RequestParam(name = "image") String image
    ){

        Categories category = new Categories();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        category.setImage(image);

        categoryService.updateCategory(category);

        return "redirect:/category-manager";
    }


    @PostMapping("/deleteCategory")
    public String deleteCategoryById(@RequestParam(name = "id") Long id){

        categoryService.deleteCategoryById(id);

        return "redirect:/category-manager";
    }



}
