package ua.com.kisit.course2026np.controller;

import org.springframework.ui.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.entity.Products;
import ua.com.kisit.course2026np.service.CategoriesService;
import ua.com.kisit.course2026np.service.ProductService;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class ProductManager {

    private final ProductService productService;
    private final CategoriesService categoriesService;

    @GetMapping("/product-manager")
    public String getProductPageForManager(Model model){

        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoriesService.findAllCategories());


        return "product-manager";
    }

    @PostMapping("/saveNewProduct")
    public String saveNewProductToDB(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") String image,
            @RequestParam(name = "price") double price,
            @RequestParam(name = "category") Categories categories
            ){
        Products product = new Products();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(new BigDecimal(price));
        product.setCategory(categories);

        productService.save(product);

        return "redirect:/product-manager";
    }

    @PostMapping("/updateProduct")
    public String updateProductToDB(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") String image,
            @RequestParam(name = "price") double price,
            @RequestParam(name = "category") Categories categories
    ){
        Products product = new Products();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(new BigDecimal(price));
        product.setCategory(categories);

        productService.update(product);

        return "redirect:/product-manager";
    }

    @PostMapping("/deleteProduct")
    public String deleteProductFromDB(
            @RequestParam(name = "id") Long id
    ){
        productService.delete(id);
        return "redirect:/product-manager";
    }


}
