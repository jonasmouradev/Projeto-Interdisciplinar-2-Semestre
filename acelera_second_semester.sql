-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28/11/2023 às 01:12
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `acelera_second_semester`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `circuit`
--

CREATE TABLE `circuit` (
  `id` int(11) NOT NULL,
  `name_circuit` varchar(30) DEFAULT NULL,
  `voltage_circuit` int(11) DEFAULT NULL,
  `current` float DEFAULT NULL,
  `wireGauge_circuit` float DEFAULT NULL,
  `breaker` int(11) DEFAULT NULL,
  `fk_house_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `device`
--

CREATE TABLE `device` (
  `id` int(11) NOT NULL,
  `name_device` varchar(30) DEFAULT NULL,
  `power_device` float DEFAULT NULL,
  `voltage_device` int(11) DEFAULT NULL,
  `tot_consumption_device` float DEFAULT NULL,
  `used_hours` float DEFAULT NULL,
  `fk_house_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `house`
--

CREATE TABLE `house` (
  `id` int(11) NOT NULL,
  `name_house` varchar(30) DEFAULT NULL,
  `tot_circuit` int(11) DEFAULT NULL,
  `tot_room` int(11) DEFAULT NULL,
  `tot_consumption_house` float DEFAULT NULL,
  `tot_devices_house` int(11) DEFAULT NULL,
  `tot_power_house` float DEFAULT NULL,
  `tot_charge_house` float DEFAULT NULL,
  `maximum_demand` float DEFAULT NULL,
  `tot_demand` float DEFAULT NULL,
  `demand_factor` float DEFAULT NULL,
  `tot_phase` int(11) DEFAULT NULL,
  `fk_user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `materials`
--

CREATE TABLE `materials` (
  `id` int(11) NOT NULL,
  `tot_lamp_house` int(11) DEFAULT NULL,
  `tot_tug_house` int(11) DEFAULT NULL,
  `wireGauge_house` float DEFAULT NULL,
  `breaker` int(11) DEFAULT NULL,
  `switchboard` int(11) DEFAULT NULL,
  `tot_dr` int(11) DEFAULT NULL,
  `tot_phase` int(11) DEFAULT NULL,
  `tot_dps` int(11) DEFAULT NULL,
  `tot_dtm` int(11) DEFAULT NULL,
  `fk_house_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `area` float DEFAULT NULL,
  `perimeter` float DEFAULT NULL,
  `tot_lamp_room` int(11) DEFAULT NULL,
  `tot_tug_room` int(11) DEFAULT NULL,
  `tot_tue_room` int(11) DEFAULT NULL,
  `fk_house_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `room_type`
--

CREATE TABLE `room_type` (
  `id` int(11) NOT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `room_type`
--

INSERT INTO `room_type` (`id`, `type`) VALUES
(1, 'Área seca'),
(2, 'Área lavável'),
(3, 'Área de circulação');

-- --------------------------------------------------------

--
-- Estrutura para tabela `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `users`
--

INSERT INTO `users` (`id`, `name`, `password`) VALUES
(1, '1', '1'),
(2, 'gabriel', 'gabriel123'),
(3, 'jonas', 'jonas123');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `circuit`
--
ALTER TABLE `circuit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_house_id` (`fk_house_id`);

--
-- Índices de tabela `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_house_id` (`fk_house_id`);

--
-- Índices de tabela `house`
--
ALTER TABLE `house`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_id` (`fk_user_id`);

--
-- Índices de tabela `materials`
--
ALTER TABLE `materials`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_house_id` (`fk_house_id`);

--
-- Índices de tabela `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_house_id` (`fk_house_id`);

--
-- Índices de tabela `room_type`
--
ALTER TABLE `room_type`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `circuit`
--
ALTER TABLE `circuit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `device`
--
ALTER TABLE `device`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `house`
--
ALTER TABLE `house`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de tabela `materials`
--
ALTER TABLE `materials`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de tabela `room_type`
--
ALTER TABLE `room_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `circuit`
--
ALTER TABLE `circuit`
  ADD CONSTRAINT `circuit_ibfk_1` FOREIGN KEY (`fk_house_id`) REFERENCES `house` (`id`);

--
-- Restrições para tabelas `device`
--
ALTER TABLE `device`
  ADD CONSTRAINT `device_ibfk_1` FOREIGN KEY (`fk_house_id`) REFERENCES `house` (`id`);

--
-- Restrições para tabelas `house`
--
ALTER TABLE `house`
  ADD CONSTRAINT `house_ibfk_1` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`);

--
-- Restrições para tabelas `materials`
--
ALTER TABLE `materials`
  ADD CONSTRAINT `materials_ibfk_1` FOREIGN KEY (`fk_house_id`) REFERENCES `house` (`id`);

--
-- Restrições para tabelas `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_2` FOREIGN KEY (`fk_house_id`) REFERENCES `house` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
