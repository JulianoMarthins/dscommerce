package br.com.julianomarthins.dscommerce.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category {

    // Atributos de classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Nesta annotation é mapeada pelo atributo de products criado para a relação, neste caso, o atributo categories.
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();


    // Construtores
    public Category() {

    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    // region Getters & Setters

    public Set<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // endregion
}
