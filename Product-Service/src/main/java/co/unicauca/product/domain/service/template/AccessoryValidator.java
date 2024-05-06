package co.unicauca.product.domain.service.template;

import co.unicauca.product.domain.entity.Product;

public class AccessoryValidator extends ProductValidator {

    @Override
    protected boolean validateLength(Product product) {
        return product.getDescription().length() > 10 ;
    }

    @Override
    protected boolean specificValidation(Product product) {
        // Lógica de validación específica para accesorios
        // Por ejemplo, podría ser validar que el producto tenga características definidas
        return product.getKeyWords() != null && !product.getKeyWords().isEmpty();
    }
}