package co.unicauca.product.domain.service.template;

import co.unicauca.product.domain.entity.Category;
import co.unicauca.product.domain.entity.Product;
import co.unicauca.product.domain.service.EnumErrorCodes;
import co.unicauca.product.presentation.rest.exceptions.ProductDomainException;
import co.unicauca.product.presentation.rest.exceptions.ProductError;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ProductValidator {

    // Template method
    public final List<ProductError> validate(Product product) {
        List<ProductError> errors = new ArrayList<>();

        if (!specificValidation(product)) {
            errors.add(new ProductError(EnumErrorCodes.EMPTY_OR_NULL_FIELD, "name", "Uno de los campos esta vacio o es nulo"));
        }

        if (!validateStock(product)) {
            errors.add(new ProductError(EnumErrorCodes.INVALID_STOCK, "name", "EL stock no puede ser menor a cero"));
        }

        if (!validateCategories(product)) {
            errors.add(new ProductError(EnumErrorCodes.EMPTY_OR_NULL_FIELD, "name", "La categoria es vacia o es nula"));
        }

        if(!validateLength(product)){
            errors.add(new ProductError(EnumErrorCodes.INVALID_LENGTH, "name", "La longitud de los caracteres de la descripcion del producto es invalido"));
        }
        
        return errors;
    }

    protected boolean validateCategories(Product product){
        List<Category> categories = product.getCategories();
        return categories != null && !categories.isEmpty();
    }

    protected boolean validateStock(Product product){
        return product.getStock() > 0;
    }

    protected abstract boolean validateLength(Product product);

    // Métodos abstractos que deben ser implementados por las subclases
    protected abstract boolean specificValidation(Product product);
}

