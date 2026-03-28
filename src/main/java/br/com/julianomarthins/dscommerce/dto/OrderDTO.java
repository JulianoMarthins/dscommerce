package br.com.julianomarthins.dscommerce.dto;

import br.com.julianomarthins.dscommerce.entities.Order;
import br.com.julianomarthins.dscommerce.entities.OrderItem;
import br.com.julianomarthins.dscommerce.enuns.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    // Atributos
    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;
    private PaymentDTO payment;

    @NotEmpty(message = "Deve ter ao menos uma item")
    private List<OrderItemDTO> items = new ArrayList<>();


    // Construtores
    public OrderDTO(){

    }

    public OrderDTO(
            Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment){
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order entity){
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();

        this.client = new ClientDTO(entity.getClient());
        this.payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());

        for (OrderItem item : entity.getItems()) {
            items.add(new OrderItemDTO(item));
        }

    }

    // Getters
    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    // Métodos
    public Double getTotal(){
        double sum = 0.0;

        for (OrderItemDTO item : items){
            sum += item.getSubTotal();
        }

        return sum;
    }
}
