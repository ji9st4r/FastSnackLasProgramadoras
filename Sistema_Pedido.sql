CREATE DATABASE sistema_pedidos;
USE sistema_pedidos;

CREATE TABLE clientes (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion VARCHAR(200) NOT NULL
);

CREATE TABLE productos (
	idProducto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL
);

CREATE TABLE pedidos (
	idPedido INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    total DOUBLE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    clienteNombre VARCHAR(100) NOT NULL
);

CREATE TABLE detalle_pedido (
     idDetalle INT AUTO_INCREMENT PRIMARY KEY,
    productoNombre VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    precio DOUBLE NOT NULL,
    subtotal DOUBLE NOT NULL
);

CREATE TABLE pagos (
    idPago INT AUTO_INCREMENT PRIMARY KEY,
    metodoPago VARCHAR(50) NOT NULL,
    monto DOUBLE NOT NULL,
    cedula VARCHAR(20),
    banco VARCHAR(50)
);

CREATE TABLE facturas (
    idFactura INT AUTO_INCREMENT PRIMARY KEY,
    numeroFactura VARCHAR(50) NOT NULL,
    fechaEmision DATE NOT NULL,
    totalFactura DOUBLE NOT NULL
);