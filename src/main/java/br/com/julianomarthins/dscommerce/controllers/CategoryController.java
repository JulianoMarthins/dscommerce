package br.com.julianomarthins.dscommerce.controllers;

import br.com.julianomarthins.dscommerce.dto.CategoryDTO;
import br.com.julianomarthins.dscommerce.dto.ProductDTO;
import br.com.julianomarthins.dscommerce.dto.ProductMinDTO;
import br.com.julianomarthins.dscommerce.services.CategoryService;
import br.com.julianomarthins.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    // Esta annotation serve para auto instanciar o objeto ProductServe.
    @Autowired
    private CategoryService service;


    // Retorna todos os produtos ao usuário
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {

        List<CategoryDTO> lista = service.findAll();

        return ResponseEntity.ok(lista);
    }

}
