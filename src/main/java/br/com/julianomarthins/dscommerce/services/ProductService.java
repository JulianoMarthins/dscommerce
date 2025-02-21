package br.com.julianomarthins.dscommerce.services;

import br.com.julianomarthins.dscommerce.dto.ProductDTO;
import br.com.julianomarthins.dscommerce.entities.Product;
import br.com.julianomarthins.dscommerce.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

}
