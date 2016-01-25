# --- !Ups

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema phuot
-- -----------------------------------------------------
-- DROP SCHEMA IF EXISTS `phuot` ;
-- CREATE SCHEMA IF NOT EXISTS `phuot` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- SHOW WARNINGS;
-- USE `phuot` ;

-- -----------------------------------------------------
-- Table `phuot`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phuot`.`users`;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `phuot`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` TEXT NOT NULL,
  `password` BLOB NOT NULL,
  `user_role` VARCHAR(128) NOT NULL DEFAULT 'r_user',
  `first_name` TINYTEXT NULL,
  `last_name` TINYTEXT NULL,
  `profile_photo` TEXT NULL,
  `facebook_id` TINYTEXT NULL,
  `last_capture_time` DATETIME NULL,
  `status` INT UNSIGNED ZEROFILL NOT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `phuot`.`plans`
-- -----------------------------------------------------
DROP TABlE IF EXISTS `phuot`.`plans` ;
SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `phuot`.`plans` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` TEXT NOT NULL,
  `description` TEXT NOT NULL,
  `content` TEXT NOT NULL,
  `picture` TEXT NULL,
  `user_id` BIGINT NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `status` INT UNSIGNED ZEROFILL NOT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `phuot`.`tasks`
-- -----------------------------------------------------
DROP TABlE IF EXISTS `phuot`.`tasks` ;
SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `phuot`.`tasks` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` TEXT NOT NULL,
  `description` TEXT NOT NULL,
  `content` TEXT NOT NULL,
  `picture` TEXT NULL,
  `user_id` BIGINT NOT NULL,
  `user_assign_id` BIGINT NOT NULL,
  `plan_id` BIGINT NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `status` INT UNSIGNED ZEROFILL NOT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `phuot`.`comments`
-- -----------------------------------------------------
DROP TABlE IF EXISTS `phuot`.`comments` ;
SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `phuot`.`comments` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `comment` TEXT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `plan_id` BIGINT NOT NULL,
  `status` INT UNSIGNED ZEROFILL NOT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `phuot`.`albums`
-- -----------------------------------------------------
DROP TABlE IF EXISTS `phuot`.`albums` ;
SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `phuot`.`albums` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` TEXT NOT NULL,
  `description` TEXT NOT NULL,
  `picture` TEXT NULL,
  `user_id` BIGINT NOT NULL,
  `plan_id` BIGINT NOT NULL,
  `status` INT UNSIGNED ZEROFILL NOT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `phuot`.`gallery`
-- -----------------------------------------------------
DROP TABlE IF EXISTS `phuot`.`gallery` ;
SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `phuot`.`gallery` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` TEXT NULL,
  `description` TEXT NULL,
  `picture` TEXT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `album_id` BIGINT NOT NULL,
  `status` INT UNSIGNED ZEROFILL NOT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `phuot`.`videos`
-- -----------------------------------------------------
DROP TABlE IF EXISTS `phuot`.`videos` ;
SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `phuot`.`videos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` TEXT NULL,
  `description` TEXT NULL,
  `URL` TEXT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `album_id` BIGINT NOT NULL,
  `status` INT UNSIGNED ZEROFILL NOT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;
SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

# --- !Downs

DROP TABLE `phuot`.`comments`;
DROP TABLE `phuot`.`videos`;
DROP TABLE `phuot`.`gallery`;
DROP TABLE `phuot`.`albums`;
DROP TABLE `phuot`.`tasks`;
DROP TABLE `phuot`.`plans`;
DROP TABLE `phuot`.`users`;
