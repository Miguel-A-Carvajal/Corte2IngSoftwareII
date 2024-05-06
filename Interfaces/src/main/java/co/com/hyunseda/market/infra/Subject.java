package co.com.hyunseda.market.infra;

import java.util.ArrayList;

/**
 * @brief Clase abstracta que representa un sujeto observado.
 */
public abstract class Subject {

    // Atributos
    ArrayList<Observer> observers; ///< Lista de observadores.

    /**
     * @brief Constructor de la clase Subject.
     */
    public void Subject() {

    }

    /**
     * @brief Agrega un observador.
     * @param obs El observador a agregar.
     */
    public void addObserver(Observer obs) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(obs);
    }

    /**
     * @brief Notifica a todos los observadores que hubo un cambio en el modelo.
     */
    public void notifyAllObserves() {
        for (Observer each : observers) {
            each.update(this);
        }
    }

}