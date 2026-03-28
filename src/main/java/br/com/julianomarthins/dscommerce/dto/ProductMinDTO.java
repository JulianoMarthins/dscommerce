package br.com.julianomarthins.dscommerce.dto;

import br.com.julianomarthins.dscommerce.entities.Product;


public class ProductMinDTO {

    // Atributos
    private Long id;
    private String name;
    private Double price;
    private String img;


    // Construtores
   public ProductMinDTO(){

   }
    public ProductMinDTO(Long id, String name, Double price, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }


    public ProductMinDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.img = entity.getImgUrl();
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }
}
