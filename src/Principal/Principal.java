package Principal;

import Modelo.ConversionResultado;
import Servicio.ConsultaMoneda;
import com.google.gson.Gson;

public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        String json =consulta.obtenerDatos("USD");

        //Convertir Json en objeto Java
        Gson gson = new Gson();
        ConversionResultado resultado = gson.fromJson(json, ConversionResultado.class);

        //Mostrar algunas clases de cambio
        System.out.println("Moneda Base: " + resultado.getBase_code());
        System.out.println("USD a PEN: " + resultado.getConversion_rates().get("PEN"));
        System.out.println("USD a EUR: " + resultado.getConversion_rates().get("EUR"));
    }
}
