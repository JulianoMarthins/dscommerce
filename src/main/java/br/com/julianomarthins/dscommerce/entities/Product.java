package br.com.julianomarthins.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product {

    // Atributos de classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "TEXT") // Configura o banco de dados para textos com mais de 255 caracteres
    private String description;
    private Double price;
    private String imgUrl;

    /*
     Para a associação entre duas classes no relacionamento muitos para muitos, não poder ser utilizado listas, isso
     porque, não pode haver ID's repetidas entre a tabela que será criada para a associação, e as classes produtos
     e categoria. Para solucionar este problema, deve ser usar um Set.
     */

    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    /*
     Acima temos a annotation @JoinTable, nela dado os dados para a criação da tabela de associação entre as classes
     O primeiro argumento, name, é o nome dado a tabela gerada
     O segundo argumento, joinColumns recebe a annotation @JoinColumn, em que é passada o nome da classe em que estamos,
     seguido de id, o mesmo é feito para o terceiro argumento em que é passada a coluna inversa, ou seja, a classe em que
     estamos associando, neste caso, category_id
    */


    // Construtores
    public Product() {

    }

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }


    //Equals & HashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    // Getters & Setters

    public Set<Category> getCategories() {
        return categories;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    // Neste código é feito uma conversão de uma estrutura de dados do tipo HashSet para um List.
    // Acessamos o items com o .stream(), e percorremos cada elemento do HashSet usando o map, neste,
    // é feito uma expressão lambda para pegar cada objeto do tipo order e depois convertendo ele para uma lista.
    public List<Order> getOrders() {
        return this.items.stream().map(OrderItem::getOrder).toList();
    }
}
