package br.com.julianomarthins.dscommerce.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity // Cria associação da classe com banco de dados.
@Table(name = "tb_user") // Define o nome da tabela no banco de dados.
public class User {

    // Atributos de classe

    @Id // Define como chave primária no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente a id por indentação.
    private Long id;
    private String name;

    @Column(unique = true) // Configura a coluna email como única no banco de dados.
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;

    // private String roles; TODO -> Realizar implementação durante programação da segurança do sistema.

    @OneToMany(mappedBy = "client") // Relação um cliente para muitos pedidos
    private List<Order> orders = new ArrayList<>();


    // Construtores
    public User() {

    }

    public User(Long id, String name, String email, String phone, LocalDate birthDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
    }


    // region Getters & Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }
    // endregion
}
