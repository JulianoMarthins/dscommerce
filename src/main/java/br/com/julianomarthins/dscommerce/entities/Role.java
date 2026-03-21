package br.com.julianomarthins.dscommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_role")
public class Role {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;


    // Construtores
    public Role(Long id, String authority){
        this.id = id;
        this.authority = authority;
    }

    public Role(){

    }


    // Equals & Hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;
        return authority.equals(role.authority);
    }

    @Override
    public int hashCode() {
        return authority.hashCode();
    }


    // Getters & Setters
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setAuthprity(String authority){
        this.authority = authority;
    }
    public String getAuthority(){
        return this.authority;
    }
}
