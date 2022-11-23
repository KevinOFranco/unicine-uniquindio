insert into cliente values (1, "1", "juan@email.com", "2001-07-27", "Juan", "juan123", null, null);
insert into cliente values (2, "2", "ana@email.com", "2001-07-10", "Ana", "ana123", null, null);
insert into cliente values (3, "3", "raul@email.com", "2001-07-08", "Raul", "raul123", null, null);
insert into cliente values (4, "4", "valentina@email.com", "2001-07-09", "Valentina", "valentina123", null, null);
insert into cliente values (5, "5", "andres@email.com", "2001-07-19", "Andres", "andres123", null, null);


insert into cliente_telefono values (1, "CASA", "100");
insert into cliente_telefono values (1, "CASA", "101");
insert into cliente_telefono values (1, "TRABAJO", "102");


insert into cliente_telefono values (2, "CASA", "200");
insert into cliente_telefono values (2, "CASA", "201");
insert into cliente_telefono values (2, "TRABAJO", "202");


insert into cliente_telefono values (3, "CASA", "300");
insert into cliente_telefono values (3, "CASA", "301");
insert into cliente_telefono values (3, "TRABAJO", "302");


insert into cliente_telefono values (4, "CASA", "400");
insert into cliente_telefono values (4, "CASA", "401");
insert into cliente_telefono values (4, "TRABAJO", "402");


insert into cliente_telefono values (5, "CASA", "500");
insert into cliente_telefono values (5, "CASA", "501");
insert into cliente_telefono values (5, "TRABAJO", "502");


insert into ciudad values (1, "Quindio", "Armenia");
insert into ciudad values (2, "Antioquia", "Medellin");
insert into ciudad values (3, "Valle del cauca", "Cali");
insert into ciudad values (4, "Meta", "Villavicencio");
insert into ciudad values (5, "Cundinamarca", "Bogota");


insert into pelicula values (1, "Preventa", "Avatar", null, "Entramos en el mundo Avatar de la mano de Jake Sully, un ex-Marine en silla de ruedas, que ha sido reclutado para viajar a Pandora, donde existe un mineral raro y muy preciado que puede solucionar la crisis energética existente en la Tierra.", null);
insert into pelicula values (2, "Cartelera", "Rapidos y furiosos", null, "Cada noche, Los Ángeles es testigo de alguna carrera de coches. Últimamente ha aparecido un nuevo corredor, todos saben que es duro y que es rápido, pero lo que no saben es que es un detective con la determinación de salir victorioso.", null);
insert into pelicula values (3, "Cartelera", "Coco", null, "Miguel es un niño que sueña con ser músico, pero su familia se lo prohíbe porque su tatarabuelo, músico, los abandonó, y quieren obligar a Miguel a ser zapatero, como todos los miembros de la familia. Por accidente, Miguel entra en la Tierra de los Muertos, de donde sólo podrá salir si un familiar difunto le concede su bendición, pero su tatarabuela se niega a dejarlo volver con los vivos si no promete que no será músico.", null);
insert into pelicula values (4, "Preventa", "La monja", null, "Una monja se suicida en una abadía rumana y el Vaticano envía a un sacerdote y una novicia a investigar lo sucedido. Lo que ambos encuentran allí es un secreto perverso que los enfrentará cara a cara con el mal en su esencia más pura.", null);
insert into pelicula values (5, "Cartelera", "Thor", null, "Tras desatar una antigua guerra, el codicioso guerrero Thor es desterrado a la Tierra por su padre para que viva entre los hombres y descubra así el verdadero sentido de la humildad. Allí, sin sus poderes, Thor deberá enfrentarse a las fuerzas más oscuras que su mayor enemigo le enviará desde Asgard.", null);


insert into pelicula_genero values (1, "CIENCIA_FICCION");
insert into pelicula_genero values (1, "FANTASIA");
insert into pelicula_genero values (2, "ACCION");
insert into pelicula_genero values (3, "ANIMACION");
insert into pelicula_genero values (4, "TERROR");
insert into pelicula_genero values (5, "CIENCIA_FICCION");
insert into pelicula_genero values (5, "ACCION");

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


