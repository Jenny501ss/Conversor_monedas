package Principal;

import Modelo.ConversionResultado;
import Servicio.ConsultaMoneda;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        Gson gson = new Gson(); //Convertir Json en objeto Java
        List<String>historial = new ArrayList<>();

        System.out.println("===== CONVERSOR DE MONEDAS =====");
        //Lista simple de monedas admitidas
        String[] monedasDisponibles = {"USD", "PEN", "EUR", "BRL", "COP", "CLP"};

        while (true) {
            //Mostrar opciones
            System.out.println("\nMonedas disponibles: ");
            for (String moneda : monedasDisponibles) {
                System.out.println(moneda + " ");
            }
            System.out.println("\n(Escribe 'salir' en cualquier momento para terminar)");

            //Pedir monedas base
            System.out.println("Ingrese la moneda de origen (Ejm. USD): ");
            String monedaBase = scanner.nextLine().toUpperCase();
            if (monedaBase.equals("SALIR")) break;

            //Pedir moneda destino
            System.out.println("Ingrese la moneda de destino (Ejm. PEN): ");
            String monedaDestino = scanner.nextLine().toUpperCase();
            if (monedaDestino.equals("SALIR")) break;

            //Pedir monto
            System.out.println("Ingrese el monto a convertir: ");
            double monto;
            try {
                monto = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Monto inválido. Intenta de nuevo.");
                continue;
            }

            //Consulta y conversion
            try {
                //Obtener datos de la API
                String json = consulta.obtenerDatos(monedaBase);
                ConversionResultado resultado = gson.fromJson(json, ConversionResultado.class);
                Map<String, Double> tasas = resultado.getConversion_rates();

                //Verificar si la moneda de destino existe
                if (!tasas.containsKey(monedaDestino)) {
                    System.out.println("❌ HistorialConversion de destino no válida.");
                    continue;
                }
                //Realizar conversion
                double tasa = tasas.get(monedaDestino);
                double convertido = monto * tasa;

                //Mostrar resultado
                System.out.printf("💱 %.2f %s equivale a %.2f %s\n",
                        monto, monedaBase, convertido, monedaDestino);

                String registro = String.format("%.2f %s => %.2f %s", monto, monedaBase, convertido, monedaDestino);
                historial.add(registro);
            } catch (Exception e) {
                System.out.println("❌ Error al obtener los datos: " + e.getMessage());
            }
        }
        System.out.println("Gracias por usar el conversor!!!!!!!");
    }
}
