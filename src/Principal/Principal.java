package Principal;

import Modelo.Conversion;
import Modelo.HistorialConversion;
import Servicio.ConsultaMoneda;
import Servicio.Conversor;
import Servicio.IConversor;
import Servicio.NombreMonedas;


import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IConversor conversor = new Conversor(new ConsultaMoneda());
        HistorialConversion historial = new HistorialConversion();
        Set<String> MonedasDisponibles = conversor instanceof Conversor c ? c.obtenerMonedasDisponibles("USD") :
                Set.of();

        while (true) {
            mostrarMenu();
            String opcion = scanner.nextLine();

            //Mostrar opciones
            switch (opcion) {
                case "1" -> {
                    System.out.println("\nMonedas disponibles: ");
                    MonedasDisponibles.stream().sorted().forEach(codigo ->{
                        String nombre = NombreMonedas.nombres.getOrDefault(codigo,"(Nombre no disponible)");
                        System.out.println("* " + codigo + " - "+nombre);
                    });
                    System.out.println("\n");
                }
                case "2" -> {
                    System.out.println("Moneda de origen (Ejm. PEN): ");
                    String origen = scanner.nextLine().toUpperCase();
                    if (!MonedasDisponibles.contains(origen)) {
                        System.out.println("Moneda origen invalida.");
                        continue;
                    }
                    System.out.println("Moneda de destino (Ejm. USD): ");
                    String destino = scanner.nextLine().toUpperCase();
                    if (!MonedasDisponibles.contains(destino)) {
                        System.out.println("Moneda origen invalida.");
                        continue;
                    }
                    System.out.println("Monto: ");
                    double monto;
                    try {
                        monto = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Monto invalido.");
                        continue;
                    }
                    try {
                        Conversion conversion = conversor.convertir(origen, destino, monto);
                        System.out.println("Resultado: " + conversion);
                        historial.agregar(conversion);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case "3" -> historial.mostrar();
                case "4" -> {
                    historial.guardarComoTexto("historial_conversiones.txt");
                    historial.guardarComoJson("historial_conversiones.json");
                }
                case "5" -> {
                    System.out.println("Gracias por usar nuestro Conversor de Monedas!!!");
                    return;
                }
                default -> System.out.println("Opcion invalida.");
            }
        }
    }
        private static void mostrarMenu() {
            System.out.println("""
                    \n===== CONVERSOR DE MONEDAS =====
                    1. Mostrar monedas disponibles
                    2. Convertir monedas
                    3. Ver historial de conversiones
                    4. Guardar historial (TXT y JSON)
                    5. Salir
                    Selecciona una opción:
                    """);
        }
    }
