package br.com.julianomarthins.dscommerce.respositories;


import br.com.julianomarthins.dscommerce.entities.OrderItem;
import br.com.julianomarthins.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {



}