insert into compra values (1, "2022-10-01 10:00:00", "Tarjeta_Credito", 1);
insert into compra values (2, "2022-10-02 10:00:00", "PSE", 1);

insert into compra values (3, "2022-10-03 10:00:00", "Tarjeta_Credito", 2);
insert into compra values (4, "2022-10-04 10:00:00", "PSE", 2);

insert into compra values (5, "2022-10-05 10:00:00", "Tarjeta_Debito", 3);
insert into compra values (6, "2022-10-06 10:00:00", "Tarjeta_Debito", 3);

insert into compra values (7, "2022-10-07 10:00:00", "Tarjeta_Credito", 4);
insert into compra values (8, "2022-10-08 10:00:00", "Tarjeta_Debito", 4);

insert into compra values (9, "2022-10-09 10:00:00", "PSE", 5);
insert into compra values (10, "2022-10-10 10:00:00", "Tarjeta_Credito", 5);

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


insert into silla values (1, "A1", 1);
insert into silla values (2, "A2", 1);
insert into silla values (3, "A3", 1);
insert into silla values (4, "A4", 1);
insert into silla values (5, "A5", 1);
insert into silla values (6, "A6", 1);
insert into silla values (7, "A7", 1);
insert into silla values (8, "A8", 1);

insert into silla values (9, "B1", 1);
insert into silla values (10, "B2", 1);
insert into silla values (11, "B3", 1);
insert into silla values (12, "B4", 1);
insert into silla values (13, "B5", 1);
insert into silla values (14, "B6", 1);
insert into silla values (15, "B7", 1);
insert into silla values (16, "B8", 1);

insert into silla values (17, "C1", 1);
insert into silla values (18, "C2", 1);
insert into silla values (19, "C3", 1);
insert into silla values (20, "C4", 1);
insert into silla values (21, "C5", 1);
insert into silla values (22, "C6", 1);
insert into silla values (23, "C7", 1);
insert into silla values (24, "C8", 1);

insert into silla values (25, "D1", 1);
insert into silla values (26, "D2", 1);
insert into silla values (27, "D3", 1);
insert into silla values (28, "D4", 1);
insert into silla values (29, "D5", 1);
insert into silla values (30, "D6", 1);
insert into silla values (31, "D7", 1);
insert into silla values (32, "D8", 1);

insert into silla values (33, "E1", 1);
insert into silla values (34, "E2", 1);
insert into silla values (35, "E3", 1);
insert into silla values (36, "E4", 1);
insert into silla values (37, "E5", 1);
insert into silla values (38, "E6", 1);
insert into silla values (39, "E7", 1);
insert into silla values (40, "E8", 1);

insert into silla values (41, "F1", 1);
insert into silla values (42, "F2", 1);
insert into silla values (43, "F3", 1);
insert into silla values (44, "F4", 1);
insert into silla values (45, "F5", 1);
insert into silla values (46, "F6", 1);
insert into silla values (47, "F7", 1);
insert into silla values (48, "F8", 1);

insert into silla values (49, "G1", 1);
insert into silla values (50, "G2", 1);
insert into silla values (51, "G3", 1);
insert into silla values (52, "G4", 1);
insert into silla values (53, "G5", 1);
insert into silla values (54, "G6", 1);
insert into silla values (55, "G7", 1);
insert into silla values (56, "G8", 1);

insert into silla values (57, "H1", 1);
insert into silla values (58, "H2", 1);
insert into silla values (59, "H3", 1);
insert into silla values (60, "H4", 1);
insert into silla values (61, "H5", 1);
insert into silla values (62, "H6", 1);
insert into silla values (63, "H7", 1);
insert into silla values (64, "H8", 1);

insert into silla values (65, "A1", 2);
insert into silla values (66, "A2", 2);
insert into silla values (67, "A3", 2);
insert into silla values (68, "A4", 2);
insert into silla values (69, "A5", 2);
insert into silla values (70, "A6", 2);
insert into silla values (71, "A7", 2);
insert into silla values (72, "A8", 2);

