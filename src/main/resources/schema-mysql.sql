CREATE SCHEMA IF NOT EXISTS `e_sun_project` ;

CREATE TABLE IF NOT EXISTS `e_sun_project`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_email` VARCHAR(20) NOT NULL,
  `user_password` LONGTEXT NOT NULL,
  `user_biography` VARCHAR(300) NULL,
  PRIMARY KEY (`user_id`));
  
CREATE TABLE IF NOT EXISTS `post` (
  `post_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `created_time` DATETIME NULL,
  PRIMARY KEY (`post_id`));