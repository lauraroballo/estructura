package matricesPrincipal;


import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int[][] ventas = new int[VentasEmpresa.sedes][VentasEmpresa.dias.length];
        Scanner scanner = new Scanner(System.in);

        VentasEmpresa.llenarMatriz(ventas, scanner);

        VentasEmpresa.mostrarDias_encimaMedia(ventas);
        VentasEmpresa.calcularMedia(ventas);
        VentasEmpresa.aumentoPorDebajoMedia(ventas);

        System.out.println("\nMATRICES DE VENTAS");
        mostrarMatricesVentas(ventas, VentasEmpresa.calcularMatrizConAumento(ventas));

        scanner.close();
    }

    static void mostrarMatricesVentas(int[][] ventas, int[][] ventasConAumento) {
        System.out.println("Matriz de ventas" + ":");
        VentasEmpresa.mostrarMatrizVentas(ventas);

        System.out.println("\nMatriz de ventas con aumento del 15%:");
        VentasEmpresa.mostrarMatrizVentas(ventasConAumento);
    }
}


