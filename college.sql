-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.45 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for college
CREATE DATABASE IF NOT EXISTS `college` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `college`;

-- Dumping structure for table college.kafka_transaction
CREATE TABLE IF NOT EXISTS `kafka_transaction` (
  `transaction_id` varchar(100) NOT NULL,
  `status` enum('IP','C','F') NOT NULL DEFAULT 'IP',
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table college.kafka_transaction: ~18 rows (approximately)
DELETE FROM `kafka_transaction`;
/*!40000 ALTER TABLE `kafka_transaction` DISABLE KEYS */;
INSERT INTO `kafka_transaction` (`transaction_id`, `status`) VALUES
	('0295f685-4816-42d7-9bf9-b182157c4fa9', 'C'),
	('179232b3-bb5d-47f6-87ac-b76b8df9e079', 'IP'),
	('1d801529-96e3-46e8-a8c2-6682d1b9e02a', 'C'),
	('22b8d29b-66a0-4bde-8044-bcf110a1dc04', 'C'),
	('3cbb41ce-3260-4855-b6cc-bd5223e78041', 'C'),
	('3f641a24-f7cc-4363-b9af-c4cd1931af18', 'C'),
	('43e8a09f-18bb-4735-9387-15f66348ab19', 'C'),
	('46984065-1ce6-4660-9fbf-353230a4828d', 'C'),
	('4f32bd02-2fa4-4ecd-99de-bbdd5663449e', 'C'),
	('6845f350-efc9-4cfd-a829-ef2164a22bf0', 'C'),
	('801ae2e9-1b06-45de-bf81-03b4d0890029', 'C'),
	('85bc4678-16f1-4294-8e7d-3a1ee55e74fc', 'F'),
	('8f2e8b11-0cf2-4e1d-84f2-e41698d2fe7c', 'C'),
	('bbeb0e84-f3b0-47fb-b59f-2dac8de93090', 'C'),
	('c230dd4d-a7d1-44a4-a36c-af8df107aad1', 'C'),
	('e8b709d4-e809-43d8-bbeb-d987285747b1', 'C'),
	('ebdc5d91-2744-4d63-97ed-713e77cd71b5', 'C'),
	('ed24f2a3-1646-4579-b105-1af2693e7d83', 'C');
/*!40000 ALTER TABLE `kafka_transaction` ENABLE KEYS */;

-- Dumping structure for table college.student
CREATE TABLE IF NOT EXISTS `student` (
  `roll_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`roll_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table college.student: ~4 rows (approximately)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`roll_no`, `name`, `address`) VALUES
	(1, 'Rajesh', 'Mumbai'),
	(2, 'Manish', 'Lucknow'),
	(4, 'Mukesh', 'B-405,Mumbai'),
	(5, 'Ranjan', 'D-405,Ghansoli');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table college.subject
CREATE TABLE IF NOT EXISTS `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Dumping data for table college.subject: ~28 rows (approximately)
DELETE FROM `subject`;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` (`id`, `name`, `created_on`) VALUES
	(1, 'Math', '2019-12-11 09:48:19'),
	(2, 'Science', '2019-12-11 09:48:32'),
	(4, 'Sumit', '2019-12-11 16:00:36'),
	(5, 'Sumit1', '2019-12-11 16:48:32'),
	(8, 'MFCS', '2019-12-16 12:06:03'),
	(9, 'MFCS', '2019-12-16 12:10:20'),
	(10, 'MFCS', '2019-12-16 12:13:30'),
	(11, 'MFCS', '2019-12-16 12:15:23'),
	(12, 'MFCS', '2019-12-16 12:17:23'),
	(13, 'MFCS', '2019-12-16 12:19:28'),
	(14, 'MFCS', '2019-12-16 12:20:31'),
	(15, 'MFCS', '2019-12-16 12:22:46'),
	(16, 'MFCS', '2019-12-16 12:25:22'),
	(17, 'MFCS', '2019-12-16 12:27:18'),
	(18, 'CBNST', '2019-12-16 20:50:06'),
	(19, 'MFCS', '2019-12-16 20:50:06'),
	(20, 'CBNST', '2019-12-16 20:51:58'),
	(21, 'MFCS', '2019-12-16 20:51:58'),
	(22, 'CBNST', '2019-12-16 22:10:31'),
	(24, 'CBNST', '2019-12-16 22:20:02'),
	(25, 'MFCS', '2019-12-16 22:20:02'),
	(26, 'CBNST', '2019-12-16 22:21:31'),
	(27, 'MFCS', '2019-12-16 22:21:31'),
	(28, 'CBNST', '2019-12-17 16:15:07'),
	(29, 'MFCS', '2019-12-17 16:15:07'),
	(30, 'CBNST', '2019-12-17 16:28:03'),
	(31, 'GIS', '2019-12-18 13:12:59'),
	(32, 'Hindi', '2019-12-18 13:11:29');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;

-- Dumping structure for table college.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Dumping data for table college.teacher: ~9 rows (approximately)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`emp_id`, `name`, `address`, `subject_id`) VALUES
	(1, 'Rajesh', 'Mumbai', 2),
	(2, 'Mahesh', 'Lucknow', 1),
	(3, 'Mukund', 'Australia', 2),
	(4, 'Dubai', NULL, 1),
	(6, 'Shanker', 'Dubai', 1),
	(7, 'Shanker', 'Dubai', 1),
	(8, 'Shanker', 'Dubai', 1),
	(9, 'Shanker', 'Dubai', 1),
	(10, 'Shanker', 'Dubai', 1);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
