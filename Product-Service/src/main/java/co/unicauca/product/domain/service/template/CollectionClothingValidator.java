package co.unicauca.product.domain.service.template;

import co.unicauca.product.domain.entity.Product;

public class CollectionClothingValidator extends ProductValidator {

    @Override
    protected boolean validateLength(Product product) {
        return product.getDescription().length() > 20 ;
    }

    @Override
    protected boolean specificValidation(Product product) {
        // Lógica de validación específica para accesorios
        // Por ejemplo, podría ser validar que el producto tenga características definidas
        return product.getCharacteristics() != null && !product.getCharacteristics().isEmpty();
    }
}
