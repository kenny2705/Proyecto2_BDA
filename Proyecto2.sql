CREATE DATABASE reservacionRestaurantes;

CREATE TABLE `reservacionrestaurantes`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre_completo` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idcliente`));

CREATE TABLE `reservacionrestaurantes`.`cancelacion` (
  `idcancelacion` INT NOT NULL AUTO_INCREMENT,
  `fecha_cancelacion` DATE NOT NULL,
  `multa` INT(10) NOT NULL,
  PRIMARY KEY (`idcancelacion`));


CREATE TABLE `reservacionrestaurantes`.`restaurante` (
  `idrestaurante` INT NOT NULL AUTO_INCREMENT,
  `hora_cierre` TIME NOT NULL,
  `hora_apertura` TIME NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrestaurante`));

CREATE TABLE `reservacionrestaurantes`.`reserva` (
  `idreserva` INT NOT NULL AUTO_INCREMENT,
  `costo_reserva` FLOAT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `numero_personas` INT NULL,
  `fecha_reserva` DATETIME(6) NOT NULL,
  PRIMARY KEY (`idreserva`));


CREATE TABLE `reservacionrestaurantes`.`mesa` (
  `idmesa` INT NOT NULL AUTO_INCREMENT,
  `codigo_mesa` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `capacidad` INT NOT NULL,
  `ubicacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmesa`));
