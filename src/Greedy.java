import java.util.*;
/*
 *  * Estrategia Greedy:
 *  Los candidatos son las máquinas disponibles.
 *  En cada paso se selecciona la máquina que produce la mayor cantidad de piezas posible sin exceder el objetivo restante.
 *  La secuencia se arma acumulando máquinas hasta cubrir o superar el objetivo.
 *  No garantiza solución óptima pero es eficiente en tiempo.
 *  Se lleva un contador de candidatos considerados para medir el costo computacional.
 */
public class Greedy {

    private static int candidatosConsiderados;

    public static List<Maquina> greedy(List<Maquina> maquinas, int objetivo) {
        List<Maquina> resultado = new ArrayList<>();
        List<Maquina> ordenadas = new ArrayList<>(maquinas);

        Comparator<Maquina> comparador = new Comparator<Maquina>() { // ordeno las maquinas de mayor a menor segun la cantidad de pizas que producen.
            @Override
            public int compare(Maquina m1, Maquina m2) {
                return m2.getCantPiezas() - m1.getCantPiezas();
            }
        };
        
        ordenadas.sort(comparador);

        int suma = 0;
        candidatosConsiderados = 0;

        while (suma < objetivo) {
            for (Maquina m : ordenadas) {
                candidatosConsiderados++;
                if(suma + m.getCantPiezas() <= objetivo){
                resultado.add(m);
                suma += m.getCantPiezas();
                break;
                }
            }
        
        }
        
        return resultado;
    }
  
    public static int getCandidatosConsiderados(){
        return candidatosConsiderados;
    }
}
