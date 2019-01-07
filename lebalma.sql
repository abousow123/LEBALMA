-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 20 Octobre 2018 à 17:43
-- Version du serveur :  5.7.23-0ubuntu0.16.04.1
-- Version de PHP :  7.0.32-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lebalma`
--

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `cni` int(11) NOT NULL,
  `idpret` int(11) DEFAULT NULL,
  `prenom` varchar(254) DEFAULT NULL,
  `nom` varchar(254) DEFAULT NULL,
  `adresse` varchar(254) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Pret`
--

CREATE TABLE `Pret` (
  `idpret` int(11) NOT NULL,
  `montant` decimal(10,0) DEFAULT NULL,
  `datepret` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Pret`
--

INSERT INTO `Pret` (`idpret`, `montant`, `datepret`) VALUES
(2, '600', '2018-10-15 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE `User` (
  `login` varchar(30) NOT NULL,
  `mpass` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `User`
--

INSERT INTO `User` (`login`, `mpass`) VALUES
('abou', 'pass');

-- --------------------------------------------------------

--
-- Structure de la table `Versement`
--

CREATE TABLE `Versement` (
  `idverser` int(11) NOT NULL,
  `cni` int(11) NOT NULL,
  `montantverser` decimal(10,0) DEFAULT NULL,
  `dateversement` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`cni`),
  ADD UNIQUE KEY `CLIENT_PK` (`cni`),
  ADD KEY `ASSOCIATION_1_FK` (`idpret`);

--
-- Index pour la table `Pret`
--
ALTER TABLE `Pret`
  ADD PRIMARY KEY (`idpret`),
  ADD UNIQUE KEY `PRET_PK` (`idpret`);

--
-- Index pour la table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`login`);

--
-- Index pour la table `Versement`
--
ALTER TABLE `Versement`
  ADD PRIMARY KEY (`idverser`),
  ADD UNIQUE KEY `VERSEMENT_PK` (`idverser`),
  ADD KEY `ASSOCIATION_2_FK` (`cni`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Pret`
--
ALTER TABLE `Pret`
  MODIFY `idpret` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Versement`
--
ALTER TABLE `Versement`
  MODIFY `idverser` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Client`
--
ALTER TABLE `Client`
  ADD CONSTRAINT `FK_CLIENT_ASSOCIATI_PRET` FOREIGN KEY (`idpret`) REFERENCES `Pret` (`idpret`);

--
-- Contraintes pour la table `Versement`
--
ALTER TABLE `Versement`
  ADD CONSTRAINT `FK_VERSEMEN_ASSOCIATI_CLIENT` FOREIGN KEY (`cni`) REFERENCES `Client` (`cni`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
