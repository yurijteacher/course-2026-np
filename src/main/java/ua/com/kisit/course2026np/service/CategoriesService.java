package ua.com.kisit.course2026np.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.repository.CategoriesRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

//    public CategoriesService(CategoriesRepository categoriesRepository) {
//        this.categoriesRepository = categoriesRepository;
//    }

    @Cacheable(cacheNames = "categories")
    public List<Categories> findAllCategories(){
        return categoriesRepository.findAll();
    }

    public Categories findByNameCategory(String name){
        return categoriesRepository.findByName(name);
    }

    @Cacheable(cacheNames = "categoryId", key = "#id")
    public Optional<Categories> findById(Long id){
        return categoriesRepository.findById(id);
    }

    @CacheEvict(cacheNames = "categories", allEntries = true)
    public void saveNewCategory(Categories categories) {
        categoriesRepository.save(categories);
    }

    public List<Categories> findAllCategory(){
        return categoriesRepository.findAll();
    }

    public Categories addNewCategory(Categories categories){
        return categoriesRepository.save(categories);
    }

    @CacheEvict(cacheNames = {"categories","categoryId"}, allEntries = true)
    public void updateCategory(Categories categories) {  // category : id ...
        categoriesRepository.save(categories);
    }

    @CacheEvict(cacheNames = {"categories","categoryId"}, allEntries = true)
    public void deleteCategoryById(Long id) {
        categoriesRepository.deleteById(id);
    }

    public void deleteCatById(Long id) {
        categoriesRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = {"categories","categoryId"}, allEntries = true)
    public void deleteCategory(Categories categories) {
        categoriesRepository.delete(categories);
    }

    public void deleteAllCategories() {
        categoriesRepository.deleteAll();
    }


}
