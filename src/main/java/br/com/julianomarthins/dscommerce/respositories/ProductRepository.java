package br.com.julianomarthins.dscommerce.respositories;

import br.com.julianomarthins.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
