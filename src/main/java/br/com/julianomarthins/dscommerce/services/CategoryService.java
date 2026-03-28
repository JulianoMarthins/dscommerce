package br.com.julianomarthins.dscommerce.services;


import br.com.julianomarthins.dscommerce.dto.CategoryDTO;
import br.com.julianomarthins.dscommerce.dto.ProductDTO;
import br.com.julianomarthins.dscommerce.dto.ProductMinDTO;
import br.com.julianomarthins.dscommerce.entities.Category;
import br.com.julianomarthins.dscommerce.entities.Product;
import br.com.julianomarthins.dscommerce.exceptions.DatabaseException;
import br.com.julianomarthins.dscommerce.exceptions.ResourceNotFoundException;
import br.com.julianomarthins.dscommerce.respositories.CategoryRepository;
import br.com.julianomarthins.dscommerce.respositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryService {

    // Atributo
    @Autowired
    private CategoryRepository repository;



    // Retorna ao usuário todos os produtos organizados por páginas
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(CategoryDTO::new).toList();
    }


}
