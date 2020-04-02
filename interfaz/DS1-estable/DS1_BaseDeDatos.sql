CREATE TABLE Persona (

cedula bigint PRIMARY KEY NOT NULL,
nombre_persona char(40) NOT NULL,
paterno_persona char(30) NOT NULL,
materno_persona char(30),
direccion_persona char(45) NOT NULL

);
------------------------------------------

CREATE TABLE Cliente (

cedula bigint PRIMARY KEY NOT NULL,
tipo_cliente char(12) NOT NULL

);

ALTER TABLE Cliente 
	ADD CONSTRAINT PersonaCliente FOREIGN KEY (cedula) REFERENCES Persona(cedula);
------------------------------------------

CREATE TABLE Usuario (

cedula bigint PRIMARY KEY NOT NULL,
tipo_usuario char(15) NOT NULL,
password_usuario char(15) NOT NULL,
telefono_usuario bigint NOT NULL,
estado_usuario char(8) NOT NULL

);

ALTER TABLE Usuario 
	ADD CONSTRAINT PersonaUsuario FOREIGN KEY (cedula) REFERENCES Persona(cedula);
------------------------------------------

CREATE TABLE Plan (

id_plan int PRIMARY KEY NOT NULL,
costo int NOT NULL,
minutos int NOT NULL,
datos int NOT NULL,
mensajes int NOT NULL, 
adiccionales char(200) NOT NULL

);
------------------------------------------

CREATE TABLE Telefono (

cedula bigint NOT NULL,
numero_telefono bigint PRIMARY KEY NOT NULL,
id_plan int NOT NULL


);


ALTER TABLE Telefono 
	ADD CONSTRAINT PlanTelefono FOREIGN KEY (id_plan) REFERENCES Plan (id_plan);

ALTER TABLE Telefono
	ADD CONSTRAINT ClienteTelefono FOREIGN KEY (cedula) REFERENCES Cliente (cedula);
------------------------------------------

CREATE TABLE Factura (

id_factura int PRIMARY KEY NOT NULL,
total_a_pagar int NOT NULL,
fecha_limite date NOT NULL,
estado_financiero boolean NOT NULL default FALSE


);



INSERT INTO Persona VALUES (111,'Pablo','Musk',null,'Calle 13');
INSERT INTO Usuario VALUES (111, 'Administrador', '123',3145678910, 'Activo');


CREATE VIEW Usuarios AS
SELECT * FROM persona NATURAL JOIN usuario;

CREATE VIEW Clientes AS
SELECT * FROM persona NATURAL JOIN cliente;


CREATE VIEW Cliente_Telefonos AS
SELECT * FROM clientes NATURAL JOIN telefono;

INSERT INTO Plan VALUES(1,'10000','100','100','100','llamadas internacionales');


