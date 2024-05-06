package co.unicauca.user.domain.service;

import co.unicauca.user.domain.entity.Rol;
import co.unicauca.user.presentation.rest.exceptions.UsuarioDomainException;
import co.unicauca.user.presentation.rest.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IRolService {
    public List<Rol> findAll();

    public Rol findById(Long id) throws ResourceNotFoundException;

    public Rol create(Rol rol) throws UsuarioDomainException;

    public Rol update(Long id, Rol rol) throws UsuarioDomainException, ResourceNotFoundException;

    public void deleteById(Long id) throws ResourceNotFoundException;
}