insert into silla values (73, "B1", 2);
insert into silla values (74, "B2", 2);
insert into silla values (75, "B3", 2);
insert into silla values (76, "B4", 2);
insert into silla values (77, "B5", 2);
insert into silla values (78, "B6", 2);
insert into silla values (79, "B7", 2);
insert into silla values (80, "B8", 2);

insert into silla values (81, "C1", 2);
insert into silla values (82, "C2", 2);
insert into silla values (83, "C3", 2);
insert into silla values (84, "C4", 2);
insert into silla values (85, "C5", 2);
insert into silla values (86, "C6", 2);
insert into silla values (87, "C7", 2);
insert into silla values (88, "C8", 2);

insert into silla values (89, "D1", 2);
insert into silla values (90, "D2", 2);
insert into silla values (91, "D3", 2);
insert into silla values (92, "D4", 2);
insert into silla values (93, "D5", 2);
insert into silla values (94, "D6", 2);
insert into silla values (95, "D7", 2);
insert into silla values (96, "D8", 2);

insert into silla values (97, "E1", 2);
insert into silla values (98, "E2", 2);
insert into silla values (99, "E3", 2);
insert into silla values (100, "E4", 2);
insert into silla values (101, "E5", 2);
insert into silla values (102, "E6", 2);
insert into silla values (103, "E7", 2);
insert into silla values (104, "E8", 2);

insert into silla values (105, "F1", 2);
insert into silla values (106, "F2", 2);
insert into silla values (107, "F3", 2);
insert into silla values (108, "F4", 2);
insert into silla values (109, "F5", 2);
insert into silla values (110, "F6", 2);
insert into silla values (111, "F7", 2);
insert into silla values (112, "F8", 2);

insert into silla values (113, "G1", 2);
insert into silla values (114, "G2", 2);
insert into silla values (115, "G3", 2);
insert into silla values (116, "G4", 2);
insert into silla values (117, "G5", 2);
insert into silla values (118, "G6", 2);
insert into silla values (119, "G7", 2);
insert into silla values (120, "G8", 2);

insert into silla values (121, "H1", 2);
insert into silla values (122, "H2", 2);
insert into silla values (123, "H3", 2);
insert into silla values (124, "H4", 2);
insert into silla values (125, "H5", 2);
insert into silla values (126, "H6", 2);
insert into silla values (127, "H7", 2);
insert into silla values (128, "H8", 2);

insert into silla values (129, "A1", 3);
insert into silla values (130, "A2", 3);
insert into silla values (131, "A3", 3);
insert into silla values (132, "A4", 3);
insert into silla values (133, "A5", 3);
insert into silla values (134, "A6", 3);
insert into silla values (135, "A7", 3);
insert into silla values (136, "A8", 3);

insert into silla values (137, "B1", 3);
insert into silla values (138, "B2", 3);
insert into silla values (139, "B3", 3);
insert into silla values (140, "B4", 3);
insert into silla values (141, "B5", 3);
insert into silla values (142, "B6", 3);
insert into silla values (143, "B7", 3);
insert into silla values (144, "B8", 3);

insert into silla values (145, "C1", 3);
insert into silla values (146, "C2", 3);
insert into silla values (147, "C3", 3);
insert into silla values (148, "C4", 3);
insert into silla values (149, "C5", 3);
insert into silla values (150, "C6", 3);
insert into silla values (151, "C7", 3);
insert into silla values (152, "C8", 3);

insert into silla values (153, "D1", 3);
insert into silla values (154, "D2", 3);
insert into silla values (155, "D3", 3);
insert into silla values (156, "D4", 3);
insert into silla values (157, "D5", 3);
insert into silla values (158, "D6", 3);
insert into silla values (159, "D7", 3);
insert into silla values (160, "D8", 3);

insert into silla values (161, "E1", 3);
insert into silla values (162, "E2", 3);
insert into silla values (163, "E3", 3);
insert into silla values (164, "E4", 3);
insert into silla values (165, "E5", 3);
insert into silla values (166, "E6", 3);
insert into silla values (167, "E7", 3);
insert into silla values (168, "E8", 3);

