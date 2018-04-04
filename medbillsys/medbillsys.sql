-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2017 at 04:55 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medbillsys`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_billdet` (IN `bdc` INT)  NO SQL
DELETE FROM bildet WHERE bildetcod=bdc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_billtb` (IN `bc` INT)  NO SQL
DELETE FROM billtb WHERE bilcod=bc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_med` (IN `mcod` INT)  NO SQL
DELETE FROM medtb WHERE medcod=mcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_stock` (IN `sc` INT)  NO SQL
DELETE FROM stock WHERE stkcod=sc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dispmedstk` (IN `mcod` INT)  NO SQL
SELECT stkcod,stkmnfdat,stkexpdat,stkprc,stkqty - (SELECT ifnull(sum(bildetqty),0) FROM bildet WHERE bildetstkcod=a.stkcod) qtylft FROM stock a WHERE stkmedcod=mcod AND stkqty>0 ORDER BY stkexpdat$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `disp_billdet` (IN `bcod` INT)  NO SQL
SELECT * FROM bildet WHERE bildetbilcod=bcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `disp_billtb` ()  NO SQL
SELECT * FROM billtb$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `disp_med` ()  NO SQL
SELECT * FROM medtb$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `disp_stock` ()  NO SQL
SELECT * FROM stock$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `find_billdet` (IN `bc` INT)  NO SQL
SELECT * FROM bildet WHERE bildetbilcod=bc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `find_billtb` (IN `bc` INT)  NO SQL
SELECT * FROM billtb WHERE bilcod=bc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `find_med` (IN `mcod` VARCHAR(50))  NO SQL
SELECT * FROM medtb WHERE medcod=mcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `find_stock` (IN `sc` INT)  NO SQL
SELECT * FROM stock WHERE stkcod=sc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `find_stock_med` (IN `smc` INT)  NO SQL
SELECT * FROM stock WHERE stkmedcod=smc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_bill` (IN `bcn` VARCHAR(50), IN `bcp` BIGINT, IN `bd` DATE, OUT `bcod` INT)  NO SQL
BEGIN
INSERT into billtb VALUES(null,bcn,bcp,bd);
SELECT LAST_INSERT_ID() INTO bcod;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_billdet` (IN `bc` INT, IN `bq` INT, IN `bsc` INT)  NO SQL
INSERT INTO bildet VALUES(bc,null,bq,bsc)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_med` (IN `mn` VARCHAR(50), IN `mgn` VARCHAR(50), IN `mc` VARCHAR(50), IN `mt` VARCHAR(20), IN `mp` VARCHAR(20), IN `mpr` VARCHAR(200))  NO SQL
INSERT INTO medtb VALUES(null,mn,mgn,mc,mt,mp,mpr)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_stock` (IN `smc` INT, IN `sd` DATE, IN `sq` INT, IN `smd` DATE, IN `sed` DATE, IN `sp` FLOAT)  NO SQL
INSERT INTO stock VALUES(null,smc,sd,sq,smd,sed,sp)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `logincheck` (IN `user_id` VARCHAR(10), IN `pwd` VARCHAR(20), OUT `ret` INT)  NO SQL
BEGIN
DECLARE pass int;
SELECT PASSWORD FROM logintb WHERE username=user_id into @pass;
IF @pass is null THEN
set ret=0;
ELSE
IF @pass=pwd THEN
set ret=1;
END IF;
end IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `medexp` ()  NO SQL
SELECT mednam,medtyp,medcmp,stkmnfdat,stkexpdat,stkprc,stkqty-( SELECT ifnull(SUM(bildetqty),0) FROM bildet WHERE bildetstkcod=a.stkcod) qtylft from stock a,medtb WHERE stkmedcod=medcod and stkexpdat>=curdate() and datediff(stkexpdat,curdate())<=30$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_billdet` (IN `bc` INT, IN `bdc` INT, IN `bq` INT, IN `bsc` INT)  NO SQL
UPDATE bildet SET bildetbilcod=bc,bildetqty=bq,bildetsktcod=bsc WHERE bildetcod=bdc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_billtb` (IN `bc` INT, IN `bcn` INT, IN `bcp` INT, IN `bd` INT)  NO SQL
UPDATE billtb SET bilcstnam=bcn,bilcsphn=bcp,bildat=bd WHERE bilcod=bc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_med` (IN `mcod` INT, IN `mn` VARCHAR(50), IN `mgn` VARCHAR(50), IN `mc` VARCHAR(50), IN `mt` VARCHAR(20), IN `mp` VARCHAR(20), IN `mpr` VARCHAR(200))  NO SQL
UPDATE medtb SET mednam=mn,medgennam=mgn,medcmp=mc,medtyp=mt,medpot=mp,medpre=mpr WHERE medcod=mcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_stock` (IN `sc` INT, IN `smc` INT, IN `sd` DATE, IN `sq` INT, IN `smd` DATE, IN `sed` DATE, IN `sp` FLOAT)  NO SQL
UPDATE stock SET stkmedcod=smc,stkdat=sd,stkqty=sq,stkmnfdat=smd,stkexpdat=sed,stkprc=sp WHERE stkcod=sc$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bildet`
--

CREATE TABLE `bildet` (
  `bildetbilcod` int(11) NOT NULL,
  `bildetcod` int(11) NOT NULL,
  `bildetqty` int(11) NOT NULL,
  `bildetstkcod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bildet`
--

INSERT INTO `bildet` (`bildetbilcod`, `bildetcod`, `bildetqty`, `bildetstkcod`) VALUES
(21, 11, 5, 21);

-- --------------------------------------------------------

--
-- Table structure for table `billtb`
--

CREATE TABLE `billtb` (
  `bilcod` int(11) NOT NULL,
  `bilcstnam` varchar(50) NOT NULL,
  `bilcstphn` bigint(20) NOT NULL,
  `bildat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billtb`
--

INSERT INTO `billtb` (`bilcod`, `bilcstnam`, `bilcstphn`, `bildat`) VALUES
(21, 'Aman', 9988468676, '2017-07-14');

-- --------------------------------------------------------

--
-- Table structure for table `logintb`
--

CREATE TABLE `logintb` (
  `username` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logintb`
