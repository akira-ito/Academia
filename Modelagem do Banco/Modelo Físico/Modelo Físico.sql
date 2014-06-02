SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `academia` DEFAULT CHARACTER SET utf8 ;
USE `academia` ;

-- -----------------------------------------------------
-- Table `academia`.`login`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`login` (
  `id` INT(11) NOT NULL ,
  `login` VARCHAR(45) NULL DEFAULT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`aluno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`aluno` (
  `id` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `sexo` VARCHAR(45) NULL DEFAULT NULL ,
  `idade` INT(11) NULL DEFAULT NULL ,
  `login_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_aluno_login_idx` (`login_id` ASC) ,
  CONSTRAINT `fk_aluno_login`
    FOREIGN KEY (`login_id` )
    REFERENCES `academia`.`login` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`objetivo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`objetivo` (
  `id` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `data` DATE NULL DEFAULT NULL ,
  `aluno_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_objetivo_aluno1_idx` (`aluno_id` ASC) ,
  CONSTRAINT `fk_objetivo_aluno1`
    FOREIGN KEY (`aluno_id` )
    REFERENCES `academia`.`aluno` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`detalhe`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`detalhe` (
  `id` INT(11) NOT NULL ,
  `peso` DOUBLE NULL DEFAULT NULL ,
  `porcGordura` DOUBLE NULL DEFAULT NULL ,
  `massCorporal` DOUBLE NULL DEFAULT NULL ,
  `objetivo_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_detalhe_objetivo1_idx` (`objetivo_id` ASC) ,
  CONSTRAINT `fk_detalhe_objetivo1`
    FOREIGN KEY (`objetivo_id` )
    REFERENCES `academia`.`objetivo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`funcionario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`funcionario` (
  `id` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `sexo` VARCHAR(45) NULL DEFAULT NULL ,
  `idade` INT(11) NULL DEFAULT NULL ,
  `login_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_funcionario_login1_idx` (`login_id` ASC) ,
  CONSTRAINT `fk_funcionario_login1`
    FOREIGN KEY (`login_id` )
    REFERENCES `academia`.`login` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '			';


-- -----------------------------------------------------
-- Table `academia`.`modaliade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`modaliade` (
  `id` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `intervaloPausa` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`novidade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`novidade` (
  `id` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `descricao` VARCHAR(45) NULL DEFAULT NULL ,
  `data` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`serie`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`serie` (
  `id` INT(11) NOT NULL ,
  `modaliade_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_serie_modaliade1_idx` (`modaliade_id` ASC) ,
  CONSTRAINT `fk_serie_modaliade1`
    FOREIGN KEY (`modaliade_id` )
    REFERENCES `academia`.`modaliade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`trabalhomodalidade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`trabalhomodalidade` (
  `id` INT(11) NOT NULL ,
  `nome` VARCHAR(45) NULL DEFAULT NULL ,
  `descricao` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`diasemana`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`diasemana` (
  `id` INT NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `academia`.`serie_diasemana`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`serie_diasemana` (
  `serie_id` INT(11) NOT NULL ,
  `diasemana_id` INT NOT NULL ,
  PRIMARY KEY (`serie_id`, `diasemana_id`) ,
  INDEX `fk_serie_has_diasemana_diasemana1_idx` (`diasemana_id` ASC) ,
  INDEX `fk_serie_has_diasemana_serie1_idx` (`serie_id` ASC) ,
  CONSTRAINT `fk_serie_has_diasemana_serie1`
    FOREIGN KEY (`serie_id` )
    REFERENCES `academia`.`serie` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_serie_has_diasemana_diasemana1`
    FOREIGN KEY (`diasemana_id` )
    REFERENCES `academia`.`diasemana` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`trabalho_modaliade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`trabalho_modaliade` (
  `trabalhomodalidade_id` INT(11) NOT NULL ,
  `modaliade_id` INT(11) NOT NULL ,
  PRIMARY KEY (`trabalhomodalidade_id`, `modaliade_id`) ,
  INDEX `fk_trabalhomodalidade_has_modaliade_modaliade1_idx` (`modaliade_id` ASC) ,
  INDEX `fk_trabalhomodalidade_has_modaliade_trabalhomodalidade1_idx` (`trabalhomodalidade_id` ASC) ,
  CONSTRAINT `fk_trabalhomodalidade_has_modaliade_trabalhomodalidade1`
    FOREIGN KEY (`trabalhomodalidade_id` )
    REFERENCES `academia`.`trabalhomodalidade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trabalhomodalidade_has_modaliade_modaliade1`
    FOREIGN KEY (`modaliade_id` )
    REFERENCES `academia`.`modaliade` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `academia`.`objetivo_serie`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `academia`.`objetivo_serie` (
  `objetivo_id` INT(11) NOT NULL ,
  `serie_id` INT(11) NOT NULL ,
  PRIMARY KEY (`objetivo_id`, `serie_id`) ,
  INDEX `fk_objetivo_has_serie_serie1_idx` (`serie_id` ASC) ,
  INDEX `fk_objetivo_has_serie_objetivo1_idx` (`objetivo_id` ASC) ,
  CONSTRAINT `fk_objetivo_has_serie_objetivo1`
    FOREIGN KEY (`objetivo_id` )
    REFERENCES `academia`.`objetivo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_objetivo_has_serie_serie1`
    FOREIGN KEY (`serie_id` )
    REFERENCES `academia`.`serie` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `academia` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
