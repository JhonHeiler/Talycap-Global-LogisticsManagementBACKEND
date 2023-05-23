package com.talycapglobal.LogisticsManagement.domain.usecase;

import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.model.Rol;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.ClienteRepository;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final RolRepository rolRepository;

    public ClienteService(ClienteRepository clienteRepository, RolRepository rolRepository) {
        this.clienteRepository = clienteRepository;
        this.rolRepository = rolRepository;
    }

    public List<Cliente> getAllClient() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }


    public Cliente getClientByCredentials(Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(cliente.getEmail());

        if (clienteOptional.isPresent()) {
            Cliente clienteEncontrado = clienteOptional.get();

            String passwordHashed = clienteEncontrado.getPassword();

            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            if (argon2.verify(passwordHashed, cliente.getPassword())) {
                return clienteEncontrado;
            }
        }
        return null;
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void update(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
    }

}



