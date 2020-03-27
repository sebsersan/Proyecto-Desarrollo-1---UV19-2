/*SQL SCRIPT FOR DS1*/
/*VERSION 1*/
/* Delete the tables if they already exist */
drop table if exists Users cascade;
drop table if exists Sedes cascade;
drop table if exists Producto cascade;
drop table if exists Inventario cascade;
drop table if exists Venta cascade;
drop table if exists Cotiza cascade;
drop table if exists Orden cascade;
drop table if exists vendedoresSede cascade;

/* Create the schema for our tables */
/*USERS*/
create table Users (idUser int PRIMARY KEY, first_name varchar(30) NOT NULL, last_name varchar(30), telefono varchar(10), direccion varchar(30), work_position varchar(20) NOT NULL, password varchar(40) NOT NULL, stateUser varchar(8) NOT NULL);
/*SEDES*/
create table Sedes (idSedes SERIAL PRIMARY KEY, city varchar(30), address varchar(50) NOT NULL, stateSede varchar(8) NOT NULL, idUser int UNIQUE, FOREIGN KEY (idUser) REFERENCES Users (idUser));

/*TABLA VENDEDOR SEDE*/
create table vendedoresSede (idSedes int, idUser int UNIQUE, PRIMARY KEY(idSedes, idUser), FOREIGN KEY (idUser) REFERENCES Users (idUser), FOREIGN KEY (idSedes) REFERENCES Sedes (idSedes));

/*PRODUCTO*/
drop sequence if exists producto_id_seq cascade;
create sequence producto_id_seq MINVALUE 400 START 401;
create table Producto (idProducto int PRIMARY KEY DEFAULT nextval('producto_id_seq'), nombre varchar(30), descripcion varchar(50) NOT NULL, color varchar(20) NOT NULL,
alto numeric, largo numeric, ancho numeric, precio numeric );
/*INVENTARIO*/
--INVENTARIO VA A ALMACENAR LOS PRODUCTOS DE CADA SEDE, CADA PRODUCTO TIENE EL ID de la sede a la que corresponde
create table Inventario (idProducto int, idSedes int, cantidad int, PRIMARY KEY (idProducto, idSedes), FOREIGN KEY (idProducto) REFERENCES Producto (idProducto), FOREIGN KEY (idSedes) REFERENCES Sedes (idSedes));
/*VENTA*/
create table Venta (idVenta int PRIMARY KEY, idUser int, precioTotal decimal, fecha date,idsedes int, FOREIGN KEY (idUser) REFERENCES Users (idUser), FOREIGN KEY (idsedes) REFERENCES sedes (idsedes) );
/*COTIZACION*/
create table Cotiza (idUser int, idProducto int, fechaCot date, precioCot numeric, PRIMARY KEY (idUser, idProducto), FOREIGN KEY (idUser) REFERENCES Users (idUser), FOREIGN KEY (idProducto) REFERENCES Producto (idProducto));
/*ORDENES*/
create table Orden (idOrden SERIAL PRIMARY KEY, cantidad_pedido int, estado_pedido boolean, idProducto int, idSedes int, FOREIGN KEY (idProducto) REFERENCES Producto (idProducto), FOREIGN KEY (idSedes) REFERENCES Sedes (idSedes));
/* Inserting our data */
insert into Users values(100, 'admin', 'admin', '5513222','casa 4','admin', 'ADMIN', 'Activo');
insert into Users values(111, 'Charles', 'Xavier', '1111','casa 1', 'Gerente', 'gorillaz', 'Activo');
insert into Users values(2488, 'Camilo', 'Sanchez', '2222','casa 2', 'Gerente', '2488', 'Activo');
insert into Users values(222, 'Elon', 'Musk', '33333','casa 3', 'Jefe de Taller', '123', 'Activo');
insert into Users values(333, 'David', 'Fincher', '4444','casa 6', 'Jefe de Taller','123', 'Activo');
insert into Users values(444, 'Itachi', 'Uchiha', '5555','casa 14', 'Vendedor','123', 'Activo');
insert into Users values(555, 'Lars', 'Von Trier', '7777','casa 10', 'Vendedor','123', 'Inactivo'); --Inactive
insert into Users values(666, 'Alfred', 'Hitchcock', '63200','casa 30', 'Vendedor','123', 'Activo');
insert into Users values(777, 'Chritopher', 'Nolan', '63110','casa 80', 'Vendedor','123', 'Activo');
/*Sedes*/
insert into Sedes (city, address, stateSede, idUser) values ('Cali', 'Calle 6 casa 7', 'Activo', 222);
insert into Sedes (city, address, stateSede, idUser) values ('Palmira', 'Calle 18 casa 9', 'Activo', 333);
/*vendedores sedes*/
/*La idea es que solo hayan ids de vendedores*/
insert into vendedoresSede values (1, 444);
insert into vendedoresSede values (2, 666);
insert into vendedoresSede values (2, 777);

