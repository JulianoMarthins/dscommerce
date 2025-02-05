package br.com.julianomarthins.dscommerce.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;

@Entity // Cria associação com banco de dados.
@Table(name="tb_user") // Define o nome da tabela no banco de dados.
public class User {

    // Atributos de classe
    @Id // Define chave primária no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente a id da classe por indentação.
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    // private String roles; -> Realizar implementação durante programação da segurança do sistema.


    // Construtores
    public User(){

    }

    public User(String name, String email, String phone, LocalDate birthDate, String password){
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
    // endregion
}
