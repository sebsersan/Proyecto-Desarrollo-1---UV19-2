CREATE TABLE Usuario (
	cedula int PRIMARY KEY NOT NULL,
	nombre_persona char(40) NOT NULL,
	paterno_persona char(30) NOT NULL,
	materno_persona char(30),
	telefono_persona char(10), --esto es nuevo
	direccion_persona char(30), --esto es nuevo
	cargo_persona char(20) NOT NULL, --esto es nuevo
	constraseña_persona char(40) NOT NULL, --esto es nuevo
	estado_persona char(8) NOT NULL --esto es nuevo
);

insert into Persona values(111, 'Charles', 'Xavier', 'Acevedo', '1111','casa 1', 'Gerente', 'gorillaz', 'Activo');
insert into Persona values(2488, 'Camilo', 'Sanchez', 'Gutierrez', '2222','casa 2', 'Gerente', '2488', 'Activo');
insert into Persona values(222, 'Elon', 'Musk', 'Sanchez','33333','casa 3', 'Administrador', '123', 'Activo');
insert into Persona values(333, 'David', 'Fincher', 'Cow', '4444','casa 6', 'Administrador','123', 'Activo');
insert into Persona values(444, 'Itachi', 'Uchiha', 'Martinez', '5555','casa 14', 'Operador','123', 'Activo');
insert into Persona values(555, 'Lars', 'Von Trier', 'Diomedez', '7777','casa 10', 'Operador','123', 'Inactivo'); --Inactive
insert into Persona values(666, 'Alfred', 'Hitchcock', 'Medina', '63200','casa 30', 'Operador','123', 'Activo');
insert into Persona values(777, 'Chritopher', 'Nolan', 'Vergara', '63110','casa 80', 'Operador','123', 'Activo');
------------------------------------------

CREATE TABLE Cliente (
	cedula int PRIMARY KEY NOT NULL,
	nombre_cliente char(40) NOT NULL, --esto es nuevo
	paterno_cliente char(30) NOT NULL, --esto es nuevo
	materno_cliente char(30), --esto es nuevo
	telefono_cliente char(10), --esto es nuevo
	tipo_cliente char(12) NOT NULL,
	direccion_cliente char(45) NOT NULL
);
insert into Cliente values(52352, 'Miguel', 'Sanchez', 'Acevedo', '523523552', 'Corporativo','casa 1523');
insert into Cliente values(63251, 'Andres', 'Cow', 'Gutierrez', '525235', 'Natural','casa 2423');
insert into Cliente values(2242142, 'Gustavo', 'Suarez', 'Fince','5235235', 'Corporativo','casa 5233');
insert into Cliente values(23425, 'Brayan', 'Fincher', 'Musk', '623623', 'Natural','casa 6656');
------------------------------------------

CREATE TABLE Telefono (
	numero_telefono int PRIMARY KEY NOT NULL,
	id_plan int NOT NULL,
	cedula int NOT NULL
);

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

CREATE TABLE Factura (
	id_factura int PRIMARY KEY NOT NULL,
	total_a_pagar int NOT NULL,
	fecha_limite date NOT NULL,
	estado_financiero bool NOT NULL
);