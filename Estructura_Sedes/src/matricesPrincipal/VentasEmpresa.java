package matricesPrincipal;

import java.util.Scanner;

public class VentasEmpresa {
    static final int sedes = 6;
    static final String[] dias = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};

    static void llenarMatriz(int[][] ventas, Scanner scanner) {
        for (int sede = 0; sede < sedes; sede++) {
            System.out.println("\nIngrese las ventas para la sede " + (sede + 1) + ":");
            for (int dia = 0; dia < dias.length; dia++) {
                System.out.print(dias[dia] + ": ");
                ventas[sede][dia] = scanner.nextInt();
            }
        }
    }

    static void mostrarDias_encimaMedia(int[][] ventas) {
        System.out.println("\nDías con ventas totales diarias POR ENCIMA DE LA MEDIA :");
        for (int dia = 0; dia < dias.length; dia++) {
            int sumaVentas = 0;
            for (int sede = 0; sede < sedes; sede++) {
                sumaVentas += ventas[sede][dia];
            }
            double media = (double) sumaVentas / sedes;

            for (int sede = 0; sede < sedes; sede++) {
                if (ventas[sede][dia] > media) {
                    System.out.println(dias[dia] + ", Sede " + (sede + 1));
                }
            }
        }
    }

    static void calcularMedia(int[][] ventas) {
        double totalVentasSemana = 0;
        System.out.println("\nPromedio de ventas por sede:");

        for (int sede = 0; sede < sedes; sede++) {
            double sumaVentasSede = 0;
            for (int dia = 0; dia < dias.length; dia++) {
                sumaVentasSede += ventas[sede][dia];
                totalVentasSemana += ventas[sede][dia];
            }
            double promedioSede = sumaVentasSede / dias.length;
            System.out.println("Sede " + (sede + 1) + ": " + promedioSede);
        }

        double promedioTotalSemana = totalVentasSemana / (sedes * dias.length);
        System.out.println("\nPromedio total de ventas en la semana: " + promedioTotalSemana);
    }

    static void aumentoPorDebajoMedia(int[][] ventas) {
        System.out.println("\nDías con ventas totales diarias POR DEBAJO DE LA MEDIA:");
        for (int dia = 0; dia < dias.length; dia++) {
            int sumaVentas = 0;
            for (int sede = 0; sede < sedes; sede++) {
                sumaVentas += ventas[sede][dia];
            }
            double media = (double) sumaVentas / sedes;

            for (int sede = 0; sede < sedes; sede++) {
                if (ventas[sede][dia] < media) {
                    System.out.println(dias[dia] + ", Sede " + (sede + 1));
                }
            }
        }
    }

    static int[][] calcularMatrizConAumento(int[][] ventas) {
        int[][] ventasConAumento = new int[sedes][dias.length];
        for (int dia = 0; dia < dias.length; dia++) {
            int sumaVentas = 0;
            for (int sede = 0; sede < sedes; sede++) {
                sumaVentas += ventas[sede][dia];
            }
            double media = (double) sumaVentas / sedes;

            for (int sede = 0; sede < sedes; sede++) {
                if (ventas[sede][dia] < media) {
                    ventasConAumento[sede][dia] = (int) (ventas[sede][dia] * 1.15);
                } else {
                    ventasConAumento[sede][dia] = ventas[sede][dia];
                }
            }
        }
        return ventasConAumento;
    }

    static void mostrarMatrizVentas(int[][] ventas) {
    System.out.print("\t");
    for (String dia : dias) {
        System.out.print(String.format("%-12s", dia));
    }
    System.out.println();

    for (int sede = 0; sede < sedes; sede++) {
        System.out.print("Sede " + (sede + 1) + ": ");
        for (int dia = 0; dia < dias.length; dia++) {
            System.out.print(String.format("%-12d", ventas[sede][dia]));
        }
        System.out.println();
    }
}

}
