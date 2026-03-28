package br.com.julianomarthins.dscommerce.dto;

import br.com.julianomarthins.dscommerce.entities.Category;

public class CategoryDTO {

    // Atributos
    private Long id;
    private String name;


    // Construtores
    public CategoryDTO(){

    }

    public CategoryDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
