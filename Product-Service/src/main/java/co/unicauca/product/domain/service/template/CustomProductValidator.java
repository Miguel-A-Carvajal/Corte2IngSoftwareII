package co.unicauca.product.domain.service.template;

import co.unicauca.product.domain.entity.Product;

public class CustomProductValidator extends ProductValidator {

    @Override
    protected boolean validateLength(Product product) {
        return product.getDescription().length() > 30 ;
    }

    @Override
    protected boolean specificValidation(Product product) {
        // Lógica de validación específica para accesorios
        // Por ejemplo, podría ser validar que el producto tenga características definidas
        return product.getDescription() != null && product.getDescription().isEmpty() ;
    }
}