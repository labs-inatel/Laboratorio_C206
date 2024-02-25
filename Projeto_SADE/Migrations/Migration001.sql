-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Database mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Database mydb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `mydb`;
CREATE DATABASE `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Escola`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Escola` (
  `idEscola` INT NOT NULL AUTO_INCREMENT,
  `nomeEscola` VARCHAR(50) NOT NULL,
  `cnpjEscola` VARCHAR(18) NOT NULL,
  `localizacao` VARCHAR(80) NOT NULL,
  `contato` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idEscola`, `nomeEscola`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Coordenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Coordenador` (
  `idCoordenador` INT NOT NULL AUTO_INCREMENT,
  `nomeCoordenador` VARCHAR(50) NOT NULL,
  `cpfCoordenador` VARCHAR(14) NOT NULL,
  `rgCoordenador` VARCHAR(13) NOT NULL,
  `dataNascC` VARCHAR(10) NOT NULL,
  `NaturalidadeCoordenador` VARCHAR(50) NOT NULL,
  `enderecoCoordenador` VARCHAR(80) NOT NULL,
  `contatoCoordenador` VARCHAR(30) NULL,
  `Escola_idEscola` INT,
  PRIMARY KEY (`idCoordenador`, `cpfCoordenador`),
  INDEX `fk_Coordenador_Escola1_idx` (`Escola_idEscola` ASC) VISIBLE,
  CONSTRAINT `fk_Coordenador_Escola1`
    FOREIGN KEY (`Escola_idEscola`)
    REFERENCES `mydb`.`Escola` (`idEscola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Turma` (
  `idTurma` INT NOT NULL AUTO_INCREMENT,
  `serie` INT NOT NULL,
  `numTurma` INT NOT NULL,
  `Escola_idEscola` INT,
  `Coordenador_idCoordenador` INT,
  PRIMARY KEY (`idTurma`),
  INDEX `fk_Turma_Escola1_idx` (`Escola_idEscola` ASC) VISIBLE,
  INDEX `fk_Turma_Coordenador1_idx` (`Coordenador_idCoordenador` ASC) VISIBLE,
  CONSTRAINT `fk_Turma_Escola1`
    FOREIGN KEY (`Escola_idEscola`)
    REFERENCES `mydb`.`Escola` (`idEscola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_Coordenador1`
    FOREIGN KEY (`Coordenador_idCoordenador`)
    REFERENCES `mydb`.`Coordenador` (`idCoordenador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Aluno` (
  `matriculaAluno` INT NOT NULL AUTO_INCREMENT,
  `escolaOrigem` VARCHAR(50) NOT NULL,
  `nomeAluno` VARCHAR(50) NOT NULL,
  `cpfAluno` VARCHAR(14) NOT NULL,
  `rgAluno` VARCHAR(13) NULL,
  `dataNasc` VARCHAR(10) NOT NULL,
  `naturalidadeAluno` VARCHAR(50) NOT NULL,
  `sexoAluno` CHAR(10) NOT NULL,
  `nomeFiliacao1` VARCHAR(50) NOT NULL,
  `nomeFiliacao2` VARCHAR(50) NULL,
  `enderecoAluno` VARCHAR(80) NOT NULL,
  `contatoAluno` VARCHAR(30) NULL,
  `Turma_idTurma` INT,
  `Escola_idEscola` INT,
  PRIMARY KEY (`matriculaAluno`, `cpfAluno`),
  INDEX `fk_Aluno_Turma1_idx` (`Turma_idTurma` ASC) VISIBLE,
  INDEX `fk_Aluno_Escola1_idx` (`Escola_idEscola` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_Turma1`
    FOREIGN KEY (`Turma_idTurma`)
    REFERENCES `mydb`.`Turma` (`idTurma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_Escola1`
    FOREIGN KEY (`Escola_idEscola`)
    REFERENCES `mydb`.`Escola` (`idEscola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Professor` (
  `idProfessor` INT NOT NULL AUTO_INCREMENT,
  `nomeProfessor` VARCHAR(50) NOT NULL,
  `cpfProfessor` VARCHAR(14) NOT NULL,
  `rgProfessor` VARCHAR(13) NOT NULL,
  `dataNascP` VARCHAR(10) NOT NULL,
  `naturalidadeProfessor` VARCHAR(50) NOT NULL,
  `sexoProfessor` CHAR(10) NOT NULL,
  `cargo` VARCHAR(20) NOT NULL,
  `disciplina` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(80) NOT NULL,
  `contato` VARCHAR(30) NULL,
  PRIMARY KEY (`idProfessor`, `cpfProfessor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Aluno_has_Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Aluno_has_Professor` (
  `Aluno_matriculaAluno` INT NOT NULL,
  `Professor_idProfessor` INT NOT NULL,
  PRIMARY KEY (`Aluno_matriculaAluno`, `Professor_idProfessor`),
  INDEX `fk_Aluno_has_Professor_Professor1_idx` (`Professor_idProfessor` ASC) VISIBLE,
  INDEX `fk_Aluno_has_Professor_Aluno_idx` (`Aluno_matriculaAluno` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_has_Professor_Aluno`
    FOREIGN KEY (`Aluno_matriculaAluno`)
    REFERENCES `mydb`.`Aluno` (`matriculaAluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_Professor_Professor1`
    FOREIGN KEY (`Professor_idProfessor`)
    REFERENCES `mydb`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Professor_has_Turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Professor_has_Turma` (
  `Professor_idProfessor` INT NOT NULL,
  `Turma_idTurma` INT NOT NULL,
  PRIMARY KEY (`Professor_idProfessor`, `Turma_idTurma`),
  INDEX `fk_Professor_has_Turma_Turma1_idx` (`Turma_idTurma` ASC) VISIBLE,
  INDEX `fk_Professor_has_Turma_Professor1_idx` (`Professor_idProfessor` ASC) VISIBLE,
  CONSTRAINT `fk_Professor_has_Turma_Professor1`
    FOREIGN KEY (`Professor_idProfessor`)
    REFERENCES `mydb`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_has_Turma_Turma1`
    FOREIGN KEY (`Turma_idTurma`)
    REFERENCES `mydb`.`Turma` (`idTurma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Professor_has_Escola`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Professor_has_Escola` (
  `Professor_idProfessor` INT NOT NULL,
  `Escola_idEscola` INT NOT NULL,
  PRIMARY KEY (`Professor_idProfessor`, `Escola_idEscola`),
  INDEX `fk_Professor_has_Escola_Escola1_idx` (`Escola_idEscola` ASC) VISIBLE,
  INDEX `fk_Professor_has_Escola_Professor1_idx` (`Professor_idProfessor` ASC) VISIBLE,
  CONSTRAINT `fk_Professor_has_Escola_Professor1`
    FOREIGN KEY (`Professor_idProfessor`)
    REFERENCES `mydb`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_has_Escola_Escola1`
    FOREIGN KEY (`Escola_idEscola`)
    REFERENCES `mydb`.`Escola` (`idEscola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Diretor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Diretor` (
  `idDiretor` INT NOT NULL AUTO_INCREMENT,
  `nomeDiretor` VARCHAR(50) NOT NULL,
  `cpfDiretor` VARCHAR(14) NOT NULL,
  `rgDiretor` VARCHAR(13) NOT NULL,
  `dataNascD` VARCHAR(10) NOT NULL,
  `NaturalidadeDiretor` VARCHAR(50) NOT NULL,
  `endereco` VARCHAR(80) NOT NULL,
  `contato` VARCHAR(30) NULL,
  `Escola_idEscola` INT,
  PRIMARY KEY (`idDiretor`, `cpfDiretor`),
  INDEX `fk_Diretor_Escola1_idx` (`Escola_idEscola` ASC) VISIBLE,
  CONSTRAINT `fk_Diretor_Escola1`
    FOREIGN KEY (`Escola_idEscola`)
    REFERENCES `mydb`.`Escola` (`idEscola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SELECT * FROM mydb.`Aluno`;
SELECT * FROM mydb.`Professor`;
SELECT * FROM mydb.`Escola`;
SELECT * FROM mydb.`Diretor`;
SELECT * FROM mydb.`Coordenador`;
SELECT * FROM mydb.`Turma`;