/*Productos*/
insert into producto (nombre, descripcion, color, alto, largo, ancho, precio) values ('Super sofa', 'sofa de 3 puestos', 'Cafe Claro', 80, 80, 296, 600000);
insert into producto (nombre, descripcion, color, alto, largo, ancho, precio) values ('Mega sofa', 'sofa de 2 puestos', 'Blanco', 90, 90, 290, 500000);      
insert into producto (nombre, descripcion, color, alto, largo, ancho, precio) values ('Sofa Normal', 'sofa de 2 puestos', 'Cafe Oscuro', 80, 80, 296, 200000);      
insert into producto (nombre, descripcion, color, alto, largo, ancho, precio) values ('Super comedor', 'Comedor para 3 personas', 'Cafe Oscuro', 60, 50, 180, 400000);      
insert into producto (nombre, descripcion, color, alto, largo, ancho, precio) values ('Mega Comedor', 'comedor para 6 personas', 'Negro', 70, 90, 150, 600000);

/*Inventario*/
insert into inventario values (401, 1, 30);
insert into inventario values (402, 1, 30);
insert into inventario values (403, 1, 15);
insert into inventario values (404, 1, 5);
insert into inventario values (405, 1, 1);

insert into inventario values (401, 2, 15);
insert into inventario values (402, 2, 0);
insert into inventario values (403, 2, 0);
insert into inventario values (404, 2, 10);
insert into inventario values (405, 2, 30);
--select * from inventario order by idsedes, idproducto;

--PRIMER PROCEDIMIENTO ALMACENADO
CREATE OR REPLACE function productoNuevo() RETURNS TRIGGER AS $$
       DECLARE
       numeroDeSedes integer ;
       BEGIN
       IF (TG_OP = 'INSERT') THEN
              SELECT COUNT(*) INTO numerodeSedes FROM SEDES;
              FOR i IN 1..numeroDeSedes LOOP
                     INSERT INTO inventario VALUES(new.idProducto, i, 0);
              END LOOP;
       END IF;
       RETURN NULL;
       END;
$$ LANGUAGE plpgsql;

--PRIMER TRIGGER
CREATE TRIGGER insertarProductoNuevo AFTER INSERT ON producto FOR EACH ROW EXECUTE PROCEDURE productoNuevo();

--SEGUNDO PROCEDIMIENTO ALMACENADO

CREATE OR REPLACE function sedeNueva() RETURNS TRIGGER AS $$
       DECLARE
       numeroDeProductos integer;
       id integer;
       BEGIN
       IF (TG_OP = 'INSERT') THEN
              SELECT count(*) INTO numeroDeProductos FROM PRODUCTO;
              FOR i IN 1..numeroDeProductos LOOP
                     select idproducto INTO id from (select *, ROW_NUMBER() OVER () as pos from producto) as foo where foo.pos = i;
                     INSERT INTO inventario VALUES(id, new.idSedes, 0);
              END LOOP;
       END IF;
       RETURN NULL;
       END;
$$ LANGUAGE plpgsql;

--SEGUNDO TRIGGER
CREATE TRIGGER insertarInventarioNuevo AFTER INSERT ON Sedes FOR EACH ROW EXECUTE PROCEDURE sedeNueva();
