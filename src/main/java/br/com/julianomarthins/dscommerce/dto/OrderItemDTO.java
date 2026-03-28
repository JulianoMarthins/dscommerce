package br.com.julianomarthins.dscommerce.dto;

import br.com.julianomarthins.dscommerce.entities.OrderItem;

public class OrderItemDTO {

    // Atributos
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;

    // Construtores
    public OrderItemDTO(Long productId, String name, Double price, Integer quantity){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem entity){
        this.productId = entity.getProduct().getId();
        this.name = entity.getProduct().getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
    }

    // Getter
    public Long getProductId(){
        return this.productId;
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


    // Métodos
    public Double getSubTotal(){
        return this.price * this.quantity;
    }
}
