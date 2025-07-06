package Servicio;

import Modelo.Conversion;
import Modelo.ConversionResultado;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;

public class Conversor implements IConversor {
    private final ConsultaMoneda consulta;
    private final Gson gson = new Gson();

    public Conversor(ConsultaMoneda consulta){
        this.consulta=consulta;
    }


    @Override
    public Conversion convertir(String origen, String destino, double monto) {
        String json = consulta.obtenerDatos(origen);
        ConversionResultado resultado = gson.fromJson(json,ConversionResultado.class);
        Map<String,Double> tasas = resultado.getConversion_rates();

        if (!tasas.containsKey(destino)) {
            throw new IllegalArgumentException("Moneda destino no valido.");
        }
        double tasa  = tasas.get(destino);
        return new Conversion(origen,destino,monto,monto*tasa);
        }
        public Set<String> obtenerMonedasDisponibles(String base){
        String json = consulta.obtenerDatos(base);
        ConversionResultado resultado = gson.fromJson(json, ConversionResultado.class);
            return resultado.getConversion_rates().keySet();
        }
}
