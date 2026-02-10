package ua.com.kisit.course2026np.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.course2026np.entity.ProductsHasOrder;
import ua.com.kisit.course2026np.repository.ProductHasOrderRepository;

@Service
@RequiredArgsConstructor
public class ProductHasOrderService {
    private final ProductHasOrderRepository productHasOrderRepository;

    public void saveNewProductsHasOrderToDB(ProductsHasOrder productsHasOrder) {
        productHasOrderRepository.save(productsHasOrder);
    }

}
