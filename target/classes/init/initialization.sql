CREATE TABLE `webstore`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL DEFAULT 'password123',
  `role_id` INT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `user_name_UNIQUE` (`username` ASC));

CREATE TABLE `webstore`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_id_UNIQUE` (`role_id` ASC),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC));

ALTER TABLE `webstore`.`user` 
ADD INDEX `user_role_fk_idx` (`role_id` ASC);
ALTER TABLE `webstore`.`user` 
ADD CONSTRAINT `user_role_fk`
  FOREIGN KEY (`role_id`)
  REFERENCES `webstore`.`role` (`role_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  
CREATE TABLE `webstore`.`product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_title` VARCHAR(100) NULL,
  `product_description` VARCHAR(1000) NULL,
  `cost` DOUBLE NULL,
  `price` DOUBLE NULL,
  `total_sales` INT NULL,
  `quantity_in_stock` INT NULL,
  `quantity_on_order` INT NULL,
  `image` BLOB NULL,
  `image_ext` VARCHAR(11) NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC));
  
CREATE TABLE `webstore`.`user_information` (
  `user_id` INT NOT NULL,
  `email` VARCHAR(100) NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  CONSTRAINT `user`
    FOREIGN KEY (`user_id`)
    REFERENCES `webstore`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
