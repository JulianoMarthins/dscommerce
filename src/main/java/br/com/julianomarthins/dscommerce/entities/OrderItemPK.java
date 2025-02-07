package br.com.julianomarthins.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK {

    // Atributos de classe
   @ManyToOne
   @JoinColumn(name = "Order_id")
   private Order order;

   @ManyToOne
   @JoinColumn(name = "product_id")
   private Product product;


   // Construtor
   public OrderItemPK(){

   }


   // region Getters & Setters
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    //endregion
}
