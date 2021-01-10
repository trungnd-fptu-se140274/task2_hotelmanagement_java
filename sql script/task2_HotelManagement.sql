-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotelmanagement
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotelmanagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotelmanagement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hotelmanagement` ;

-- -----------------------------------------------------
-- Table `hotelmanagement`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelmanagement`.`role` (
  `roleID` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `details` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`roleID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotelmanagement`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelmanagement`.`account` (
  `accID` VARCHAR(10) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `roleID` INT NOT NULL,
  `age` INT NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `address` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`accID`),
  INDEX `roleID` (`roleID` ASC) VISIBLE,
  CONSTRAINT `account_ibfk_1`
    FOREIGN KEY (`roleID`)
    REFERENCES `hotelmanagement`.`role` (`roleID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotelmanagement`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelmanagement`.`room` (
  `roomID` VARCHAR(10) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `price` DOUBLE NOT NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`roomID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotelmanagement`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelmanagement`.`booking` (
  `BookingID` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `startdate` DATETIME NOT NULL,
  `endtime` DATETIME NOT NULL,
  `accID` VARCHAR(10) NULL DEFAULT NULL,
  `roomID` VARCHAR(10) NULL DEFAULT NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`BookingID`),
  INDEX `accID` (`accID` ASC) VISIBLE,
  INDEX `roomID` (`roomID` ASC) VISIBLE,
  CONSTRAINT `booking_ibfk_1`
    FOREIGN KEY (`accID`)
    REFERENCES `hotelmanagement`.`account` (`accID`),
  CONSTRAINT `booking_ibfk_2`
    FOREIGN KEY (`roomID`)
    REFERENCES `hotelmanagement`.`room` (`roomID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
