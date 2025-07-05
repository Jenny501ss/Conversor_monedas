package Modelo;

public record Conversion(String origen,
                         String destino,
                         double monto,
                         double resultado) {
    @Override
    public String toString(){
        return "%.2f %s => %.2f %s".formatted(monto,origen,resultado,destino);
    }
}
