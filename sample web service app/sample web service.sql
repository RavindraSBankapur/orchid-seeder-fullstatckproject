-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 26, 2018 at 10:00 AM
-- Server version: 5.7.15
-- PHP Version: 5.5.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ReviewAndRating`
--

-- --------------------------------------------------------

--
-- Table structure for table `badWordsFilterTable`
--

CREATE TABLE `badWordsFilterTable` (
  `id` int(11) NOT NULL,
  `filterText` varchar(100) NOT NULL,
  `status` tinyint(2) NOT NULL COMMENT '1= true, 0 =false',
  `createdTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTimestamp` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `likesAndDislikes`
--

CREATE TABLE `likesAndDislikes` (
  `likeOrDislikeId` int(11) NOT NULL,
  `reviewId` int(11) NOT NULL,
  `likeOrDislikeStatus` tinyint(1) NOT NULL COMMENT '1= like, 0 =dislike',
  `likedOrDislikedBy` int(11) NOT NULL,
  `createdTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTimestamp` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ratings`
--

CREATE TABLE `ratings` (
  `ratingId` int(11) NOT NULL,
  `maxRating` tinyint(4) NOT NULL COMMENT 'Max Rating Value 5,10 etc..',
  `isApprovedByAdmin` tinyint(4) NOT NULL,
  `ratingType` varchar(50) NOT NULL COMMENT '5 star, 10 star etc..',
  `createdTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTimestamp` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `reviewId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `reviewText` text NOT NULL,
  `moduleToken` varchar(50) NOT NULL,
  `ratings` tinyint(4) NOT NULL,
  `createdTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTimestamp` timestamp NULL DEFAULT NULL,
  `ratingId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `emailId` varchar(50) NOT NULL,
  `phoneNumber` int(10) NOT NULL,
  `projectToken` varchar(25) NOT NULL,
  `createdTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTimestamp` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `badWordsFilterTable`
--
ALTER TABLE `badWordsFilterTable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `likesAndDislikes`
--
ALTER TABLE `likesAndDislikes`
  ADD PRIMARY KEY (`likeOrDislikeId`),
  ADD KEY `reviewId` (`reviewId`),
  ADD KEY `likedOrDislikedBy` (`likedOrDislikedBy`);

--
-- Indexes for table `ratings`
--
ALTER TABLE `ratings`
  ADD PRIMARY KEY (`ratingId`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`reviewId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `ratingId` (`ratingId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `likesAndDislikes`
--
ALTER TABLE `likesAndDislikes`
  MODIFY `likeOrDislikeId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ratings`
--
ALTER TABLE `ratings`
  MODIFY `ratingId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `likesAndDislikes`
--
ALTER TABLE `likesAndDislikes`
  ADD CONSTRAINT `likesanddislikes_ibfk_1` FOREIGN KEY (`likedOrDislikedBy`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `likesanddislikes_ibfk_2` FOREIGN KEY (`reviewId`) REFERENCES `reviews` (`reviewId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`ratingId`) REFERENCES `ratings` (`ratingId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
