package br.com.ada.adabook.controller;

import br.com.ada.adabook.domain.User;
import br.com.ada.adabook.dto.DataTokenJWT;
import br.com.ada.adabook.dto.user.UserLogin;
import br.com.ada.adabook.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("login")
public class AuthenticationController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @PostMapping
    public DataTokenJWT login(@RequestBody @Valid UserLogin userLogin) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(userLogin.getLogin(), userLogin.getPassword());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return new DataTokenJWT(tokenJWT);
    }

}
