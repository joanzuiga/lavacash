-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2022 a las 05:59:08
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--tb_usuario
select * from tb_usuario
-- Base de datos: `db_lavacash`
--
CREATE DATABASE IF NOT EXISTS `db_lavacash` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `db_lavacash`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cita`
--

CREATE TABLE `tb_cita` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `servicio_id` int(11) NOT NULL,
  `vehiculo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cita_cita`
--

CREATE TABLE `tb_cita_cita` (
  `id` int(11) NOT NULL,
  `cita_padre` int(11) NOT NULL,
  `cita_hijo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_servicio`
--

CREATE TABLE `tb_servicio` (
  `id` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL,
  `tiempo` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `telefono` varchar(8) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `rol` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_vehiculo`
--

CREATE TABLE `tb_vehiculo` (
  `id` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_cita`
--
ALTER TABLE `tb_cita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vehiculo_id` (`vehiculo_id`),
  ADD KEY `servicio_id` (`servicio_id`);

--
-- Indices de la tabla `tb_cita_cita`
--
ALTER TABLE `tb_cita_cita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cita_hijo` (`cita_hijo`),
  ADD KEY `cita_padre` (`cita_padre`);

--
-- Indices de la tabla `tb_servicio`
--
ALTER TABLE `tb_servicio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tb_vehiculo`
--
ALTER TABLE `tb_vehiculo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_cita`
--
ALTER TABLE `tb_cita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_cita_cita`
--
ALTER TABLE `tb_cita_cita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_servicio`
--
ALTER TABLE `tb_servicio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_vehiculo`
--
ALTER TABLE `tb_vehiculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_cita`
--
ALTER TABLE `tb_cita`
  ADD CONSTRAINT `tb_cita_ibfk_1` FOREIGN KEY (`vehiculo_id`) REFERENCES `tb_vehiculo` (`id`),
  ADD CONSTRAINT `tb_cita_ibfk_2` FOREIGN KEY (`servicio_id`) REFERENCES `tb_servicio` (`id`);

--
-- Filtros para la tabla `tb_cita_cita`
--
ALTER TABLE `tb_cita_cita`
  ADD CONSTRAINT `tb_cita_cita_ibfk_1` FOREIGN KEY (`cita_hijo`) REFERENCES `tb_cita` (`id`),
  ADD CONSTRAINT `tb_cita_cita_ibfk_2` FOREIGN KEY (`cita_padre`) REFERENCES `tb_cita` (`id`);

--
-- Filtros para la tabla `tb_vehiculo`
--
ALTER TABLE `tb_vehiculo`
  ADD CONSTRAINT `tb_vehiculo_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

select * from tb_usuario

delete from tb_usuario where id = 32;
delete from tb_usuario where id = 33;
delete from tb_usuario where id = 34;
delete from tb_usuario where id = 25;
delete from tb_usuario where id = 26;
delete from tb_usuario where id = 27;
delete from tb_usuario where id = 28;
delete from tb_usuario where id = 29;
delete from tb_usuario where id = 30;
delete from tb_usuario where id = 31;

delimiter $$
create procedure GET_USER_VERIFY(
IN $correo varchar(45),
IN $contrasena varchar(45))
begin 
select * from tb_usuario where correo = $correo and contrasena = $contrasena;
end $$

call GET_USER_VERIFY('steven2846@gmail.com','12345');