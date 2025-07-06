package Modelo;

import Servicio.NombreMonedas;

public record Conversion(String origen,
                         String destino,
                         double monto,
                         double resultado) {
    @Override
    public String toString(){
        String nombreOrigen = NombreMonedas.nombres.getOrDefault(origen, "Desconocido");
        String nombreDestino = NombreMonedas.nombres.getOrDefault(destino, "Desconocido");

        return "%.2f %s (%s) => %.2f %s (%s)".formatted(monto,origen,nombreOrigen,resultado,destino,nombreDestino);
    }
}
