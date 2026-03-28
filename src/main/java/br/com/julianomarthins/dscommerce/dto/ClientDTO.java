package br.com.julianomarthins.dscommerce.dto;


import br.com.julianomarthins.dscommerce.entities.User;

public class ClientDTO {

    // Atributos
    private Long id;
    private String name;

    // Construtores
    public ClientDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }


    // Getters
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}
