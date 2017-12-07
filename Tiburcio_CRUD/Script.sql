CREATE SCHEMA IF NOT EXISTS `tiburcio` DEFAULT CHARACTER SET utf8 ;
USE `tiburcio` ;


-- -----------------------------------------------------
-- Table `tiburcio`.`Sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiburcio`.`Sala` (
  `idSala` INT NOT NULL,
  `Escola` VARCHAR(45) NULL,
  PRIMARY KEY (`idSala`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tiburcio`.`Materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiburcio`.`Materia` (
  `idMateria` VARCHAR(3) NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `PesoN1` FLOAT NULL,
  `PesoN2` FLOAT NOT NULL,
  PRIMARY KEY (`idMateria`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `tiburcio`.`Materia_Sala`
-- -----------------------------------------------------
   CREATE TABLE IF NOT EXISTS `tiburcio`.`Materia_Sala` (
  `Hora` VARCHAR(5) NOT NULL,
  `Dia` VARCHAR(45) NOT NULL,
  `Sala_idSala` INT NOT NULL,
  `Materia_idMateria` VARCHAR(3) NOT NULL,  
  PRIMARY KEY (`Hora`, `Dia`),
  CONSTRAINT `fk_Materia`
    FOREIGN KEY (`Materia_idMateria`)
    REFERENCES `tiburcio`.`Materia` (`idMateria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`Sala_idSala`)
    REFERENCES `tiburcio`.`Sala` (`idSala`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
  

-- -----------------------------------------------------
-- Table `tiburcio`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiburcio`.`Aluno` (
  `idAluno` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idAluno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiburcio`.`Sala_has_Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiburcio`.`Nota` (
  `Sala_Materia_idMateria` VARCHAR(3) NOT NULL,
  `Aluno_idAluno` INT NOT NULL,
  `Aula_Hora` VARCHAR(5) NOT NULL,
  `Aula_Dia` VARCHAR(45) NOT NULL,
  `Sala_idSala` INT NOT NULL,
  `N1` FLOAT NULL,
  `N2` FLOAT NULL,
  `Media` FLOAT NULL,
  PRIMARY KEY (`Aluno_idAluno`, `Aula_Hora`, `Aula_Dia`),
  CONSTRAINT `fk_Nota_Materia`
    FOREIGN KEY (`Sala_Materia_idMateria`)
    REFERENCES `tiburcio`.`Materia_Sala` (`Materia_idMateria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Nota_Aluno`
    FOREIGN KEY (`Aluno_idAluno`)
    REFERENCES `tiburcio`.`Aluno` (`idAluno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Materia_Sala_Hora`
    FOREIGN KEY (`Aula_Hora`)
    REFERENCES `tiburcio`.`Materia_Sala` (`Hora`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)

ENGINE = InnoDB;