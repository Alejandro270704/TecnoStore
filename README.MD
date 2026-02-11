# 📱 TecnoStore - Sistema de Gestión de Ventas


## 📌 Descripción del Proyecto

**TecnoStore** es una aplicación de consola desarrollada en **Java 17** para la administración de inventario, clientes y ventas de una tienda de celulares.

El sistema reemplaza el manejo manual en hojas de cálculo mediante una arquitectura basada en:

- **Programación Orientada a Objetos**
- **Persistencia con MySQL**
- **JDBC**
- **Stream API**
- **Principios SOLID**
- **Patrón de Diseño Singleton**

---

## 🛠 Tecnologías Utilizadas

- **Lenguaje:** Java 17  
- **Base de Datos:** MySQL  
- **Conectividad:** JDBC  
- **Procesamiento de datos:** Java Collections & Stream API  
- **Gestión de dependencias:** Maven   

---

## 🎯 Funcionalidades del Sistema

### 📦 Gestión de Inventario

- CRUD completo de celulares
- Validación de precio y stock positivos
- Clasificación por:
  - Marca
  - Modelo
  - Sistema Operativo
  - Gama (Alta, Media, Baja)

---

### 👤 Gestión de Clientes

- Registro de clientes
- Identificación única
- Validación de correo electrónico
- Listado de clientes

---

### 💰 Gestión de Ventas

- Selección de cliente y producto
- Cálculo automático del **IVA (19%)**
- Actualización automática del stock
- Persistencia en base de datos

### Fórmula del IVA

```java
public double calcularTotal(double subtotal){
    return subtotal * 0.19 + subtotal;
}
tecnostore/
│
├── MODELO/
│   ├── Celular.java
│   ├── Cliente.java
│   ├── Persona.java
│   ├── Venta.java
│   ├── Detalle_venta.java
│   ├── Marca.java
│   └── Modelo.java
│
├── CONTROLADOR/
│   ├── Celularimpl.java
│   ├── Clienteimpl.java
│   ├── Ventaimpl.java
│   ├── Detalleventaimpl.java
│   ├── Conexion.java
│   └── ReporteVentas.java
│
├── VISTA/
│   ├── menuPrincipal.java
│   └── menuVenta.java
│
└── Main.java

```

Nombre de la Base de Datos
tecnostore_db

``` SQL
CREATE DATABASE tecnostore_db;
USE tecnostore_db;


CREATE TABLE persona (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    identificacion VARCHAR(50) UNIQUE NOT NULL,
    correo VARCHAR(50) NOT NULL,
    telefono VARCHAR(50),
    PRIMARY KEY (id)
);


CREATE TABLE marca (
    id INT NOT NULL AUTO_INCREMENT,
    nombre_marca VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE modelo (
    id INT NOT NULL AUTO_INCREMENT,
    nombre_modelo VARCHAR(50),
    marca_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (marca_id) REFERENCES marca(id)
);


CREATE TABLE celular (
    id INT NOT NULL AUTO_INCREMENT,
    modelo_id INT UNIQUE NOT NULL,
    sistema_operativo ENUM('Android','iOS','WindowsPhone','BlackBerry','HarmonyOS'),
    gama ENUM('alta','media','baja'),
    precio DOUBLE NOT NULL,
    stock INT DEFAULT 0 NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (modelo_id) REFERENCES modelo(id)
);

CREATE TABLE cliente (
    id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES persona(id)
);


CREATE TABLE venta (
    id INT NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    fecha TIMESTAMP NOT NULL,
    total DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);


CREATE TABLE detalle_venta (
    id INT NOT NULL AUTO_INCREMENT,
    id_venta INT NOT NULL,
    id_celular INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_venta) REFERENCES venta(id),
    FOREIGN KEY (id_celular) REFERENCES celular(id)
);

-- ==========================================
-- ORDEN DE CREACIÓN (IMPORTANTE)
-- ==========================================
-- 1. persona
-- 2. marca
-- 3. modelo
-- 4. celular
-- 5. cliente
-- 6. venta
-- 7. detalle_venta
```
🔌 Configuración de Conexión JDBC
1️⃣ Dependencia Maven
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>


2️⃣ Clase Conexion (Patrón Singleton)
public class Conexion {

    private static Conexion conexion;

    private Conexion(){}

    public static Conexion getconexion(){
        if(conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection conectar(){
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tecnostore_db",
                "root",
                "TU_PASSWORD"
            );
        } catch(SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}


⚠ IMPORTANTE

Cambiar "root" por tu usuario MySQL

Cambiar "TU_PASSWORD" por tu contraseña real

Verificar que el servicio MySQL esté activo

▶ Ejemplo de Ejecución
===========================
      MENU PRINCIPAL
===========================
1. Gestion Celulares
2. Gestion Clientes
3. Gestion Ventas
4. Reportes
5. Salir
===========================


📊 Cumplimiento de Requerimientos

CRUD Celulares y Clientes	✅

Registro de Ventas con IVA 19%	✅

Persistencia con JDBC y MySQL	✅

Reporte exportable a .TXT	✅

Uso de Stream API	✅

Aplicación del Patrón Singleton	✅

Manejo de Excepciones	✅

👨‍💻 Autor

Alejandro Sanchez Carrillo
Proyecto Académico – TecnoStore
2026