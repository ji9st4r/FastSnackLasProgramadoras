# FastSnackLasProgramadoras
Actividad de clase para aplicar tipos de clases (2 tipos de clase, abstractas, completas)

# Escenario general:
FAST SNACKS es un negocio de comida rápida que necesita gestionar de manera eficiente la información de sus clientes, pedidos, productos, facturas y pagos.

Actualmente, el manejo de esta información puede generar retrasos en la atención cuando es necesario registrar clientes, consultar compras anteriores o llevar un control de las ventas realizadas. Además, la generación y consulta de registros puede volverse más complicada a medida que aumenta la cantidad de clientes y pedidos.

Para solucionar esta situación, se desarrolló un sistema de gestión que permite registrar clientes, administrar productos, crear pedidos, generar facturas y registrar pagos, manteniendo toda la información almacenada y organizada en una base de datos MySQL.

De esta manera, FAST SNACKS mejora la atención al cliente, facilita el acceso a la información y permite llevar un mejor control de las operaciones realizadas dentro del negocio.

## Modelo Conceptual

### Entidades Principales

**Cliente**
Contiene la información de los clientes registrados, como nombre, teléfono y dirección.

**Producto**
Almacena los productos disponibles junto con su precio.

**Pedido**
Registra los pedidos realizados por los clientes, incluyendo fecha, total y estado.

**Detalle Pedido**
Guarda los productos que forman parte de cada pedido, la cantidad solicitada y el subtotal correspondiente.

**Pago**
Registra la información de los pagos realizados, incluyendo método de pago, monto y banco.

**Factura**
Almacena los datos de las facturas generadas para cada venta.

### Relaciones Principales

- Un cliente puede realizar varios pedidos.
- Un pedido contiene uno o varios productos mediante el detalle del pedido.
- Un producto puede formar parte de diferentes pedidos.
- Cada pedido tiene asociado un pago.
- Cada pago genera una factura.

## Tecnologías Utilizadas

El proyecto fue desarrollado utilizando Java como lenguaje principal, MySQL para el almacenamiento de datos, Maven para la gestión del proyecto y Java Swing para la creación de la interfaz gráfica.

# Funcionalidades

- Registro y gestión de clientes.
  
- Administración de productos.
  
- Creación y seguimiento de pedidos.
  
- Registro de pagos realizados.
  
- Generación de facturas.
  
- Consulta del historial de pedidos.
  
- Validación de datos ingresados por el usuario.
  
- Almacenamiento seguro de información en MySQL.

# Programación Orientada a Objetos Aplicada

## Encapsulamiento
Se utilizaron atributos privados junto con métodos getters y setters para proteger la información de las clases.

## Herencia
La clase Cliente hereda atributos y métodos de la clase Persona, permitiendo reutilizar código y mejorar la organización del sistema.

## Constructores
Se implementaron constructores para inicializar objetos con sus respectivos datos al momento de su creación.

## Objetos
Se crearon objetos para representar las entidades principales del sistema como Clientes, Productos, Pedidos, Pagos y Facturas.

# Patrón DAO
El proyecto implementa el patrón DAO (Data Access Object), que permite separar la lógica de acceso a datos de la lógica del negocio.




