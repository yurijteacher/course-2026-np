package ua.com.kisit.course2026np.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.entity.Products;
import ua.com.kisit.course2026np.repository.ProductsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductsRepository productRepository;

    public List<Products> findAll() {
        return productRepository.findAll();
    }

    public List<Products> findByCategory(Categories category) {
        return productRepository.findByCategory(category);
    }

    public Products findById(Long id) {
        return productRepository.findById(id).get();
    }

    public Products save(Products products) {
        return productRepository.save(products);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Products update(Products products) {
        return productRepository.save(products);
    }

}
