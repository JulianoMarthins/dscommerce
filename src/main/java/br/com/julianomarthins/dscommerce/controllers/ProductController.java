package br.com.julianomarthins.dscommerce.controllers;

import br.com.julianomarthins.dscommerce.dto.ProductDTO;
import br.com.julianomarthins.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    // Esta annotation serve para auto instanciar o objeto ProductServe.
    @Autowired
    private ProductService service;

    // Mapeia esta função como "GET", o valor no argumento é o caminho do endpoint.
    @GetMapping(value = "/{id}")
   public ProductDTO findById(@PathVariable Long id){ // Annotation PathVariable torta a variável Long id como o valor do caminho do produto
        return service.findById(id);
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO dto){
        return service.insert(dto);

    }


}
