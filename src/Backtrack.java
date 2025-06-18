
import java.util.*;
/*
/*
 * Estrategia Backtracking:
 *  El árbol de exploración se genera probando en cada nodo la elección de cada máquina disponible para producir piezas.
 *  Cada estado representa la cantidad de piezas producidas hasta el momento y la secuencia de máquinas usadas.
 *  Los estados solución son aquellos donde la producción acumulada es igual o superior a la cantidad total requerida.
 *  Se aplican podas para no explorar ramas que ya superan la cantidad mínima de arranques encontrada y para no producir más piezas que el objetivo.
 *  Se lleva un contador de estados generados para medir el costo computacional.
 *  Estrategia de Backtrack con Poda:
 *  Vamos explorando combinaciones de maquinaria.
 *  Podamos cuando:
 *   1) Superamos el objetivo de piezas.
 *   2) La cantidad de arranques usados es mayor o igual al tamaño de la mejor solución actual.
 *  Esto evita explorar soluciones que van a ser menos eficientes de antemano.
 */
public class Backtrack {

    private static int estadosGenerados;
    private static List<Maquina> mejor = null;

    public static List<Maquina> backtrack(List<Maquina> maquinas, int objetivo) {
        estadosGenerados = 0;
        mejor = null;
        backtrackPrivada(maquinas, objetivo, new ArrayList<>(), 0, 0);
        return mejor;
    }
  
    private static void backtrackPrivada(List<Maquina> maquinas, int objetivo, List<Maquina> actual, int suma, int index) {
       
        estadosGenerados++;
        // Podas:

        if (suma == objetivo) {
            if (mejor == null || actual.size() < mejor.size()) {
                mejor = new ArrayList<>(actual);
            }
            return;
        }

         
        if(suma > objetivo){
            return;
        }

        if (mejor != null && actual.size() >= mejor.size()) {
            return;
        }

        for (int i = index ; i< maquinas.size(); i++) {
            Maquina m = maquinas.get(i);
            if (suma + m.getCantPiezas() > objetivo) {
                continue; // otra poda , va a evitar agregar una maquina que ya sabes que va a hacer que te pases del objetivo.
            }
            actual.add(m);
            backtrackPrivada(maquinas, objetivo, actual, suma + m.getCantPiezas(),i); 
            actual.remove(actual.size() - 1);
        }
    }
  
    public static int getEstadosGenerados(){
        return estadosGenerados;
    }
}

