-- MySQL Script generated by MySQL Workbench
-- 04/04/17 13:06:28
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=TRADITIONAL;

-- -----------------------------------------------------
-- Schema boffo_register_schema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema boffo_register_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS boffo_register_schema DEFAULT CHARACTER SET utf8 ;
USE boffo_register_schema ;

-- -----------------------------------------------------
-- Table boffo_register_schema.inventory_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.inventory_tbl (
  inventory_id INT UNSIGNED NOT NULL,
  upc INT NULL,
  enabled TINYINT(1) NULL,
  `name` VARCHAR(45) NULL,
  price DOUBLE NULL,
  quantity INT NULL,
  description VARCHAR(200) NULL,
  rating_id INT NULL,
	FOREIGN KEY fk_rating_id(rating_id)
    REFERENCES rating_tbl(rating_id),
  genre_id INT NULL,
	FOREIGN KEY fk_genre_id(genre_id)
    REFERENCES genre_tbl(genre_id),
  PRIMARY KEY (inventory_id),
  UNIQUE INDEX inventory_id_UNIQUE (inventory_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.user_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.user_tbl (
  user_id INT UNSIGNED NOT NULL,
  user_name VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  security_level_id INT NULL,
	FOREIGN KEY fk_security_level_id(security_level_id)
    REFERENCES security_level_tbl(security_level_id),
  first_name VARCHAR(45) NULL,
  last_name VARCHAR(45) NULL,
  date_of_employment DATETIME NULL,
  date_of_termination DATETIME NULL,
  PRIMARY KEY (user_id),
  UNIQUE INDEX user_id_UNIQUE (user_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.bundle_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.bundle_tbl (
  bundle_id INT UNSIGNED NOT NULL,
  start_date DATETIME NULL,
  end_date DATETIME NULL,
  discount_type_id INT NULL,
	FOREIGN KEY fk_discount_type_id(discount_type_id)
    REFERENCES discount_type_tbl(discount_type_id),
  discount_amount DOUBLE NULL,
  enabled TINYINT(1) NULL,
  description VARCHAR(200) NULL,
  PRIMARY KEY (bundle_id),
  UNIQUE INDEX bundle_id_UNIQUE (bundle_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.transaction_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.transaction_tbl (
  transaction_id INT UNSIGNED NOT NULL,
  inventory_id INT NULL,
	FOREIGN KEY fk_inventory_id(inventory_id)
    REFERENCES inventory_tbl(inventory_id),
  quantity INT NULL,
  ticket_id INT NULL,
	FOREIGN KEY fk_ticket_id(ticket_id)
    REFERENCES ticket_tbl(ticket_id),
  bundle_id INT NULL,
	FOREIGN KEY fk_bundle_id(bundle_id)
    REFERENCES bundle_tbl(bundle_id),
  price DOUBLE NULL,
  PRIMARY KEY (transaction_id),
  UNIQUE INDEX transaction_id_UNIQUE (transaction_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.store_info_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.store_info_tbl (
  store_id INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NULL,
  phone_num VARCHAR(45) NULL,
  hours VARCHAR(45) NULL,
  tax_rate DOUBLE NULL,
  receipt_msg VARCHAR(200) NULL,
  PRIMARY KEY (store_id),
  UNIQUE INDEX store_id_UNIQUE (store_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.rating_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.rating_tbl (
  rating_id INT UNSIGNED NOT NULL,
  `value` VARCHAR(45) NULL,
  PRIMARY KEY (rating_id),
  UNIQUE INDEX rating_id_UNIQUE (rating_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.bundle_type_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.bundle_type_tbl (
  bundle_type_id INT UNSIGNED NOT NULL,
  `value` VARCHAR(45) NULL,
  PRIMARY KEY (bundle_type_id),
  UNIQUE INDEX rating_id_UNIQUE (bundle_type_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.genre_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.genre_tbl (
  genre_id INT UNSIGNED NOT NULL,
  `value` VARCHAR(45) NULL,
  PRIMARY KEY (genre_id),
  UNIQUE INDEX rating_id_UNIQUE (genre_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.sale_type_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.sale_type_tbl (
  sale_type_id INT UNSIGNED NOT NULL,
  `value` VARCHAR(45) NULL,
  PRIMARY KEY (sale_type_id),
  UNIQUE INDEX rating_id_UNIQUE (sale_type_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.security_level_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.security_level_tbl (
  security_level_id INT UNSIGNED NOT NULL,
  `value` VARCHAR(45) NULL,
  PRIMARY KEY (security_level_id),
  UNIQUE INDEX rating_id_UNIQUE (security_level_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.bundle_items_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.bundle_items_tbl (
  bundle_items_id INT UNSIGNED NOT NULL,
  bundle_id INT NULL,
	FOREIGN KEY fk_bundle_id(bundle_id)
    REFERENCES bundle_tbl(bundle_id),
  inventory_id INT NULL,
	FOREIGN KEY fk_inventory_id(inventory_id)
    REFERENCES inventory_tbl(inventory_id),
  PRIMARY KEY (bundle_items_id),
  UNIQUE INDEX bundle_items_id_UNIQUE (bundle_items_id ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table boffo_register_schema.ticket_tbl
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS boffo_register_schema.ticket_tbl (
  ticket_id INT UNSIGNED NOT NULL,
  `date` DATETIME NULL,
  sale_type_id INT NULL,
	FOREIGN KEY fk_sale_type_id(sale_type_id)
    REFERENCES sale_type_tbl(sale_type_id),
  user_id INT NULL,
	FOREIGN KEY fk_user_id(user_id)
    REFERENCES user_tbl(user_id),
  PRIMARY KEY (ticket_id),
  UNIQUE INDEX ticket_id_UNIQUE (ticket_id ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
