package Servicio;

import Modelo.Conversion;

public interface IConversor {
    Conversion convertir (String origen,
                          String destino,
                          double monto);
}
