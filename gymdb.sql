-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2024 at 08:15 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gymdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `coachtbl`
--

CREATE TABLE `coachtbl` (
  `CId` int(11) NOT NULL,
  `CName` varchar(25) NOT NULL,
  `CPhone` varchar(12) NOT NULL,
  `CAge` int(11) NOT NULL,
  `CAddress` varchar(50) NOT NULL,
  `CGen` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coachtbl`
--

INSERT INTO `coachtbl` (`CId`, `CName`, `CPhone`, `CAge`, `CAddress`, `CGen`) VALUES
(1, 'Jasmin Adrovic', '381637432500', 39, 'Pere Perica 15', 'Male'),
(2, 'Jovana Jovanic', '0631234568', 28, 'Sejkina 5', 'Female'),
(3, 'Mira Mirkovic ', '063222333', 35, 'Krovljeva 11', 'Female'),
(4, 'Majkl Daglas', '123456', 36, 'Figarova 5', 'Male'),
(5, 'vfvfvf', '123456', 27, 'rfgfggfgf', 'Female'),
(17, 'Vladica Jovanovic', '0637432566', 40, 'Mozartova10', 'Male'),
(18, 'Pera Peric', '0635252563', 32, 'Pere Perica 5', 'Male'),
(19, 'Marko Markovic', '0635247856', 29, 'Marka Markovica 10', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `financetbl`
--

CREATE TABLE `financetbl` (
  `PId` int(11) NOT NULL,
  `PPeriodOd` varchar(50) NOT NULL,
  `PPeriodDo` varchar(50) NOT NULL,
  `PMember` varchar(20) NOT NULL,
  `PAmount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `financetbl`
--

INSERT INTO `financetbl` (`PId`, `PPeriodOd`, `PPeriodDo`, `PMember`, `PAmount`) VALUES
(1, '2024-04-11', '2024-05-11', 'Krisitna ', 5000),
(2, '2024-04-28', '2024-05-28', 'Jova Jovic ', 5000),
(3, '2024-04-12', '2024-05-17', 'Nikola Nikolic', 4000),
(4, '2024-04-27', '2024-05-27', 'Mika Lazic', 5000),
(7, '2024-04-10', '2024-05-10', 'Novi Clan 5', 3500),
(9, '2024-04-13', '2024-05-13', 'Novi Clan 10', 4000),
(10, '2024-04-15', '2024-06-15', 'Dragan Stojkovic', 4000),
(11, '2024-04-12', '2024-05-12', 'Nevenica Zeka', 3500);

-- --------------------------------------------------------

--
-- Table structure for table `logintbl`
--

CREATE TABLE `logintbl` (
  `LId` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logintbl`
--

INSERT INTO `logintbl` (`LId`, `username`, `password`) VALUES
(1, 'jale', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `membertbl`
--

CREATE TABLE `membertbl` (
  `MId` int(11) NOT NULL,
  `MName` varchar(20) NOT NULL,
  `MPhone` varchar(20) NOT NULL,
  `MAge` int(11) NOT NULL,
  `MAmount` int(11) NOT NULL,
  `MTiming` varchar(20) NOT NULL,
  `MCoach` varchar(20) NOT NULL,
  `MGen` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `membertbl`
--

INSERT INTO `membertbl` (`MId`, `MName`, `MPhone`, `MAge`, `MAmount`, `MTiming`, `MCoach`, `MGen`) VALUES
(2, 'Mika Lazic', '0637432500', 38, 3000, '18h-20h', 'Jovana Jovanic', 'Male'),
(3, 'Novi Clan', '123456789', 32, 4000, '20h-22h', 'Pera Peric', 'Female'),
(4, 'Jova Jovic ', '987654321', 32, 5000, '20h-22h', 'Mira Mirkovic ', 'Male'),
(5, 'Krisitna ', '06321212', 26, 5000, '14h-16h', 'Majkl Daglas', 'Female'),
(6, 'Nikola Nikolic', '02020505', 39, 3000, '14h-16h', 'Vladica Jovanovic', 'Male'),
(7, 'Novi Clan 2 ', '0631234567', 20, 7000, '10h-12h', 'Vladica Jovanovic', 'Female'),
(9, 'Nevenica Zeka', '0603153555', 40, 6000, '20h-22h', 'Jasmin Adrovic', 'Female'),
(10, 'Novi Clan 5', '32326599', 26, 7000, '16h-18h', 'Vladica Jovanovic', 'Male'),
(11, 'Novi Clan 10', '12569832', 23, 10000, '20h-22h', 'Majkl Daglas', 'Female'),
(12, 'Dragan Stojkovic', '0631231646', 56, 10000, '16h-18h', 'Majkl Daglas', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coachtbl`
--
ALTER TABLE `coachtbl`
  ADD PRIMARY KEY (`CId`);

--
-- Indexes for table `financetbl`
--
ALTER TABLE `financetbl`
  ADD PRIMARY KEY (`PId`);

--
-- Indexes for table `logintbl`
--
ALTER TABLE `logintbl`
  ADD PRIMARY KEY (`LId`);

--
-- Indexes for table `membertbl`
--
ALTER TABLE `membertbl`
  ADD PRIMARY KEY (`MId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `coachtbl`
--
ALTER TABLE `coachtbl`
  MODIFY `CId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `financetbl`
--
ALTER TABLE `financetbl`
  MODIFY `PId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `logintbl`
--
ALTER TABLE `logintbl`
  MODIFY `LId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `membertbl`
--
ALTER TABLE `membertbl`
  MODIFY `MId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
