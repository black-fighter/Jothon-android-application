-- phpMyAdmin SQL Dump
-- version 4.0.10.7
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Apr 04, 2016 at 12:45 AM
-- Server version: 5.5.48-cll
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `kibibyte_nbb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_help`
--

CREATE TABLE IF NOT EXISTS `tbl_help` (
  `id` int(5) NOT NULL,
  `ma_name` text NOT NULL,
  `ma_mob_no` varchar(12) NOT NULL,
  `msg` text NOT NULL,
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_help`
--

INSERT INTO `tbl_help` (`id`, `ma_name`, `ma_mob_no`, `msg`, `ts`) VALUES
(0, 'জরিনা', '', 'bacao bachao', '2016-04-02 07:12:18'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 07:26:47'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 07:27:29'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 07:30:13'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 07:42:43'),
(0, 'jori', '', 'bacao bachao', '2016-04-02 07:45:55'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 07:52:56'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 07:55:37'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 11:19:59'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 11:25:25'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-02 12:04:59'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-03 08:49:59'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-03 08:54:23'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-03 08:59:44'),
(0, 'jorina', '', 'Urgent Help Plz', '2016-04-03 11:00:17');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_ma`
--

CREATE TABLE IF NOT EXISTS `tbl_ma` (
  `ma_id` int(11) NOT NULL,
  `ma_name` varchar(30) NOT NULL,
  `ma_mob_no` varchar(20) NOT NULL,
  `ma_boyos` varchar(50) NOT NULL,
  `ma_bl_gr` varchar(50) NOT NULL,
  `ma_ba_no` varchar(100) NOT NULL,
  `ma_division` varchar(50) NOT NULL,
  `ma_zilla` varchar(50) NOT NULL,
  `ma_upozilla` varchar(50) NOT NULL,
  `ma_wei` varchar(100) NOT NULL,
  `ma_gorvabosthar_kotodin` varchar(50) NOT NULL,
  `ma_s_boyos` varchar(50) NOT NULL,
  `ma_s_wei` varchar(100) NOT NULL,
  `ma_s_bl_gr` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_ma`
--

INSERT INTO `tbl_ma` (`ma_id`, `ma_name`, `ma_mob_no`, `ma_boyos`, `ma_bl_gr`, `ma_ba_no`, `ma_division`, `ma_zilla`, `ma_upozilla`, `ma_wei`, `ma_gorvabosthar_kotodin`, `ma_s_boyos`, `ma_s_wei`, `ma_s_bl_gr`) VALUES
(1, 'lutfa', '1994-03-26', '', '', '2', '60', '60', '0000-00-00', 'lutfa', '0', '0', '', ''),
(2, 'jorina', '59', '', '', '4', '60', '200', '6', 'jorina', '0', '0', '', ''),
(3, 'tithi', '59', '', '', '4', '100', '200', '6', 'tithi', '0', '0', '', ''),
(4, 'fvgbt5', '59', '', '', '4', '60', '200', '6', 'jorina', '0', '0', '', ''),
(8, 'jorina', '01751473993', '', '', '4', 'raj', 'raj', 'bag', '60', '200', '200', '5', ''),
(11, 'à¦œà¦°à¦¿à¦¨à¦¾', 'à§¦à§§à§­à§«à§§à§ªà§', '', '', 'à§ª', 'à¦°à¦¾à¦œà¦¶à¦¾à¦¹à¦¿', 'à¦°à¦¾à¦œà¦¶à¦¾à¦¹à¦¿', 'à¦¬à¦¾à¦—à¦®à¦¾à¦°à¦¾', 'à§¬à§¦', '0', '0', 'à§«', ''),
(12, 'à¦•à¦¬à¦¿à¦¤à¦¾', 'à§¦à§§à§­à§«à§§à§ªà§', 'à§ªà§¦', '', 'à§©', 'à¦°à¦¾à¦œà¦¶à¦¾à¦¹à¦¿', 'à¦°à¦¾à¦œà¦¶à¦¾à¦¹à¦¿', 'à¦¬à¦¾à¦—à¦®à¦¾à¦°à¦¾', 'à§¬à§¦', '0', '0', 'à§«', 'à¦¬à¦¿+'),
(0, 'পারভীন ', '012345', '', '', '2', 'rang', 'rang', 'sadar', '40', '10', '0 ', '0 ', ''),
(0, 'Test_mom', '12345', '17 বছর  ', '', '1 নাম্বার', 'Rangpur', 'রংপুর', 'রংপুর ', '30~35 কেজি ', '1 দিন  ', '0 সপ্তাহ  ', '0~2 কেজি ', 'A (+)ve'),
(0, 'Test_mom', '12345', '17 বছর  ', '', '1 নাম্বার', 'Rangpur', 'রংপুর', 'রংপুর ', '30~35 কেজি ', '1 দিন  ', '0 সপ্তাহ  ', '0~2 কেজি ', 'A (+)ve'),
(1, 'lutfa', '1994-03-26', '', '', '2', '60', '60', '0000-00-00', 'lutfa', '0', '0', '', ''),
(2, 'jorina', '59', '', '', '4', '60', '200', '6', 'jorina', '0', '0', '', ''),
(3, 'tithi', '59', '', '', '4', '100', '200', '6', 'tithi', '0', '0', '', ''),
(4, 'fvgbt5', '59', '', '', '4', '60', '200', '6', 'jorina', '0', '0', '', ''),
(8, 'jorina', '01751473993', '', '', '4', 'raj', 'raj', 'bag', '60', '200', '200', '5', ''),
(11, 'à¦œà¦°à¦¿à¦¨à¦¾', 'à§¦à§§à§­à§«à§§à§ªà§', '', '', 'à§ª', 'à¦°à¦¾à¦œà¦¶à¦¾à¦¹à¦¿', 'à¦°à¦¾à¦œà¦¶à¦¾à¦¹à¦¿', 'à¦¬à¦¾à¦—à¦®à¦¾à¦°à¦¾', 'à§¬à§¦', '0', '0', 'à§«', ''),
(12, 'à¦•à¦¬à¦¿à¦¤à¦¾', 'à§¦à§§à§­à§«à§§à§ªà§', 'à§ªà§¦', '', 'à§©', 'à¦°à¦¾à¦œà¦¶à¦¾à¦¹à¦¿', 'à¦°à¦¾à¦œà¦¶à¦¾à¦¹à¦¿', 'à¦¬à¦¾à¦—à¦®à¦¾à¦°à¦¾', 'à§¬à§¦', '0', '0', 'à§«', 'à¦¬à¦¿+'),
(0, 'আবুলের বউ', '1234567', '17 বছর  ', '', '1 নাম্বার', 'Dhaka', 'গাজিপুর', 'হ্যান উপজেলা', '30~35 কেজি ', '0 দিন  ', '0 সপ্তাহ  ', '0~2 কেজি ', 'A (+)ve'),
(0, 'আবুলের ২নং বউ', '1761651500', '17 বছর  ', '', '1 নাম্বার', 'Dhaka', 'গাজিপুর', 'হ্যান উপজেলা', '30~35 কেজি ', '0 দিন  ', '0 সপ্তাহ  ', '0~2 কেজি ', 'A (+)ve');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_message`
--

CREATE TABLE IF NOT EXISTS `tbl_message` (
  `message_id` int(7) NOT NULL AUTO_INCREMENT,
  `ma_id` int(5) NOT NULL,
  `message` text CHARACTER SET utf8mb4 NOT NULL,
  `created_date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_message`
--

INSERT INTO `tbl_message` (`message_id`, `ma_id`, `message`, `created_date_time`) VALUES
(1, 3, 'I hate you', '2016-03-28 09:29:14'),
(2, 3, 'You are a bad boy', '2016-03-28 09:53:37');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_reply`
--

CREATE TABLE IF NOT EXISTS `tbl_reply` (
  `reply_id` int(7) NOT NULL AUTO_INCREMENT,
  `ma_id` int(5) NOT NULL,
  `sas_id` int(5) NOT NULL,
  `reply` text NOT NULL,
  `created_date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbl_reply`
--

INSERT INTO `tbl_reply` (`reply_id`, `ma_id`, `sas_id`, `reply`, `created_date_time`) VALUES
(1, 3, 4, 'You are so sad', '2016-03-28 11:54:20');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sasthokormi`
--

CREATE TABLE IF NOT EXISTS `tbl_sasthokormi` (
  `sas_id` int(11) NOT NULL AUTO_INCREMENT,
  `sas_name` varchar(100) NOT NULL,
  `sas_division` varchar(50) NOT NULL,
  `sas_zilla` varchar(100) NOT NULL,
  `sasthokendro_name` varchar(100) NOT NULL,
  `sas_phone` varchar(100) NOT NULL,
  `sas_password` varchar(50) NOT NULL,
  PRIMARY KEY (`sas_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `tbl_sasthokormi`
--

INSERT INTO `tbl_sasthokormi` (`sas_id`, `sas_name`, `sas_division`, `sas_zilla`, `sasthokendro_name`, `sas_phone`, `sas_password`) VALUES
(1, 'rok', 'raj', '017', 'rokon', '0', ''),
(2, 'lot', 'dha', '076', 'lot', '0', ''),
(3, 'rokon', 'raj', '017', 'rokon', '0', ''),
(4, 'riaz', 'bongobondhu', '017', 'riaz', '0', ''),
(7, 'rokon', 'chi', 'chi', 'chi', '17', '234'),
(8, 'lot', 'chi', 'chi', 'chi', '17', '1234'),
(10, 'সাজ্জাদ', ' রংপুর ', 'রংপুর', 'রংপুর কমপ্লেক্স ', '0123456', '0123456'),
(11, 'আপনার নাম লিখুন', 'Dhaka', 'গাজিপুর', 'হ্যান স্বাস্থ্য কমপ্লেক্স', '12345', '12345'),
(12, 'আপনার নাম লিখুন', 'Dhaka', 'গাজিপুর', 'হ্যান স্বাস্থ্য কমপ্লেক্স', '123', '123'),
(13, 'test name', 'Dhaka', 'গাজিপুর', 'হ্যান স্বাস্থ্য কমপ্লেক্স', '1234656', '123456'),
(14, 'রোকন', 'রাজশাহি', 'পাবনা', 'রাজাপুর', '০১৭৪৭২০৩৮০৮', '১২৩৪'),
(15, 'rokon', 'dhaka', 'dhaka', 'dhaka', '01788141627', '1234'),
(16, 'sazzad Hossain', 'Rangpur', 'রংপুর', 'রংপুর স্বাস্থ্য কমপ্লেক্স', '1717', '123456');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
