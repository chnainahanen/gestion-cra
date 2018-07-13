
 CREATE TABLE `gestioncra`.`company` (
  `id` BIGINT(20) NOT NULL auto_increment,
  `companyId` VARCHAR(20) NULL ,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `emailBill` VARCHAR(45) NULL,
  `emailContrat` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
    

  
  CREATE TABLE `gestioncra`.`bill` (
  `id` BIGINT(20) NOT NULL auto_increment,
  `tva` BIGINT(20) NULL,
  `paid` boolean NULL,
  `globalAmount` BIGINT(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
  
   
  CREATE TABLE `gestioncra`.`contract` (
  `id` BIGINT(20) NOT NULL auto_increment,
  `contractId` BIGINT(20) NULL,
  `tjm` BIGINT(20) NULL,
  `startDate` date NULL,
  `endDate` date NULL,
  `paiementPeriod` BIGINT(20) NULL,
  `comment` VARCHAR(45) NULL,
  `active` boolean NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
    CREATE TABLE `gestioncra`.`cra` (
  `id` BIGINT(20) NOT NULL auto_increment,
  `year` BIGINT(20) NULL,
  `month` BIGINT(20) NULL,
  `days` BIGINT(20) NULL,
  `status` BIGINT(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
  
  