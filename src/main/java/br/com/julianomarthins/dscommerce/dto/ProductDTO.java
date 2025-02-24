package br.com.julianomarthins.dscommerce.dto;


import br.com.julianomarthins.dscommerce.entities.Product;

public class ProductDTO {

    // Atributos
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String img;


    // Construtores
   public ProductDTO(){

   }
    public ProductDTO(Long id, String name, String description, Double price, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
    }


    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
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

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }
}
