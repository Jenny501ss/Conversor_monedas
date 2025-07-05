package Principal;

import Servicio.ConsultaMoneda;

public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        String json =consulta.obtenerDatos("USD");
        System.out.println(json);

    }
}