--

INSERT INTO `logintb` (`username`, `password`) VALUES
('aman', 'deep');

-- --------------------------------------------------------

--
-- Table structure for table `medtb`
--

CREATE TABLE `medtb` (
  `medcod` int(11) NOT NULL,
  `mednam` varchar(50) NOT NULL,
  `medgennam` varchar(50) NOT NULL,
  `medcmp` varchar(50) NOT NULL,
  `medtyp` varchar(20) NOT NULL,
  `medpot` varchar(20) NOT NULL,
  `medpre` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medtb`
--

INSERT INTO `medtb` (`medcod`, `mednam`, `medgennam`, `medcmp`, `medtyp`, `medpot`, `medpre`) VALUES
(4, 'Disprin', 'Disprin', 'Cipla', 'Tablet', '100mg', 'None'),
(5, 'Paracitamol', 'Pc', 'Cadila', 'Tablet', '200mg', 'None');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stkcod` int(11) NOT NULL,
  `stkmedcod` int(11) NOT NULL,
  `stkdat` date NOT NULL,
  `stkqty` int(11) NOT NULL,
  `stkmnfdat` date NOT NULL,
  `stkexpdat` date NOT NULL,
  `stkprc` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stkcod`, `stkmedcod`, `stkdat`, `stkqty`, `stkmnfdat`, `stkexpdat`, `stkprc`) VALUES
(20, 4, '2017-07-13', 100, '2017-06-10', '2018-12-12', 10),
(21, 4, '2017-07-13', 150, '2017-02-12', '2018-06-13', 20),
(22, 5, '2017-07-14', 300, '2017-05-10', '2017-07-17', 20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bildet`
--
ALTER TABLE `bildet`
  ADD PRIMARY KEY (`bildetcod`),
  ADD KEY `bildetbilcod` (`bildetbilcod`),
  ADD KEY `bildetstkcod` (`bildetstkcod`);

--
-- Indexes for table `billtb`
--
ALTER TABLE `billtb`
  ADD PRIMARY KEY (`bilcod`);

--
-- Indexes for table `logintb`
--
ALTER TABLE `logintb`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `medtb`
--
ALTER TABLE `medtb`
  ADD PRIMARY KEY (`medcod`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stkcod`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bildet`
--
ALTER TABLE `bildet`
  MODIFY `bildetcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `billtb`
--
ALTER TABLE `billtb`
  MODIFY `bilcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `medtb`
--
ALTER TABLE `medtb`
  MODIFY `medcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `stkcod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bildet`
--
ALTER TABLE `bildet`
  ADD CONSTRAINT `foreign key` FOREIGN KEY (`bildetbilcod`) REFERENCES `billtb` (`bilcod`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stk key` FOREIGN KEY (`bildetstkcod`) REFERENCES `stock` (`stkcod`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
