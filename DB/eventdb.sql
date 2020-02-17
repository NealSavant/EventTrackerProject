-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eventdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `eventdb` ;

-- -----------------------------------------------------
-- Schema eventdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eventdb` DEFAULT CHARACTER SET utf8 ;
USE `eventdb` ;

-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `time_spent` DOUBLE NULL,
  `date` VARCHAR(50) NULL,
  PRIMARY KEY (`id`));

SET SQL_MODE = '';
DROP USER IF EXISTS eventuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'eventuser'@'localhost' IDENTIFIED BY 'eventuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'eventuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `eventdb`;
INSERT INTO `event` (`id`, `name`, `time_spent`, `date`) VALUES (1, 'Gym', 45, '02-03-2020');
INSERT INTO `event` (`id`, `name`, `time_spent`, `date`) VALUES (2, 'Gym', 50, '02-04-2020');
INSERT INTO `event` (`id`, `name`, `time_spent`, `date`) VALUES (3, 'Gym', 35, '02-05-2020');
INSERT INTO `event` (`id`, `name`, `time_spent`, `date`) VALUES (4, 'Gym', 73, '02-06-2020');
INSERT INTO `event` (`id`, `name`, `time_spent`, `date`) VALUES (5, 'Gym', 60, '02-07-2020');
INSERT INTO `event` (`id`, `name`, `time_spent`, `date`) VALUES (6, 'Gym', 30, '02-08-2020');

COMMIT;

