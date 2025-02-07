package br.com.julianomarthins.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity // Mapeia classe como entidade do banco de dados
@Table(name = "tb_payment") // Nomeia tabela no banco de dados
public class Payment {

    // Atributos de Classe
    @Id // Cria este id como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente a id conforme indentação
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    // Utilizada o timezone de londres, padrão em banco de dados
    private Instant moment;

    @OneToOne // Cria relação um para um entre payment e order.
    @MapsId // Mapeia pelas chaves primarias das duas classes
    private Order order;


    // Construtores
    public Payment() {

    }

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }


    // Equals & HashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
