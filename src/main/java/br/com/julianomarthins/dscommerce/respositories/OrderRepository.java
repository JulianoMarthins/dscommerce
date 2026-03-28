package br.com.julianomarthins.dscommerce.respositories;


import br.com.julianomarthins.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {



}
