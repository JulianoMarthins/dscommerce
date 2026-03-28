package br.com.julianomarthins.dscommerce.dto;

import br.com.julianomarthins.dscommerce.entities.OrderItem;

public class OrderItemDTO {

    // Atributos da classe
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;
    private String imgUrl;


    // Construtores
    public OrderItemDTO(){
    }

    public OrderItemDTO(Long productId, String name, Double price, Integer quantity, String imgUrl){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }

    public OrderItemDTO(OrderItem entity){
        this.productId = entity.getProduct().getId();
        this.name = entity.getProduct().getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
        this.imgUrl = entity.getProduct().getImgUrl();
    }

    // Getters
    public Long getProductId(){
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    // Setters
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal(){
        return price * quantity;
    }


}
