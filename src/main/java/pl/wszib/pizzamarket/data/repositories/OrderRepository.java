package pl.wszib.pizzamarket.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wszib.pizzamarket.data.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
