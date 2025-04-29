-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 29-04-2025 a las 02:09:15
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `club20251`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guest`
--

DROP TABLE IF EXISTS `guest`;
CREATE TABLE IF NOT EXISTS `guest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `partner_id` bigint NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `guest`
--

INSERT INTO `guest` (`id`, `user_id`, `partner_id`, `status`) VALUES
(1, 5, 1, 0),
(2, 6, 1, 0),
(3, 7, 1, 0),
(4, 8, 1, 0),
(5, 9, 1, 0),
(6, 5, 1, 1),
(7, 6, 1, 1),
(8, 7, 1, 1),
(9, 10, 2, 0),
(10, 11, 2, 1),
(11, 12, 2, 1),
(12, 13, 2, 1),
(13, 14, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invoice_header`
--

DROP TABLE IF EXISTS `invoice_header`;
CREATE TABLE IF NOT EXISTS `invoice_header` (
  `invoice_header_id` bigint NOT NULL AUTO_INCREMENT,
  `person_id` bigint NOT NULL,
  `partner_id` bigint NOT NULL,
  `date_created` date NOT NULL,
  `amount` double NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`invoice_header_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partner`
--

DROP TABLE IF EXISTS `partner`;
CREATE TABLE IF NOT EXISTS `partner` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `type` varchar(20) NOT NULL,
  `date_created` datetime NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `partner`
--

INSERT INTO `partner` (`id`, `amount`, `type`, `date_created`, `user_id`) VALUES
(1, 50000, 'regular', '2025-04-28 20:36:14', 3),
(2, 50000, 'vip', '2025-04-28 20:37:06', 4),
(3, 50000, 'regular', '2025-04-28 21:04:53', 10),
(4, 50000, 'regular', '2025-04-28 21:07:15', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `cell_phone` bigint NOT NULL,
  `document` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`id`, `name`, `cell_phone`, `document`) VALUES
(1, 'Rogelio', 75314, 751569),
(2, 'Lucrecia', 123, 123),
(3, 'Rogelio', 135, 12345677),
(4, 'Rogelio', 135, 12345671),
(5, 'Rogelio', 135, 123456711),
(6, 'Rogelio', 135, 1234567111),
(7, 'Rogelio', 135, 12345671111),
(8, 'Rogelio', 135, 123456711111),
(9, 'Rogelio', 135, 1234567111111),
(10, 'Rogelio', 135, 12345672),
(11, 'Rogelio', 135, 123456722),
(12, 'Rogelio', 135, 1234567222),
(13, 'Rogelio', 135, 12345672222),
(14, 'Rogelio', 135, 123456722222);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `person_id` bigint NOT NULL,
  `user_name` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `role` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `person_id`, `user_name`, `password`, `role`) VALUES
(1, 1, 'admin', 'admin', 'admin'),
(2, 2, 'Lucrecia123', '123', 'partner'),
(3, 3, 'pancracio', '123', 'partner'),
(4, 4, 'pancracio1', '123', 'partner'),
(5, 5, 'pancracio11', '123', 'guest'),
(6, 6, 'pancracio111', '123', 'guest'),
(7, 7, 'pancracio1111', '123', 'guest'),
(8, 8, 'pancracio11111', '123', 'guest'),
(9, 9, 'pancracio111111', '123', 'guest'),
(10, 10, 'pancracio2', '123', 'guest'),
(11, 11, 'pancracio22', '123', 'guest'),
(12, 12, 'pancracio222', '123', 'guest'),
(13, 13, 'pancracio2222', '123', 'guest'),
(14, 14, 'pancracio22222', '123', 'guest'),
(15, 10, 'pancracio2', '123', 'partner');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
