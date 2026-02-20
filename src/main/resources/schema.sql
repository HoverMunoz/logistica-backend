DROP TABLE IF EXISTS envios;
DROP TABLE IF EXISTS clientes;

CREATE TABLE clientes (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          email VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE envios (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        tipo VARCHAR(50) NOT NULL,
                        peso DOUBLE NOT NULL,
                        precio DOUBLE NOT NULL,
                        fecha DATE NOT NULL
);
