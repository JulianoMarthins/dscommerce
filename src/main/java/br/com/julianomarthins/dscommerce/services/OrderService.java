package br.com.julianomarthins.dscommerce.services;


import br.com.julianomarthins.dscommerce.dto.OrderDTO;
import br.com.julianomarthins.dscommerce.dto.OrderItemDTO;
import br.com.julianomarthins.dscommerce.entities.Order;

import br.com.julianomarthins.dscommerce.entities.OrderItem;
import br.com.julianomarthins.dscommerce.entities.Product;
import br.com.julianomarthins.dscommerce.entities.User;
import br.com.julianomarthins.dscommerce.enuns.OrderStatus;
import br.com.julianomarthins.dscommerce.respositories.OrderItemRepository;
import br.com.julianomarthins.dscommerce.respositories.OrderRepository;
import br.com.julianomarthins.dscommerce.respositories.ProductRepository;
import br.com.julianomarthins.dscommerce.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    // Injeções de dependências
    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AuthService authService;


    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));

        authService.validateSelfOrAdmin(order.getClient().getId());

        return new OrderDTO(order);
    }


    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for (OrderItemDTO itemDTO : dto.getItems()){
            Product product = productRepository.getReferenceById(itemDTO.getProductId());

            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        System.out.println("\nNúmero de itens na lista: " + order.getItems().size() + "\n");
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
