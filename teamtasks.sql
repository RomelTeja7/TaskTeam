-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 28, 2023 at 10:46 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `teamtasks`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `job_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `group_id` int NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKdaynhntkym8y91f2068n5tlas` (`group_id`),
  KEY `FKd3mec01ppoe4f72dieat80vtw` (`job_id`),
  KEY `FKqs505klecu2miswk3wr733m8v` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employee_id`, `name`, `username`, `password`, `job_id`, `role_id`, `group_id`) VALUES
(12, 'Gia Monaco', 'Guass55', '$2a$10$/YLNFsmJ..dXiJiyRZRfNeI6Vem5LgnEqVyM55rClFXQnA/EqOl56', 2, 2, 2),
(18, 'Gohan GN', 'GNGohan', '$2a$10$Iy7Qey/nwLmX1XUUwdt5vO/uywXYAQAYCOarh0gLMaJo.vKtP1f.O', 3, 2, 3),
(19, 'Giselle Bonilla', 'BoniGui', '$2a$10$Kqu9TbXU/lWAADg/t8HyVOq62DCfr5WoqUZ.CQIdEBFxHwQwvxrNC', 3, 2, 3),
(1, 'Romel Tejada', 'RomelTeja7', '$2a$12$SXqfUH9unEGp4Zs9SOAGrO3N/bcaUpcu85nq.QEN91kp0WQIc/o5G', 1, 1, 1),
(21, 'Simon Lopez', 'LopezSS21', '$2a$10$ZRxu2ZhNfM2rfY6A2Gt6EODyudmykbWI.//GGqo33h93BYjs5EQsS', 1, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `groupss`
--

DROP TABLE IF EXISTS `groupss`;
CREATE TABLE IF NOT EXISTS `groupss` (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `job_id` int DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `FKab33b60n8e37ejtou4ggurr67` (`job_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `groupss`
--

INSERT INTO `groupss` (`group_id`, `name`, `job_id`) VALUES
(1, 'Developer A', 1),
(2, 'Data Analyst A', 2),
(3, 'Design A', 3);

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` int NOT NULL,
  `job_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`job_id`, `job_type`) VALUES
(1, 'Developer'),
(2, 'Data Analyst'),
(3, 'Design');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int NOT NULL,
  `name_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `name_role`) VALUES
(1, 'ADMIN'),
(2, 'BOSS'),
(3, 'EMPLOYEE');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE IF NOT EXISTS `status` (
  `status_id` int NOT NULL,
  `name_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`status_id`, `name_status`) VALUES
(1, 'PENDING'),
(2, 'SOLVED'),
(3, 'FAILED'),
(4, 'EXPIRED');

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
CREATE TABLE IF NOT EXISTS `tasks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `task_start` date DEFAULT NULL,
  `task_end` date DEFAULT NULL,
  `status_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjc3xiile6e5jbtmywxw5vfm7f` (`employee_id`),
  KEY `FKnmegmmwd246j9i3n0vslfmaiy` (`group_id`),
  KEY `FKfmlm4rxoa19247blv9g96eacd` (`status_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`id`, `title`, `description`, `task_start`, `task_end`, `status_id`, `employee_id`, `group_id`) VALUES
(1, 'Mini problems', 'Task to resolve all mini problemss', '2023-08-04', '2023-08-30', 1, 1, 1),
(8, 'Java test', 'Test in area Java', '2023-08-01', '2023-08-28', 1, 12, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
