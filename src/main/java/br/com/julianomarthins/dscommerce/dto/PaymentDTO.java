package br.com.julianomarthins.dscommerce.dto;

import br.com.julianomarthins.dscommerce.entities.Payment;

import java.time.Instant;
import java.time.LocalDate;

public class PaymentDTO {

    // Atributos
    private Long id;
    private Instant moment;


    // construtores
    public PaymentDTO(Long id, Instant moment){
        this.id = id;
        this.moment = moment;
    }

    public PaymentDTO(Payment entity){
        this.id = entity.getId();
        this.moment = entity.getMoment();
    }


    // Getters
    public Long getId(){
        return this.id;
    }

    public Instant getMoment(){
        return this.moment;
    }
}
