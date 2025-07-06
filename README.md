# 💱 Conversor de Monedas

Este proyecto es un conversor de monedas desarrollado en Java para el curso de Oracle Next Education (ONE) - LATAM. 
Utiliza programación orientada a objetos, lectura de APIs y manejo de archivos, permitiendo convertir entre distintas monedas internacionales.

---

## 🚀 Funcionalidades

- ✔️ Conversión entre más de 160 monedas del mundo
- ✔️ Consumo de APIs externas utilizando libreria GSON
- ✔️ Programación Orientada a Objetos (POO)
- ✔️ Historial de conversiones visualizable
- ✔️ Exportación del historial en `.txt` y `.json`
- ✔️ Menú interactivo

---

## 🛠 Tecnologías

- Java 17+  
- IntelliJ IDEA (u otro IDE compatible)
- Biblioteca externa, descargar la ultima version: [GSON](https://mvnrepository.com/artifact/com.google.code.gson/gson) para manejar JSON  
- Git y GitHub para control de versiones
  
---

## 📂 Estructura del Proyecto

ConversorDeMonedas/
├── src/
│ ├── principal/ → Clase principal
│ ├── modelo/ → Clases de dominio (record, historial)
│ ├── servicio/ → Clases de lógica y consumo de API
├── lib/ → gson-2.10.1.jar
├── historial_conversiones.txt → Historial en texto (se genera)
├── historial_conversiones.json → Historial en JSON (se genera)
├── .gitignore
├── README.md

---

📡 API utilizada
- Este proyecto utiliza la ExchangeRate API versión gratuita.
- [Exchangerate](https://www.exchangerate-api.com/)
- Registrate con tu correo, luego recibiras tu clave (API Key).

## ▶️ Cómo ejecutar el proyecto

1. Clona el repositorio

git clone https://github.com/Jenny501ss/Conversor_monedas.git

2. Abre el proyecto en IntelliJ IDEA u otro IDE compatible
3. Asegúrate de tener el archivo gson-2.10.1.jar en la carpeta lib/ y que esté añadido al classpath del proyecto
4. Abre la clase: src\Servicio\ConsultaMoneda.java y modifica el Apikey con la clave que recibiras en tu correo
5. Abre la clase: src/Principal/Principal.java y ejecuta

---

📝 Licencia
Este proyecto fue realizado con fines educativos como parte del challenge de Alura Latam.

👩‍💻 Autor
- Jenny Joseline Mamani Choque

- [LinkedIn](https://www.linkedin.com/in/jenny-joseline-mamani-choque-07963593/)
- yenny501ss@gmail.com
