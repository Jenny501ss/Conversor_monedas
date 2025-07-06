package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Servicio.NombreMonedas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class HistorialConversion {
    private final List<Conversion> historial =new ArrayList<>();

    public  void agregar(Conversion conversion){
        historial.add(conversion);
    }
    public void mostrar(){
        System.out.println("\n Historial de conversiones: ");
        if (historial.isEmpty()) {
            System.out.println("No se realizaron conversiones.");
        }else {
            historial.forEach(c-> System.out.println("- "+c));
        }
    }
    public void  guardarComoTexto(String archivoTxt){
        try(FileWriter writer = new FileWriter(archivoTxt)) {
            for (Conversion conversion : historial){
                writer.write(conversion.toString()+"\n");
            }
            System.out.println("Historial guardado como texto en: "+archivoTxt);
        }catch (IOException e){
            System.out.println("Error al guardar historial Txt: "+e.getMessage());
        }
    }
    public void guardarComoJson(String archivoJson){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Map<String,Object>> historialFormateado = new ArrayList<>();

        for (Conversion conversion : historial){
            String nombreOrigen = NombreMonedas.nombres.getOrDefault(conversion.origen(),"Desconocido");
            String nombreDestino = NombreMonedas.nombres.getOrDefault(conversion.destino(),"Desconocido");

            Map<String, Object> entrada = new LinkedHashMap<>();
            entrada.put("monto", conversion.monto());
            entrada.put("origen", conversion.origen());
            entrada.put("nombreOrigen", nombreOrigen);
            entrada.put("resultado", conversion.resultado());
            entrada.put("destino", conversion.destino());
            entrada.put("nombreDestino", nombreDestino);

            historialFormateado.add(entrada);
        }
        try(FileWriter writer = new FileWriter(archivoJson)) {
            gson.toJson(historialFormateado,writer);
            System.out.println("Historial guardado como JSON en: "+archivoJson);
        }catch (IOException e){
            System.out.println("Error al guardar el historial JSON: "+e.getMessage());
        }
    }
}
