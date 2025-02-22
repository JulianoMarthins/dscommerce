package br.com.julianomarthins.dscommerce.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity // Annotation serve para criar uma tabela desta classe no banco de dados
@Table(name = "tb_category") // Annotation serve para nomear a tabela do banco de dados
public class Category {

    // Atributos de classe
    @Id // Annotation serve para tornar o atributo abaixo, uma chave primária no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation serve para gerar automaticamente as ID conform indentação
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


    // Equals & HashCode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    // Getters & Setters

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
}
