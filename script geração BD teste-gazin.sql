-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 03-Nov-2019 às 17:38
-- Versão do servidor: 10.4.8-MariaDB
-- versão do PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `teste-gazin`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ator`
--

CREATE TABLE `ator` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `atuacao`
--

CREATE TABLE `atuacao` (
  `id` bigint(20) NOT NULL,
  `papel` varchar(255) NOT NULL,
  `ator_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `diretor`
--

CREATE TABLE `diretor` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `filme`
--

CREATE TABLE `filme` (
  `tipo` varchar(1) NOT NULL,
  `id` bigint(20) NOT NULL,
  `dt_gravacao_fim` datetime DEFAULT NULL,
  `dt_gravacao_inicio` datetime DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  `verba` decimal(19,2) DEFAULT NULL,
  `assunto` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `ator_id` bigint(20) DEFAULT NULL,
  `diretor_id` bigint(20) NOT NULL,
  `produtor_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `filme_atuacao`
--

CREATE TABLE `filme_atuacao` (
  `filme_id` bigint(20) NOT NULL,
  `atuacao_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtor`
--

CREATE TABLE `produtor` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `ator`
--
ALTER TABLE `ator`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `atuacao`
--
ALTER TABLE `atuacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhwknkc0gn6if8oi57on922ii5` (`ator_id`);

--
-- Índices para tabela `diretor`
--
ALTER TABLE `diretor`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `filme`
--
ALTER TABLE `filme`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKntufh29rr10fp1c2xv5f0fq6u` (`ator_id`),
  ADD KEY `FKs77pnrgth379pum02tyqls55c` (`diretor_id`),
  ADD KEY `FKhlckqnviygor8fbgwkxp81a1h` (`produtor_id`);

--
-- Índices para tabela `filme_atuacao`
--
ALTER TABLE `filme_atuacao`
  ADD UNIQUE KEY `UK_41p5d76moggnwp9xfeqcgg54a` (`atuacao_id`),
  ADD KEY `FKp55pon9fujtkjgbgemia5xoim` (`filme_id`);

--
-- Índices para tabela `produtor`
--
ALTER TABLE `produtor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `ator`
--
ALTER TABLE `ator`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `atuacao`
--
ALTER TABLE `atuacao`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `diretor`
--
ALTER TABLE `diretor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `filme`
--
ALTER TABLE `filme`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produtor`
--
ALTER TABLE `produtor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