insert into silla values (169, "F1", 3);
insert into silla values (170, "F2", 3);
insert into silla values (171, "F3", 3);
insert into silla values (172, "F4", 3);
insert into silla values (173, "F5", 3);
insert into silla values (174, "F6", 3);
insert into silla values (175, "F7", 3);
insert into silla values (176, "F8", 3);

insert into silla values (177, "G1", 3);
insert into silla values (178, "G2", 3);
insert into silla values (179, "G3", 3);
insert into silla values (180, "G4", 3);
insert into silla values (181, "G5", 3);
insert into silla values (182, "G6", 3);
insert into silla values (183, "G7", 3);
insert into silla values (184, "G8", 3);

insert into silla values (185, "H1", 3);
insert into silla values (186, "H2", 3);
insert into silla values (187, "H3", 3);
insert into silla values (188, "H4", 3);
insert into silla values (189, "H5", 3);
insert into silla values (190, "H6", 3);
insert into silla values (191, "H7", 3);
insert into silla values (192, "H8", 3);

insert into silla values (193, "A1", 4);
insert into silla values (194, "A2", 4);
insert into silla values (195, "A3", 4);
insert into silla values (196, "A4", 4);
insert into silla values (197, "A5", 4);
insert into silla values (198, "A6", 4);
insert into silla values (199, "A7", 4);
insert into silla values (200, "A8", 4);

insert into silla values (201, "B1", 4);
insert into silla values (202, "B2", 4);
insert into silla values (203, "B3", 4);
insert into silla values (204, "B4", 4);
insert into silla values (205, "B5", 4);
insert into silla values (206, "B6", 4);
insert into silla values (207, "B7", 4);
insert into silla values (208, "B8", 4);

insert into silla values (209, "C1", 4);
insert into silla values (210, "C2", 4);
insert into silla values (211, "C3", 4);
insert into silla values (212, "C4", 4);
insert into silla values (213, "C5", 4);
insert into silla values (214, "C6", 4);
insert into silla values (215, "C7", 4);
insert into silla values (216, "C8", 4);

insert into silla values (217, "D1", 4);
insert into silla values (218, "D2", 4);
insert into silla values (219, "D3", 4);
insert into silla values (220, "D4", 4);
insert into silla values (221, "D5", 4);
insert into silla values (222, "D6", 4);
insert into silla values (223, "D7", 4);
insert into silla values (224, "D8", 4);

insert into silla values (225, "E1", 4);
insert into silla values (226, "E2", 4);
insert into silla values (227, "E3", 4);
insert into silla values (228, "E4", 4);
insert into silla values (229, "E5", 4);
insert into silla values (230, "E6", 4);
insert into silla values (231, "E7", 4);
insert into silla values (232, "E8", 4);

insert into silla values (233, "F1", 4);
insert into silla values (234, "F2", 4);
insert into silla values (235, "F3", 4);
insert into silla values (236, "F4", 4);
insert into silla values (237, "F5", 4);
insert into silla values (238, "F6", 4);
insert into silla values (239, "F7", 4);
insert into silla values (240, "F8", 4);

insert into silla values (241, "G1", 4);
insert into silla values (242, "G2", 4);
insert into silla values (243, "G3", 4);
insert into silla values (244, "G4", 4);
insert into silla values (245, "G5", 4);
insert into silla values (246, "G6", 4);
insert into silla values (247, "G7", 4);
insert into silla values (248, "G8", 4);

insert into silla values (249, "H1", 4);
insert into silla values (250, "H2", 4);
insert into silla values (251, "H3", 4);
insert into silla values (252, "H4", 4);
insert into silla values (253, "H5", 4);
insert into silla values (254, "H6", 4);
insert into silla values (255, "H7", 4);
insert into silla values (256, "H8", 4);


insert into entrada values (1, 1, 1, 1);
insert into entrada values (2, 2, 1, 2);
insert into entrada values (3, 3, 2, 3);
insert into entrada values (4, 4, 3, 4);
insert into entrada values (5, 5, 4, 5);

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
--Silla
--Entrada