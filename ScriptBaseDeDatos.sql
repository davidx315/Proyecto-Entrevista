CREATE TABLE `almacen`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigoPedido` VARCHAR(45) NOT NULL,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `descripcionProducto` VARCHAR(200) NOT NULL,
  `valorProducto` FLOAT NOT NULL,
  PRIMARY KEY (`id`));