-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema patronesSoftware
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema patronesSoftware
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `patronesSoftware` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `patronesSoftware`.`ordenCompras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patronesSoftware`.`ordenCompras` (
  `id` INT(11) NOT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `patronesSoftware`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patronesSoftware`.`categorias` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `patronesSoftware`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patronesSoftware`.`proveedor` (
  `id` INT(11) NOT NULL,
  `razon_social` VARCHAR(45) NULL DEFAULT NULL,
  `rubro` VARCHAR(45) NULL DEFAULT NULL,
  `ruc` DOUBLE NULL DEFAULT NULL,
  `nombre_comercial` VARCHAR(45) NULL DEFAULT NULL,
  `pais` VARCHAR(45) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NULL DEFAULT NULL,
  `referencia` VARCHAR(45) NULL DEFAULT NULL,
  `provincia` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `contacto` VARCHAR(45) NULL DEFAULT NULL,
  `fax` DOUBLE NULL DEFAULT NULL,
  `telefono_uno` DOUBLE NULL DEFAULT NULL,
  `telefono_dos` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `patronesSoftware`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patronesSoftware`.`productos` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `precio` DOUBLE NULL DEFAULT NULL,
  `stock` INT(11) NULL DEFAULT NULL,
  `unidad` INT(11) NULL DEFAULT NULL,
  `categorias_id` INT(11) NOT NULL,
  `proveedor_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `categorias_id`, `proveedor_id`),
  INDEX `fk_productos_categorias_idx` (`categorias_id` ASC) VISIBLE,
  INDEX `fk_productos_proveedor1_idx` (`proveedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_productos_categorias`
    FOREIGN KEY (`categorias_id`)
    REFERENCES `patronesSoftware`.`categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_proveedor1`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `patronesSoftware`.`proveedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`lineaOrdenCompras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`lineaOrdenCompras` (
  `id` INT NOT NULL,
  `cantidad` INT NULL,
  `ordencompras_id` INT(11) NOT NULL,
  `productos_id` INT(11) NOT NULL,
  `productos_categorias_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `ordencompras_id`, `productos_id`, `productos_categorias_id`),
  INDEX `fk_LineaOrdenCompras_ordencompras_idx` (`ordencompras_id` ASC) VISIBLE,
  INDEX `fk_lineaOrdenCompras_productos1_idx` (`productos_id` ASC, `productos_categorias_id` ASC) VISIBLE,
  CONSTRAINT `fk_LineaOrdenCompras_ordencompras`
    FOREIGN KEY (`ordencompras_id`)
    REFERENCES `patronesSoftware`.`ordenCompras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lineaOrdenCompras_productos1`
    FOREIGN KEY (`productos_id` , `productos_categorias_id`)
    REFERENCES `patronesSoftware`.`productos` (`id` , `categorias_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `patronesSoftware` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
