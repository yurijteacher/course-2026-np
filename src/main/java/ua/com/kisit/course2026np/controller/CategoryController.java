package ua.com.kisit.course2026np.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.service.CategoriesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoriesService categoriesService;

    @GetMapping("/categories")
    public String getPageCategories(Model model){

        List<Categories> categories = categoriesService.findAllCategories();
        model.addAttribute("categories", categories);

        return "categories";
    }

}
