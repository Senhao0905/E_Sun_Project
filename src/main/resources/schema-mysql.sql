CREATE SCHEMA IF NOT EXISTS `e_sun_project` ;

CREATE TABLE IF NOT EXISTS `e_sun_project`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_email` VARCHAR(20) NOT NULL,
  `user_password` LONGTEXT NOT NULL,
  `user_biography` VARCHAR(300) NULL,
  PRIMARY KEY (`user_id`));