-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema maintenance
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema maintenance
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `maintenance` ;
USE `maintenance` ;

-- -----------------------------------------------------
-- Table `maintenance`.`userData`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maintenance`.`userData` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `team` VARCHAR(15) NOT NULL,
  `name_` VARCHAR(35) NOT NULL,
  `lastName` VARCHAR(35) NOT NULL,
  `userName` VARCHAR(35) NOT NULL,
  `password_` VARCHAR(35) NOT NULL,
  `teamAdmin` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`));

CREATE UNIQUE INDEX `userName_UNIQUE` ON `maintenance`.`userData` (`userName` ASC) VISIBLE;

CREATE UNIQUE INDEX `id_UNIQUE` ON `maintenance`.`userData` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `maintenance`.`workOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maintenance`.`workOrder` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `team` VARCHAR(15) NULL,
  `dat` date NOT NULL,
  `estimatedTime` INT(2) NOT NULL,
  `userName` VARCHAR(35) NOT NULL,
  `activity` VARCHAR(200) NOT NULL,
  `suggestions` VARCHAR(300) NULL,
  `realTime` INT(2) NULL,
  `activityFinished` BOOLEAN NULL,
  `notes` VARCHAR(300) NULL,
  PRIMARY KEY (`id`));

CREATE UNIQUE INDEX `id_UNIQUE` ON `maintenance`.`workOrder` (`id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `maintenance`.`userData`
-- -----------------------------------------------------
START TRANSACTION;
USE `maintenance`;
INSERT INTO `maintenance`.`userData` (`id`, `team`, `name_`, `lastName`, `userName`, `password_`, `teamAdmin`) VALUES (1, 'dia', 'ana', 'maria', 'amar', '123', 1);
INSERT INTO `maintenance`.`userData` (`id`, `team`, `name_`, `lastName`, `userName`, `password_`, `teamAdmin`) VALUES (2, 'dia', 'juan', 'martinez', 'jant', '123', 0);
INSERT INTO `maintenance`.`userData` (`id`, `team`, `name_`, `lastName`, `userName`, `password_`, `teamAdmin`) VALUES (3, 'tarde', 'sara', 'agudelo', 'sagu', '123', 0);
INSERT INTO `maintenance`.`userData` (`id`, `team`, `name_`, `lastName`, `userName`, `password_`, `teamAdmin`) VALUES (4, 'tarde', 'antonio', 'ocampo', 'anc', '123', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `maintenance`.`workOrder`
-- -----------------------------------------------------
START TRANSACTION;
USE `maintenance`;
INSERT INTO `maintenance`.`workOrder` (`id`, `team`, `dat`, `estimatedTime`, `userName`, `activity`, `suggestions`, `realTime`, `activityFinished`, `notes`) VALUES (1, 'dia', '22/12/12', 2, 'amar', 'Actividad1', 'Ninguna1', 0, 0, '');
INSERT INTO `maintenance`.`workOrder` (`id`, `team`, `dat`, `estimatedTime`, `userName`, `activity`, `suggestions`, `realTime`, `activityFinished`, `notes`) VALUES (2, 'dia', '22/2/2', 3, 'amar', 'Actividad2', 'Ninguna2', 0, 0, '');
INSERT INTO `maintenance`.`workOrder` (`id`, `team`, `dat`, `estimatedTime`, `userName`, `activity`, `suggestions`, `realTime`, `activityFinished`, `notes`) VALUES (3, 'tarde', '22/7/2', 5, 'anc', 'Actividad3', 'Ninguna3', 0, 0, '');
INSERT INTO `maintenance`.`workOrder` (`id`, `team`, `dat`, `estimatedTime`, `userName`, `activity`, `suggestions`, `realTime`, `activityFinished`, `notes`) VALUES (4, 'tarde', '22/8/2', 3, 'anc', 'Actividad4', 'Ninguna4', 0, 0, '');

COMMIT;

drop database maintenance;

select * from maintenance.workOrder;
