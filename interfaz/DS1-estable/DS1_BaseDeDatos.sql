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
datos float NOT NULL,
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



INSERT INTO Persona VALUES (111,'Pablo','Musk',null,'calle 13 # 100 - 01');
INSERT INTO Usuario VALUES (111, 'Administrador', '123',3145678910, 'Activo');

INSERT INTO Persona VALUES(100, 'Charles', 'Xavier', 'Acevedo', 'carrera 23 # 42 - 05');
INSERT INTO Usuario VALUES (100, 'Gerente', 'gorillaz', 3152764536, 'Activo');

INSERT INTO Persona VALUES(101, 'Camilo', 'Sanchez', 'Gutierrez', 'tranversal 25 # 32 - 16');
INSERT INTO Usuario VALUES (102, 'Gerente', '2488', 3004567134, 'Activo');

INSERT INTO Persona VALUES(444, 'Itachi', 'Uchiha', 'Martinez', 'avenida 4N # 13 - 49');
INSERT INTO Usuario VALUES (444, 'Operador','123', 3198657498, 'Activo');

INSERT INTO Persona VALUES(555, 'Lars', 'Von Trier', 'Diomedez','calle 5 # 9 - 64'); 
INSERT INTO Usuario VALUES (555, 'Operador','123', 3116783454, 'Inactivo'); --Inactive

INSERT INTO Persona VALUES(667, 'Alfred', 'Hitchcock', 'Medina','carrera 24 # 8 - 12');
INSERT INTO Usuario VALUES (667, 'Operador','123', 3137652399, 'Activo');

INSERT INTO Persona VALUES(777, 'Chritopher', 'Nolan', 'Vergara','calle 16 # 4 - 67');
INSERT INTO Usuario VALUES (777, 'Operador','123', 3127990182, 'Activo');


CREATE VIEW Usuarios AS
SELECT * FROM persona NATURAL JOIN usuario;

CREATE VIEW Clientes AS
SELECT * FROM persona NATURAL JOIN cliente;


CREATE VIEW Cliente_Telefonos AS
SELECT * FROM clientes NATURAL JOIN telefono;

INSERT INTO Plan VALUES(1,30900,250,1,100,'500 minutos whatsapp + 250 MB chat whasapp + 250 MB facebook');
INSERT INTO Plan VALUES(2,39900,150,4.5,100,'300 minutos whatsapp + 250 MB chat whatsapp + 250 MB Facebook');
INSERT INTO Plan VALUES(3,49900,300,8.5,100,'600 minutos whatsapp + 500 MB chat whatsapp + 500 MB Facebook');
INSERT INTO Plan VALUES(4,65000,1000,20,999999999999,'Whatsapp, Facebook y Waze ilimitado + Llamadas de whatsapp ilimitadas');
INSERT INTO Plan VALUES(5,100000,999999999999,30,999999999999,'Llamadas a EEUU, Canadá y Puerto Rico ilimitadas + Al comprar un nuevo equipo, lo tienes asegurado + Tienes 3GB para compartir con otros dispositivos');



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
INSERT INTO Persona VALUES(52352, 'Miguel', 'Sanchez', 'Acevedo', 'carrera 18 # 35 - 42');
INSERT INTO Cliente VALUES(52352, 'Corporativo');

INSERT INTO Persona VALUES(63251, 'Andres', 'Cow', 'Gutierrez', 
INSERT INTO Cliente VALUES(63251, 'Natural');

INSERT INTO Persona VALUES(2242142, 'Gustavo', 'Suarez', 'Fince',
INSERT INTO Cliente VALUES(2242142, 'Corporativo');

INSERT INTO Persona VALUES(23425, 'Brayan', 'Fincher', 'Musk', 
INSERT INTO Cliente VALUES(23425, 'Natural');

