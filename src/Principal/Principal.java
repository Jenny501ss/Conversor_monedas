package Principal;

import Modelo.ConversionResultado;
import Servicio.ConsultaMoneda;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        Gson gson = new Gson(); //Convertir Json en objeto Java

        System.out.println("===== CONVERSOR DE MONEDAS =====");

        //Lista simple de monedas admitidas
        String[] monedasDisponibles = {"USD", "PEN", "EUR", "BRL", "COP", "CLP"};

        //Mostrar opciones
        System.out.println("Monedas disponibles: ");
        for (String moneda : monedasDisponibles) {
            System.out.println(moneda + " ");
        }
        System.out.println();
        //Pedir monedas base
        System.out.println("Ingrese la moneda de origen (Ejm. USD): ");
        String monedaBase = scanner.nextLine().toUpperCase();

        //Pedir moneda destino
        System.out.println("Ingrese la moneda de destino (Ejm. PEN): ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        //Pedir monto
        System.out.println("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();

        //Obtener datos de la API
        String json = consulta.obtenerDatos(monedaBase);
        ConversionResultado resultado = gson.fromJson(json,ConversionResultado.class);
        Map<String, Double> tasas = resultado.getConversion_rates();

        //Verificar si la moneda de destino existe
        if (!tasas.containsKey(monedaDestino)){
            System.out.println("❌ Moneda de destino no válida.");
            return;
        }
        //Realizar conversion
        double tasa = tasas.get(monedaDestino);
        double convertido = monto*tasa;

        //Mostrar resultado
        System.out.printf("💱 %.2f %s equivale a %.2f %s\n",
                monto,monedaBase,convertido,monedaDestino);
    }
}
