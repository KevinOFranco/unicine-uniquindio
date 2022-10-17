insert into cliente values (1, "1", "juan@email.com", "2001-07-27", "Juan", "juan123", null, null);
insert into cliente values (2, "2", "ana@email.com", "2001-07-10", "Ana", "ana123", null, null);
insert into cliente values (3, "3", "raul@email.com", "2001-07-08", "Raul", "raul123", null, null);
insert into cliente values (4, "4", "valentina@email.com", "2001-07-09", "Valentina", "valentina123", null, null);
insert into cliente values (5, "5", "andres@email.com", "2001-07-19", "Andres", "andres123", null, null);


insert into cliente_telefono values (1, "100", "Casa");
insert into cliente_telefono values (1, "101", "Casa");
insert into cliente_telefono values (1, "102", "Trabajo");


insert into cliente_telefono values (2, "200", "Casa");
insert into cliente_telefono values (2, "201", "Casa");
insert into cliente_telefono values (2, "202", "Trabajo");


insert into cliente_telefono values (3, "300", "Casa");
insert into cliente_telefono values (3, "301", "Casa");
insert into cliente_telefono values (3, "302", "Trabajo");


insert into cliente_telefono values (4, "400", "Casa");
insert into cliente_telefono values (4, "401", "Casa");
insert into cliente_telefono values (4, "402", "Trabajo");


insert into cliente_telefono values (5, "500", "Casa");
insert into cliente_telefono values (5, "501", "Casa");
insert into cliente_telefono values (5, "502", "Trabajo");


insert into ciudad values (1, "Quindio", "Armenia");
insert into ciudad values (2, "Antioquia", "Medellin");
insert into ciudad values (3, "Valle del cauca", "Cali");
insert into ciudad values (4, "Meta", "Villavicencio");
insert into ciudad values (5, "Cundinamarca", "Bogota");


insert into pelicula values (1, "Preventa", "Fantasia", "imagenAvatar", "Avatar", null, null, null);
insert into pelicula values (2, "Cartelera", "Accion", "imagenRyF", "Rapidos y furiosos", null, null, null);
insert into pelicula values (3, "Cartelera", "Animada", "imagenCoco", "Coco", null, null, null);
insert into pelicula values (4, "Preventa", "Terror", "imagenLaMonja", "La monja", null, null, null);
insert into pelicula values (5, "Cartelera", "Ficcion", "imagenThor", "Thor", null, null, null);


insert into confiteria values (1, "Gaseosa pequeña y crispetas pequeñas", "imagenCombo1", 1000, "Combo 1");
insert into confiteria values (2, "Gaseosa mediana y crispetas medianas", "imagenCombo2", 2000, "Combo 2");
insert into confiteria values (3, "Gaseosa grande y crispetas grandes", "imagenCombo3", 3000, "Combo 3");
insert into confiteria values (4, "Gaseosa pequeña y crispetas medianas", "imagenCombo4", 2500, "Combo 4");
insert into confiteria values (5, "Gaseosa mediana y crispetas pequeñas", "imagenCombo5", 2200, "Combo 5");


insert into administrador_teatro values (1, "6", "michael@email.com", "1990-01-10", "Michael", "michael123");
insert into administrador_teatro values (2, "7", "angie@email.com", "1995-01-20", "Angie", "angie123");
insert into administrador_teatro values (3, "8", "francisco@email.com", "1995-01-21", "Francisco", "francisco123");
insert into administrador_teatro values (4, "9", "monica@email.com", "1995-01-22", "Monica", "monica123");
insert into administrador_teatro values (5, "10", "danilo@email.com", "1995-01-23", "Danilo", "danilo123");



insert into teatro values (1, "Avenida 1", "Teatro Camp Nou", 1, 4);
insert into teatro values (2, "Avenida 2", "Teatro Spotify Bernabeu", 1, 2);
insert into teatro values (3, "Avenida 3", "Teatro Atanasio Girardot", 2, 3);
insert into teatro values (4, "Avenida 4", "Teatro Centenario", 2, 1);
insert into teatro values (5, "Avenida 5", "Teatro Apostol", 5, 5);


insert into cupon values ("1", null, null, "2022-12-31", 30);
insert into cupon values ("2", null, null, "2023-01-01", 50);
insert into cupon values ("3", null, null, "2026-06-01", 10);
insert into cupon values ("4", null, null, "2027-07-07", 30);
insert into cupon values ("5", null, null, "2030-09-09", 5);


insert into horario values (1, "2022-10-10", "20:00:00", "21:30:00");
insert into horario values (2, "2022-10-11", "21:00:00", "22:30:00");
insert into horario values (3, "2022-10-13", "19:00:00", "21:30:00");
insert into horario values (4, "2022-10-14", "18:00:00", "20:30:00");
insert into horario values (5, "2022-10-15", "20:00:00", "23:30:00");


insert into sala values (1, 1);
insert into sala values (2, 1);

insert into sala values (3, 2);
insert into sala values (4, 2);

insert into sala values (5, 3);
insert into sala values (6, 3);

insert into sala values (7, 4);
insert into sala values (8, 4);


insert into compra values (1, 1, "2022-10-01 10:00:00", "Tarjeta_Credito");
insert into compra values (2, 1, "2022-10-02 10:00:00", "PSE");

insert into compra values (3, 2, "2022-10-03 10:00:00", "Tarjeta_Credito");
insert into compra values (4, 2, "2022-10-04 10:00:00", "PSE");

insert into compra values (5, 3, "2022-10-05 10:00:00", "Tarjeta_Debito");
insert into compra values (6, 3, "2022-10-06 10:00:00", "Tarjeta_Debito");

insert into compra values (7, 4, "2022-10-07 10:00:00", "Tarjeta_Credito");
insert into compra values (8, 4, "2022-10-08 10:00:00", "Tarjeta_Debito");

insert into compra values (9, 5, "2022-10-09 10:00:00", "PSE");
insert into compra values (10, 5, "2022-10-10 10:00:00", "Tarjeta_Credito");

insert into compra_confiteria values (1, 100, 10, 1, 1);
insert into compra_confiteria values (2, 200, 20, 2, 1);
insert into compra_confiteria values (3, 300, 30, 3, 4);
insert into compra_confiteria values (4, 400, 40, 4, 3);
insert into compra_confiteria values (5, 500, 50, 5, 2);


insert into pelicula_favorita values (1, 1, 1);
insert into pelicula_favorita values (2, 1, 2);
insert into pelicula_favorita values (3, 2, 1);
insert into pelicula_favorita values (4, 3, 2);
insert into pelicula_favorita values (5, 4, 3);


insert into cupon_cliente values (1, 1, 1, 1);
insert into cupon_cliente values (2, 2, 2, 2);
insert into cupon_cliente values (3, 3, 3, 3);
insert into cupon_cliente values (4, 4, 4, 4);
insert into cupon_cliente values (5, 5, 5, 5);


insert into funcion values (1, 10, 1, 1, 1);
insert into funcion values (2, 20, 1, 2, 2);
insert into funcion values (3, 30, 2, 3, 3);
insert into funcion values (4, 40, 3, 4, 4);
insert into funcion values (5, 50, 4, 1, 5);


--Cliente
--Ciudad
--Administrador teatro
--Horario
--Pelicula
--Cupon
--Teatro
--Sala
--Confiteria
--Cliente telefono
--Compra
--Compra Confiteria
--Pelicula favorita
--Cupon Cliente
--Funcion