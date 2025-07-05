package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        try(FileWriter writer = new FileWriter(archivoJson)) {
            gson.toJson(historial,writer);
            System.out.println("Historial gardado como JSON en: "+archivoJson);
        }catch (IOException e){
            System.out.println("Error al guardar el historial JSON: "+e.getMessage());
        }
    }
}
