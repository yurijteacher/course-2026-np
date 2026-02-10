package ua.com.kisit.course2026np.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.course2026np.entity.Orders;
import ua.com.kisit.course2026np.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Orders saveNewOrder(Orders orders) {
        return orderRepository.save(orders);
    }

    public Orders findById(Long id) {
        return orderRepository.findById(id).get();
    }
}
