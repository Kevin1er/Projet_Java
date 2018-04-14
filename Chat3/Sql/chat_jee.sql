-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 14 avr. 2018 à 17:01
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `chat_jee`
--

-- --------------------------------------------------------

--
-- Structure de la table `messages`
--

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `idproject` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `msg` varchar(250) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`idproject`,`username`,`msg`,`date`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `messages`
--

INSERT INTO `messages` (`idproject`, `username`, `msg`, `date`) VALUES
('AA1', 'Oussema', 'cvv', '2018-04-14 16:38:02'),
('AA1', 'Oussema', 'dezdzedzedze', '2018-04-14 16:51:54'),
('AA1', 'Oussema', 'et toi', '2018-04-14 16:38:04'),
('AA1', 'Oussema', 'gj', '2018-04-14 16:47:48'),
('AA1', 'Oussema', 'kbkk', '2018-04-14 16:47:50'),
('AA1', 'Oussema', 'lol', '2018-04-14 16:50:49'),
('AA1', 'Oussema', 'nl', '2018-04-14 16:47:51'),
('AA1', 'Oussema', 'non non', '2018-04-14 16:41:56'),
('AA1', 'Oussema', 'okkkkkkkkkkkk', '2018-04-14 16:47:40'),
('AA1', 'Oussema', 'okkkkkkkkkkkkkkkkkkk', '2018-04-14 16:50:45'),
('AA1', 'Oussema', 'WAAA', '2018-04-14 16:41:49'),
('AA1', 'solofo', 'Bonsoir, les gars', '2018-04-04 03:09:08');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
