import java.io.*;
import java.util.*;

public class Main {

    public static List<Maquina> leerDesdeArchivo(String nombreArchivo, int[] objetivo) throws Exception {
        List<Maquina> maquinas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            objetivo[0] = Integer.parseInt(br.readLine());
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                maquinas.add(new Maquina(partes[0], Integer.parseInt(partes[1])));
            }
        }
        return maquinas;
    }
    
    public static void main(String[] args) throws Exception {
        int[] objetivo = new int[1];
        List<Maquina> maquinas = leerDesdeArchivo("input.txt", objetivo);
        
        // Backtrack
        List<Maquina> backtrackSol = Backtrack.backtrack(maquinas, objetivo[0]);
        System.out.println("Backtrack:");
        System.out.println("Cantidad de arranques: " + backtrackSol.size()); 
        System.out.println("Secuencia: " + backtrackSol);
        System.out.println("Estados generados: " + Backtrack.getEstadosGenerados());
        
        // Greedy
        List<Maquina> greedySol = Greedy.greedy(maquinas, objetivo[0]);
        
        for (Maquina m : greedySol)
         m.getCantPiezas();
        
        System.out.println("Greedy:");
        System.out.println("Cantidad de arranques: " + greedySol.size()); 
        System.out.println("Secuencia: " + greedySol);
        System.out.println("Candidatos considerados: " + Greedy.getCandidatosConsiderados());
    }
}

