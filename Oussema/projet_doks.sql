-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 22 mai 2018 à 17:48
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
-- Base de données :  `projet_doks`
--

-- --------------------------------------------------------

--
-- Structure de la table `friends`
--

DROP TABLE IF EXISTS `friends`;
CREATE TABLE IF NOT EXISTS `friends` (
  `follower` varchar(50) NOT NULL,
  `following` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `friends`
--

INSERT INTO `friends` (`follower`, `following`) VALUES
('oussema', 'solofo'),
('oussema', 'Dan'),
('solofo', 'oussema'),
('kevinn', 'Oussema');

-- --------------------------------------------------------

--
-- Structure de la table `inbox`
--

DROP TABLE IF EXISTS `inbox`;
CREATE TABLE IF NOT EXISTS `inbox` (
  `idmsg` int(11) NOT NULL AUTO_INCREMENT,
  `from` varchar(40) NOT NULL,
  `to` varchar(40) NOT NULL,
  `msg` varchar(200) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`idmsg`,`from`,`to`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inbox`
--

INSERT INTO `inbox` (`idmsg`, `from`, `to`, `msg`, `date`) VALUES
(2, 'solofo', 'oussema', 'cc', '2018-05-30 00:00:00'),
(3, 'solofo', 'oussema', 'reponds je t\'attends ', '2018-05-30 07:13:12'),
(13, 'oussema', 'solofo', 'solo !!!', '2018-05-22 17:20:40'),
(12, 'oussema', 'Dan', '!!!\r\n', '2018-05-20 03:31:09'),
(11, 'oussema', 'Dan', 'yo mec !', '2018-05-20 03:28:14'),
(10, 'oussema', 'solofo', 'yooooo', '2018-05-20 03:27:37'),
(14, 'oussema', 'solofo', 't ou ?', '2018-05-22 17:20:52'),
(15, 'oussema', 'solofo', 'mec', '2018-05-22 17:21:02'),
(16, 'oussema', 'solofo', 'aloo', '2018-05-22 17:21:06'),
(17, 'oussema', 'solofo', 'ccc cccc c  c!', '2018-05-22 19:36:44');

-- --------------------------------------------------------

--
-- Structure de la table `projects`
--

DROP TABLE IF EXISTS `projects`;
CREATE TABLE IF NOT EXISTS `projects` (
  `idproject` varchar(40) NOT NULL,
  `nomproject` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  PRIMARY KEY (`idproject`,`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projects`
--

INSERT INTO `projects` (`idproject`, `nomproject`, `username`) VALUES
('AA1', 'Analyse Algo', 'Oussema'),
('TALN1', 'Traitement analyse langague naturel', 'Oussema'),
('MI1', 'Math info', 'solofo'),
('SAI1', 'Synthese Analyse Image', 'oussema');

-- --------------------------------------------------------

--
-- Structure de la table `projects_invit`
--

DROP TABLE IF EXISTS `projects_invit`;
CREATE TABLE IF NOT EXISTS `projects_invit` (
  `idinvit` varchar(40) NOT NULL,
  `idproject` varchar(40) NOT NULL,
  `username` varchar(50) NOT NULL,
  `invited_by` varchar(40) NOT NULL,
  `date_invit` datetime NOT NULL,
  PRIMARY KEY (`idinvit`,`idproject`,`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projects_invit`
--

INSERT INTO `projects_invit` (`idinvit`, `idproject`, `username`, `invited_by`, `date_invit`) VALUES
('1LF1', 'LF2', 'Oussema', 'kevin', '2018-05-11 06:05:00'),
('1IA3', 'IA1', 'kevin', 'Dan', '2018-05-03 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `projects_perm`
--

DROP TABLE IF EXISTS `projects_perm`;
CREATE TABLE IF NOT EXISTS `projects_perm` (
  `idproject` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `admin` int(11) NOT NULL,
  `read` int(11) NOT NULL,
  `write` int(11) NOT NULL,
  PRIMARY KEY (`idproject`,`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projects_perm`
--

INSERT INTO `projects_perm` (`idproject`, `username`, `admin`, `read`, `write`) VALUES
('AA1', 'Oussema', 1, 1, 1),
('TALN1', 'Oussema', 1, 1, 1),
('MI1', 'solofo', 1, 1, 1),
('TALN1', 'Dan', 0, 1, 0),
('MI1', 'Dan', 0, 1, 0),
('AA1', 'solofo', 0, 1, 0),
('SAI1', 'Oussema', 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`nom`, `prenom`, `username`, `password`, `email`) VALUES
('Oussema', 'Oussema', 'Oussema', 'Oussema', 'troussemaa@gmail.com'),
('solofo', 'solofo', 'solofo', 'solofo', 'solofo@gmail.com'),
('ouss', 'aze', 'ouss', 'azeaz', 'keenee@gmail.com'),
('rraz', 'rr', 'rr', 'aze', 'sse@gmail.com'),
('Dan', 'Dan', 'Dan', 'Dan', 'dan_robert@yahoo.com'),
('kevin', 'kevin', 'kevin', 'kevin', 'kevinee@gmail.com'),
('kevinn', 'kevinn', 'kevinn', 'kevinn', 'kevin@gmail.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
