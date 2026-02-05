package ua.com.kisit.course2026np.controller;


import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.entity.Products;
import ua.com.kisit.course2026np.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/category/{id}")
    public String findProductsByCategory(@PathVariable(name = "id") Categories category, Model model) {

        List<Products> products = productService.findByCategory(category);
        model.addAttribute("products", products);

        return "products-by-category";
    }


}
