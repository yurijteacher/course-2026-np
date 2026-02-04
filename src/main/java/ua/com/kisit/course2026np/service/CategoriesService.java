package ua.com.kisit.course2026np.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.course2026np.entity.Categories;
import ua.com.kisit.course2026np.repository.CategoriesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

//    public CategoriesService(CategoriesRepository categoriesRepository) {
//        this.categoriesRepository = categoriesRepository;
//    }

    public List<Categories> findAllCategories(){
        return categoriesRepository.findAll();
    }

    public Categories findByNameCategory(String name){
        return categoriesRepository.findByName(name);
    }

    public Categories findById(Long id){
        return categoriesRepository.findById(id).get();
    }

    public void saveNewCategory(Categories categories) {
        categoriesRepository.save(categories);
    }

    public void updateCategory(Categories categories) {  // category : id ...
        categoriesRepository.save(categories);
    }

    public void deleteCategoryById(Long id) {
        categoriesRepository.deleteById(id);
    }

    public void deleteCategory(Categories categories) {
        categoriesRepository.delete(categories);
    }

    public void deleteAllCategories() {
        categoriesRepository.deleteAll();
    }


}
