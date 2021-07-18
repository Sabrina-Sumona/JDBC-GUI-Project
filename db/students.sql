-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 18, 2021 at 04:11 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `students`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

DROP TABLE IF EXISTS `book_details`;
CREATE TABLE IF NOT EXISTS `book_details` (
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL,
  `price` int(4) NOT NULL,
  `genre` varchar(10) NOT NULL,
  `publise` year(4) NOT NULL,
  `cover_photo` varchar(10) DEFAULT NULL,
  `comment` text NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`book_id`, `book_name`, `author`, `price`, `genre`, `publise`, `cover_photo`, `comment`) VALUES
(1, 'Harry Potter', 'J. K. Rawling', 500, 'Fictional', 1998, 'harry.jpg', 'Thank you!');

-- --------------------------------------------------------

--
-- Table structure for table `book_info`
--

DROP TABLE IF EXISTS `book_info`;
CREATE TABLE IF NOT EXISTS `book_info` (
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL,
  `price` int(4) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_info`
--

INSERT INTO `book_info` (`book_id`, `book_name`, `author`, `price`) VALUES
(245, 'Pather Panchali', 'Bibhutibhushan', 677),
(634, 'Chokher Bali', 'Rabindranath Tagore', 220),
(899, 'Abol Tabol', ' Sukumar Ray', 180),
(933, 'Srikanta', 'Sarat Chandra', 777),
(140, 'The Postmaster', 'Rabindranath Tagore', 98),
(333, 'Rashed My Friend', 'Muhammed Zafar Iqbal', 230),
(555, 'Tukunjil', 'Zafar Iqbal', 356);

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
CREATE TABLE IF NOT EXISTS `student_details` (
  `std_id` int(10) NOT NULL AUTO_INCREMENT,
  `std_name` varchar(30) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `mname` varchar(20) NOT NULL,
  `mobile` int(11) NOT NULL,
  `mail` varchar(20) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `dob` date NOT NULL DEFAULT '1997-03-01',
  `img` varchar(10) NOT NULL,
  `comment` text NOT NULL,
  PRIMARY KEY (`std_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`std_id`, `std_name`, `fname`, `mname`, `mobile`, `mail`, `gender`, `dob`, `img`, `comment`) VALUES
(1, 'Sumona', 'Muslim', 'Rumisa', 1901234567, 'snscity@outlook.com', 'female', '1997-03-01', 'img1.png', 'N/A'),
(2, 'Sabrina Naorin Sumona', 'Muslim Uddin', 'Rumisa Begom', 1912345678, 'snsbauet04@gmail.com', 'female', '1997-03-01', 'img2.png', 'Thank you!');

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
CREATE TABLE IF NOT EXISTS `student_info` (
  `std_id` int(9) NOT NULL AUTO_INCREMENT,
  `std_name` varchar(40) NOT NULL,
  `department` varchar(10) NOT NULL DEFAULT 'CSE',
  `batch` int(3) NOT NULL,
  PRIMARY KEY (`std_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`std_id`, `std_name`, `department`, `batch`) VALUES
(1, 'Sabrina', 'CSE', 45),
(2, 'Naorin', 'EEE', 46),
(3, 'Nova', 'ENG', 48),
(4, 'Sumona', 'BBA', 47),
(5, 'Kaniz', 'CSE', 45),
(6, 'Afroza', 'BBA', 44),
(7, 'Nabiha', 'CSE', 49),
(8, 'Tumpa', 'ENG', 51),
(9, 'Fatema', 'EEE', 53),
(10, 'Kona', 'LLB', 43),
(11, 'Nadia', 'CSE', 45),
(12, 'Minu', 'ICE', 54),
(15, 'Lima', 'CSE', 44),
(16, 'Dolon', 'ENG', 43),
(17, 'Jeba', 'TEX', 61),
(18, 'Fariha', 'BBA', 59),
(19, 'Jeni', 'BNG', 77),
(20, 'Marium', 'LLB', 75);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
