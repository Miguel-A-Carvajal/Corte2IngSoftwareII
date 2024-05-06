package co.unicauca.user.presentation.rest;

import co.unicauca.user.domain.entity.Rol;
import co.unicauca.user.domain.service.IRolService;
import co.unicauca.user.presentation.rest.exceptions.UsuarioDomainException;
import co.unicauca.user.presentation.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
public class RolController {
    @Autowired
    private IRolService RolService;

    /**
     * Listar todos
     *
     * @return listado de categorias en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Rol> findAll() {
        return (List<Rol>) RolService.findAll();
    }

    /**
     * Listar un producto por id
     *
     * @param id_rol identificador
     * @return Categoria en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id_rol}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Rol findById(@PathVariable Long id_rol) throws ResourceNotFoundException {

        Rol rol = RolService.findById(id_rol);
        return rol;
    }

    /**
     * Crear un producto
     *
     * @param rol producto
     * @return producto creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Rol create(@RequestBody Rol rol) throws UsuarioDomainException {
        return RolService.create(rol);
    }

    /**
     * Editar
     *
     * @param rol Producto a editar
     * @param id_rol      identificador del producto
     * @return producto editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id_rol}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Rol update(@RequestBody Rol rol, @PathVariable Long id_rol)
            throws UsuarioDomainException, ResourceNotFoundException {
        return RolService.update(id_rol, rol);
    }

    /**
     * Eliminar
     *
     * @param id_rol id del producto
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id_rol}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id_rol) throws ResourceNotFoundException {
        RolService.deleteById(id_rol);
    }
}
