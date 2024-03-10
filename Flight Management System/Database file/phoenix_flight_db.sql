-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2022 at 05:44 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phoenix_flight_db`
--
CREATE DATABASE IF NOT EXISTS `phoenix_flight_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `phoenix_flight_db`;

-- --------------------------------------------------------

--
-- Table structure for table `flight_table`
--

CREATE TABLE `flight_table` (
  `flight_id` int(11) NOT NULL,
  `flight_number` varchar(30) NOT NULL,
  `depart_time` time NOT NULL,
  `arrival_time` time NOT NULL,
  `number_of_seats` int(11) NOT NULL,
  `ticket_price` double(11,2) NOT NULL,
  `date` date NOT NULL,
  `depart_location` varchar(50) NOT NULL,
  `arrival_location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flight_table`
--

INSERT INTO `flight_table` (`flight_id`, `flight_number`, `depart_time`, `arrival_time`, `number_of_seats`, `ticket_price`, `date`, `depart_location`, `arrival_location`) VALUES
(5, 'FA107', '15:03:00', '18:06:00', 75, 500.00, '2022-05-21', 'United Kingdom', 'United States'),
(6, 'B-719', '03:30:00', '08:15:00', 100, 400.00, '2022-05-26', 'United States', 'United Kingdom'),
(7, 'FZ-666', '08:40:00', '15:45:00', 50, 350.00, '2022-05-30', 'Sri Lanka', 'China');

-- --------------------------------------------------------

--
-- Table structure for table `login_details_table`
--

CREATE TABLE `login_details_table` (
  `email` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ip` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_details_table`
--

INSERT INTO `login_details_table` (`email`, `role`, `time`, `ip`) VALUES
('admin@gmail.com', 'Admin', '2022-05-24 14:35:00', '0:0:0:0:0:0:0:1'),
('nipun@gmail.com', 'Level 2', '2022-05-24 14:30:55', '0:0:0:0:0:0:0:1'),
('tishara@gmail.com', 'Level 1', '2022-05-24 14:30:37', '0:0:0:0:0:0:0:1');

-- --------------------------------------------------------

--
-- Table structure for table `ticket_booking_table`
--

CREATE TABLE `ticket_booking_table` (
  `id` int(11) NOT NULL,
  `number_of_seats` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `flight_id` int(11) NOT NULL,
  `payment_status` varchar(30) NOT NULL DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket_booking_table`
--

INSERT INTO `ticket_booking_table` (`id`, `number_of_seats`, `email`, `flight_id`, `payment_status`) VALUES
(10, 5, 'isiwara@gmail.com', 6, 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `role` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL DEFAULT 'Activated'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`id`, `name`, `email`, `password`, `dob`, `address`, `role`, `status`) VALUES
(1, 'Isira Ratnayake', 'admin@gmail.com', 'admin123', '1995-03-16', '234/A/C, New Town, Kottawa', 'Admin', 'Activated'),
(2, 'Tishara Basnayake', 'tishara@gmail.com', 'tishara123', '1999-05-18', '45/Ganegama road, Pelmadulla', 'Level 1', 'Activated'),
(3, 'Nipun Lakshitha', 'nipun@gmail.com', 'nipun123', '1997-05-06', '12/B, Anuradhapura', 'Level 2', 'Activated'),
(4, 'Isiwara Kumarage', 'isiwara@gmail.com', 'isiwara123', '1998-04-20', 'Nochchiyagama rd, Anuradhapura', 'User', 'Activated'),
(5, 'Test User', 'test@gmail.com', 'test', '1999-05-25', '12/B, Anuradhapura', 'User', 'Removed');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flight_table`
--
ALTER TABLE `flight_table`
  ADD PRIMARY KEY (`flight_id`);

--
-- Indexes for table `login_details_table`
--
ALTER TABLE `login_details_table`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `ticket_booking_table`
--
ALTER TABLE `ticket_booking_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `flight_table`
--
ALTER TABLE `flight_table`
  MODIFY `flight_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `ticket_booking_table`
--
ALTER TABLE `ticket_booking_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
