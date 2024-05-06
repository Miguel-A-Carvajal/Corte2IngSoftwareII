package co.unicauca.user.domain.service;

import co.unicauca.user.access.dao.IRolDao;
import co.unicauca.user.domain.entity.Rol;
import co.unicauca.user.presentation.rest.exceptions.UsuarioDomainException;
import co.unicauca.user.presentation.rest.exceptions.UsuarioError;
import co.unicauca.user.presentation.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolImplService implements IRolService {
    /**
     * Inyección de producto Dao
     */
    @Autowired
    private IRolDao rolDao;
    /**
     * Servicio para buscar todas las categrias
     *
     * @return Listado de categorias
     */
    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll();
    }

    /**
     * Busca una categoria por su Id
     *
     * @param id_rol identificador del producto
     * @return objeto de tipo category
     */
    @Override // Para que esté sincronizada con la bd
    public Rol findById(Long id_rol) throws ResourceNotFoundException {
        Rol categ = rolDao.findById(id_rol).orElse(null);
        if (categ == null) {
            throw new ResourceNotFoundException();

        }
        return categ;
    }

    /**
     * Crea una nueva categoria
     *
     * @param rol categoria a crear en la bd
     * @return Cateoria creada
     */
    @Override
    @Transactional
    public Rol create(Rol rol) throws UsuarioDomainException {
        //crear excepxiones para categorias
        List<UsuarioError> errors = validateDomain(rol);

        if (!errors.isEmpty()) {
            throw new UsuarioDomainException(errors);
        }

        return rolDao.save(rol);
    }

    /**
     * Modifica o edita un producto
     *
     * @param id_rol,     identificador de la categoria a modificar
     * @param rol categoria con los datos a editar
     * @return Producto modificado
     */
    @Override
    @Transactional
    public Rol update(Long id_rol, Rol rol) throws UsuarioDomainException, ResourceNotFoundException {
        Rol categ = this.findById(id_rol);
        if (categ == null) {
            throw new ResourceNotFoundException();
        }

        List<UsuarioError> errors = validateDomain(rol);

        if (!errors.isEmpty()) {
            throw new UsuarioDomainException(errors);
        }

        categ.setName(rol.getName());

        return rolDao.save(categ);
    }

    /**
     * Aplica validaciones o reglas del dominio para un producto. Antes de ser
     * agregado o modificado.
     *
     * @param rol producto a validad
     * @return lista de errores de validación
     */

    private List<UsuarioError> validateDomain(Rol rol) {
        List<UsuarioError> errors = new ArrayList<>();

        if (rol.getName() == null || rol.getName().isBlank()) {
            errors.add(new UsuarioError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del categoria es obligatorio"));
        }

        return errors;

    }

    /**
     * Eliminar producto por su id
     *
     * @param id_rol identificador del categoria a eliminar
     */
    @Override
    @Transactional
    public void deleteById(Long id_rol) throws ResourceNotFoundException {
        Rol categ = this.findById(id_rol);
        if (categ == null) {
            throw new ResourceNotFoundException();
        }
        rolDao.deleteById(id_rol);
    }
}
