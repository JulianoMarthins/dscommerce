package br.com.julianomarthins.dscommerce.entities;

import br.com.julianomarthins.dscommerce.enuns.OrderStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity // Transforma a classe em tabela no banco de dados
@Table(name = "tb_order") // Nome a tabela conforme parâmetro passado em argumento
public class Order {

    // Atributos da classe
    @Id // Define a a id como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente a id da classe por indentação.
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") // Usa o fuso horário padrão pra banco de dados
    private Instant moment;
    private OrderStatus status;

    @ManyToOne// Cria relação de muitos pedidos para um cliente (na classe pedido, muitos pedidos para um cliente)
    @JoinColumn(name = "client_id") // Cria a chave estrangeira para ligar as duas tabelas desta relação.
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();


    // Construtores
    public Order() {

    }

    public Order(Long id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;

    }


    // Equals & HashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return Objects.equals(id, order.id);
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Product> getProducts() {
        return this.items.stream().map(OrderItem::getProduct).toList();
    }
}
