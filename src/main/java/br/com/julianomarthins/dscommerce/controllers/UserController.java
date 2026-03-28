package br.com.julianomarthins.dscommerce.controllers;


import br.com.julianomarthins.dscommerce.dto.UserDTO;
import br.com.julianomarthins.dscommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    // Esta annotation serve para auto instanciar o objeto ProductServe.
    @Autowired
    private UserService service;

    // Retorna a pesquisa de um produto pelo ID

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> getMe() {
        UserDTO dto = service.getME();
        return ResponseEntity.ok(dto);
    }
}
