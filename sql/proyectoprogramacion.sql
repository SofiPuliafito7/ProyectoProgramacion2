CREATE DATABASE proyectoprogramacion;
USE proyectoprogramacion;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `usuario` (`nombre`, `apellido`, `email`, `telefono`, `password`) VALUES
('Sofia', 'Puliafito', 'sofia@gmail.com', '261678900', 'contrasenia123'),
('Victoria', 'Gomez', 'victoria@gmail.com', '261534344', 'ContrasEnia123'),
('Luciano', 'Lopez', 'luciano@gmail.com', '261778800', 'cONTRASENIA123');

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `cumpleaños` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `cliente` (`nombre`, `apellido`, `email`, `telefono`, `direccion`, `cumpleaños`) VALUES
('Maria', 'Paez', 'maria@gmail.com', '261675444', 'Calle 1, Guaymallén', '2000-03-10'),
('Graciela', 'Sosa', 'graciela@gmail.com', '261905444', 'Calle 2, Maipu', '1998-08-25'),
('Paulo', 'Dybala', 'paulo@gmail.com', '261609844', 'Calle 3, Godoy Cruz', '2003-09-19'),
('Lionel', 'Messi', 'lionel@gmail.com', '261675836', 'Calle 4, Ciudad', '2000-12-15');

SELECT * FROM `usuario`;
SELECT * FROM `cliente`;