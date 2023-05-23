package com.talycapglobal.LogisticsManagement.infrastruture.entrypoints;

import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.usecase.ClienteService;
import com.talycapglobal.LogisticsManagement.config.JWTUtil;
import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.input.ClienteInput;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthenticationController {

    private final ClienteService clienteService;


    private final JWTUtil jwtUtil;

    public AuthenticationController(ClienteService clienteService, JWTUtil jwtUtil) {
        this.clienteService = clienteService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody ClienteInput clienteInput ) {
        Cliente usuarioLogueado = clienteService.getClientByCredentials(ClienteInput.toCliente(clienteInput));
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }
}
