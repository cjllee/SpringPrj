// OrderService.java

package order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Long createOrder(OrderForm form) {
        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Order order = Order.builder()
                .name(form.getName())
                .address(address)
                .build();

        orderRepository.save(order);
        return order.getId();
    }

    public Order findById(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        if (order == null) {
            throw new RuntimeException("주문 번호를 찾을수 없음: " + orderId);
        }
        return order;
    }

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Transactional
    public void updateOrder(Long id, OrderForm form){
        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Order existingOrder = findById(id);
        existingOrder.setName(form.getName());
        existingOrder.setAddress(address);
    }

    @Transactional
    public void deleteOrder(Long id){
        this.orderRepository.delete(id);
    }
}