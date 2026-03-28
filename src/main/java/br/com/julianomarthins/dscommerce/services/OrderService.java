package br.com.julianomarthins.dscommerce.services;


import br.com.julianomarthins.dscommerce.dto.OrderDTO;
import br.com.julianomarthins.dscommerce.entities.Order;

import br.com.julianomarthins.dscommerce.respositories.OrderRepository;
import br.com.julianomarthins.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }


}
