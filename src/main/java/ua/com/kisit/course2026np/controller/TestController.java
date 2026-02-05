package ua.com.kisit.course2026np.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.service.CategoriesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final CategoriesService categoriesService;

    @GetMapping("/")
    public String index(Model model) {
        // model.addAttribute("hello", "Hello World!!!");
        // return "categories-admin";

        List<Categories> categories =  categoriesService.findAllCategories();

        model.addAttribute("categories", categories);


        return "category";
    }

}
