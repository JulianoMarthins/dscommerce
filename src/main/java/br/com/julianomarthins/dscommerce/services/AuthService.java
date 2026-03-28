package br.com.julianomarthins.dscommerce.services;

import br.com.julianomarthins.dscommerce.entities.User;
import br.com.julianomarthins.dscommerce.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(Long userId){
        User self = userService.authenticated();

        if (!self.hasRole("ROLE_ADMIN") && !self.getId().equals(userId)) {
            throw new ForbiddenException("Acesso negado");
        }
    }


}
