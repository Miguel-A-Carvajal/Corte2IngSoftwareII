package co.com.hyunseda.market.infra;

/**
 * Interfaz Observer que define el método para actualizar los observadores.
 */
public interface Observer {
    
    /**
     * Método para actualizar los observadores.
     * @param o Objeto que contiene la información actualizada.
     */
    public void update(Object o);
   
}
