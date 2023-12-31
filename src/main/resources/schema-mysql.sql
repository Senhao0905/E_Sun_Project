
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` VARCHAR(50) NOT NULL,
  `user_name` VARCHAR(50) NOT NULL,
  `user_email` VARCHAR(50) NOT NULL,
  `user_password` LONGTEXT NOT NULL,
  `user_biography` VARCHAR(300) NULL,
  PRIMARY KEY (`user_id`));
  
CREATE TABLE IF NOT EXISTS `post` (
  `post_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(50) NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `created_time` DATETIME NULL,
  PRIMARY KEY (`post_id`));
  
  
 CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(50) NOT NULL,
  `post_id` INT NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `created_time` DATETIME NULL,
  PRIMARY KEY (`comment_id`));