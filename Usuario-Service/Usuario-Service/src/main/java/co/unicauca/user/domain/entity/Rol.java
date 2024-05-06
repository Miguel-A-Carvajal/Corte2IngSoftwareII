package co.unicauca.user.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @file Rol.java
 * @brief Define la clase Rol que representa un rol de usuario en la tienda.
 *
 * Esta clase representa un rol de usuario en la tienda y está mapeada con la base de datos.
 * Fue creada y mantenida por wpantoja y ahurtado.
 */

/**
 * @class Rol
 * @brief Clase que representa un rol de usuario en la tienda.
 *
 * La clase Rol representa un rol de usuario en la tienda. Cada rol tiene un identificador único,
 * un nombre y puede estar asociado a varios usuarios.
 */
@Entity
@Table(name = "Rol")
public class Rol {

    /**
     * @brief Identificador único del rol.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    /**
     * @brief Nombre del rol.
     */
    private String name;

    /**
     * @brief Lista de usuarios asociados a este rol.
     *
     * Esta lista contiene los usuarios que tienen asignado este rol. Se carga de manera perezosa
     * y no se incluye en las operaciones de serialización.
     */
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<Usuario> usuarios = new ArrayList<>();


    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
