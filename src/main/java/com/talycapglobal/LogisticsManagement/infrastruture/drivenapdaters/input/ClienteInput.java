package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.input;

import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.model.Rol;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.RolRepository;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ClienteInput {
    private static RolRepository rolRepository;

    public ClienteInput(RolRepository rolRepository) {
        ClienteInput.rolRepository = rolRepository;
    }

    @NotBlank
    private String nombre;
    @NotBlank
    private String direccion;
    @NotBlank
    private String telefono;
    @NotBlank
    private String gmail;
    @NotBlank
    private String password;
    @NotBlank
    private Long rolId;



    public static ClienteInput validacion(ClienteInput clienteInput) {
        if (clienteInput == null) {
            throw new IllegalArgumentException("Cliente no puede ser nulo");
        }
        ClienteInput validarInput = new ClienteInput(rolRepository);
        validarInput.setNombre(clienteInput.getNombre());
        validarInput.setDireccion(clienteInput.getDireccion());
        validarInput.setTelefono(clienteInput.getTelefono());
        validarInput.setGmail(clienteInput.getGmail());
        validarInput.setPassword(clienteInput.getPassword());
        validarInput.setRolId(clienteInput.getRolId());
        return validarInput;
    }

    public static Cliente toCliente(ClienteInput clienteInput) {
        ClienteInput validate = validacion(clienteInput);
        Cliente cliente = new Cliente();
        cliente.setNombre(validate.getNombre());
        cliente.setDireccion(validate.getDireccion());
        cliente.setTelefono(validate.getTelefono());
        cliente.setEmail(validate.getGmail());
        cliente.setPassword(validate.getPassword());
        Optional<Rol> rolOptional = rolRepository.findById(validate.getRolId());
        if (rolOptional.isPresent()) {
            cliente.setRol(rolOptional.get());
        } else {
            throw new IllegalArgumentException("Rol no encontrado");
        }
        return cliente;
    }
}
