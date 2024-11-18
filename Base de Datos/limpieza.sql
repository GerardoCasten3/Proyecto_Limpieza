/*
 Navicat Premium Dump SQL

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 100428 (10.4.28-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : limpieza

 Target Server Type    : MySQL
 Target Server Version : 100428 (10.4.28-MariaDB)
 File Encoding         : 65001

 Date: 18/11/2024 01:46:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actividades_colonias
-- ----------------------------
DROP TABLE IF EXISTS `actividades_colonias`;
CREATE TABLE `actividades_colonias`  (
  `id_actividad` int NOT NULL,
  `id_colonia` int NOT NULL,
  PRIMARY KEY (`id_actividad`, `id_colonia`) USING BTREE,
  INDEX `id_colonia`(`id_colonia` ASC) USING BTREE,
  CONSTRAINT `actividades_colonias_ibfk_1` FOREIGN KEY (`id_actividad`) REFERENCES `actividades_limpieza` (`id_actividad`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `actividades_colonias_ibfk_2` FOREIGN KEY (`id_colonia`) REFERENCES `colonias` (`id_colonia`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of actividades_colonias
-- ----------------------------
INSERT INTO `actividades_colonias` VALUES (1, 3);
INSERT INTO `actividades_colonias` VALUES (1, 6);
INSERT INTO `actividades_colonias` VALUES (1, 52);
INSERT INTO `actividades_colonias` VALUES (2, 52);
INSERT INTO `actividades_colonias` VALUES (2, 89);

-- ----------------------------
-- Table structure for actividades_limpieza
-- ----------------------------
DROP TABLE IF EXISTS `actividades_limpieza`;
CREATE TABLE `actividades_limpieza`  (
  `id_actividad` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` date NOT NULL,
  `retroalimentacion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `imagenEvidencia` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_cuadrilla` int NOT NULL,
  `completado` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id_actividad`) USING BTREE,
  INDEX `id_cuadrilla`(`id_cuadrilla` ASC) USING BTREE,
  CONSTRAINT `actividades_limpieza_ibfk_1` FOREIGN KEY (`id_cuadrilla`) REFERENCES `cuadrillas` (`id_cuadrilla`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of actividades_limpieza
-- ----------------------------
INSERT INTO `actividades_limpieza` VALUES (1, 'Limpieza de piso y baños para Daimler', '2024-11-01', 'Todo salio acorde a lo establecido', 'C:\\Users\\gerar\\OneDrive\\Escritorio\\Universidad\\7mo Semestre\\Diseño y Arquitectura de Software\\Proyecto_Limpieza\\App\\src\\Images\\imagen6.png', 4, 1);
INSERT INTO `actividades_limpieza` VALUES (2, 'Limpieza en area recreativa para John Deere', '2024-11-17', 'Se completó la actividad con éxito', 'C:\\Users\\gerar\\OneDrive\\Escritorio\\Universidad\\7mo Semestre\\Diseño y Arquitectura de Software\\Proyecto_Limpieza\\App\\src\\Images\\imagen4.png', 4, 1);

-- ----------------------------
-- Table structure for colonias
-- ----------------------------
DROP TABLE IF EXISTS `colonias`;
CREATE TABLE `colonias`  (
  `id_colonia` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `codigo_postal` int NOT NULL,
  `tipo_asentamiento` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_colonia`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 764 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of colonias
-- ----------------------------
INSERT INTO `colonias` VALUES (1, 'Saltillo Centro', 25000, 'Colonia');
INSERT INTO `colonias` VALUES (2, 'Vista Hermosa', 25010, 'Colonia');
INSERT INTO `colonias` VALUES (3, 'La Fuente', 25010, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (4, 'Privada la Misión', 25010, 'Colonia');
INSERT INTO `colonias` VALUES (5, 'Privada la Campana', 25010, 'Colonia');
INSERT INTO `colonias` VALUES (6, 'Nuevo Saltillo', 25010, 'Colonia');
INSERT INTO `colonias` VALUES (7, 'Privada de San Javier', 25010, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (8, 'Solidaridad', 25010, 'Colonia');
INSERT INTO `colonias` VALUES (9, 'Parajes de la Sierra', 25010, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (10, '15 de Septiembre', 25013, 'Colonia');
INSERT INTO `colonias` VALUES (11, 'Villa Morelos', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (12, 'Milenio', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (13, 'El Monte del Sinaí', 25013, 'Colonia');
INSERT INTO `colonias` VALUES (14, 'Cordillera', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (15, 'La Cascada', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (16, 'Ampliación Morelos', 25013, 'Colonia');
INSERT INTO `colonias` VALUES (17, 'Amistad', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (18, 'Morelos Nueva Creación', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (19, 'Balcones de Morelos', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (20, 'Valle de Morelos', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (21, 'Parque Industrial Amistad', 25013, 'Zona industrial');
INSERT INTO `colonias` VALUES (22, 'Privada Morelos', 25013, 'Colonia');
INSERT INTO `colonias` VALUES (23, 'Colibrí', 25013, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (24, '10 de Abril', 25014, 'Colonia');
INSERT INTO `colonias` VALUES (25, 'San Pedro de los Pinos', 25014, 'Colonia');
INSERT INTO `colonias` VALUES (26, 'Cecilia Ocelli de Salinas', 25014, 'Colonia');
INSERT INTO `colonias` VALUES (27, 'Fundadores', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (28, 'El Pedregal', 25015, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (29, 'Fuentes del Pedregal', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (30, 'Edgar Puente', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (31, 'Nueva Vida', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (32, 'Villa de Santiago', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (33, 'Lomas del Pedregal', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (34, 'Lomas de Zapaliname', 25015, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (35, 'Valle de las Aves', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (36, 'Salomón Abedrop', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (37, 'Lomas de San Francisco', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (38, 'Nueva Independencia', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (39, 'Nuevo Progreso', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (40, 'Introductores de Ganado', 25015, 'Colonia');
INSERT INTO `colonias` VALUES (41, 'Ignacio Zaragoza', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (42, 'Residencial los Rosales', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (43, 'Colinas de Santiago', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (44, 'Popular Loma Blanca', 25016, 'Colonia');
INSERT INTO `colonias` VALUES (45, 'Sierra Alta Residencial', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (46, 'Prados de San José', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (47, 'Tres Vientos', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (48, 'Valle de los Almendros', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (49, 'Privada Villas de San José', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (50, 'Nuevo Valle de los Almendros', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (51, 'Ciudad Mirasierra', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (52, 'Lomas del Bosque', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (53, 'Puerta del Oriente', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (54, 'Privadas la Torre', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (55, 'Privada los Magueyes', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (56, 'Loma Linda', 25016, 'Colonia');
INSERT INTO `colonias` VALUES (57, 'Gaspar Valdez', 25016, 'Colonia');
INSERT INTO `colonias` VALUES (58, 'Real del Sol', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (59, 'Recreativo Sección 38', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (60, 'Francisco I Madero Rústico', 25016, 'Colonia');
INSERT INTO `colonias` VALUES (61, 'Nuevo Mirasierra', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (62, 'Privadas Sierras del Oriente', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (63, 'Sierra Blanca', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (64, 'Misión Cerritos', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (65, 'Santa Lucía', 25016, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (66, 'Ampliación Valle de Morelos', 25017, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (67, 'Morelos', 25017, 'Colonia');
INSERT INTO `colonias` VALUES (68, 'Ampliación Morelos Segundo Sector', 25017, 'Colonia');
INSERT INTO `colonias` VALUES (69, 'Conquistadores', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (70, 'Privada Nogal I', 25019, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (71, 'La Nogalera', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (72, 'El Cerrito', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (73, 'Nueva Tlaxcala', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (74, 'Rubén Jaramillo', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (75, 'Tierra y Libertad', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (76, 'La Morita', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (77, 'Nueva Imagen', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (78, 'El Ejido', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (79, 'El Nogalar', 25019, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (80, 'Nuevo Amanecer', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (81, 'Las Candelarias', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (82, 'Postal Cerritos', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (83, 'San José', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (84, 'Los Lirios', 25019, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (85, 'Candelarias Residencial', 25019, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (86, 'Santa María', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (87, 'Las Maravillas', 25019, 'Colonia');
INSERT INTO `colonias` VALUES (88, 'Villa Fundadores', 25019, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (89, 'Provivienda', 25020, 'Colonia');
INSERT INTO `colonias` VALUES (90, 'San Ramón', 25020, 'Colonia');
INSERT INTO `colonias` VALUES (91, 'Urdiñola', 25020, 'Colonia');
INSERT INTO `colonias` VALUES (92, 'Zapaliname', 25020, 'Colonia');
INSERT INTO `colonias` VALUES (93, 'Indio', 25020, 'Colonia');
INSERT INTO `colonias` VALUES (94, 'San Esteban', 25020, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (95, 'Valle de San Ramón', 25020, 'Colonia');
INSERT INTO `colonias` VALUES (96, 'Centro Metropolitano', 25022, 'Equipamiento');
INSERT INTO `colonias` VALUES (97, 'Parque las Maravillas', 25022, 'Equipamiento');
INSERT INTO `colonias` VALUES (98, 'Universidad Pueblo', 25023, 'Colonia');
INSERT INTO `colonias` VALUES (99, 'Montevista', 25023, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (100, 'Cantabria', 25023, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (101, 'Nueva Esperanza', 25023, 'Colonia');
INSERT INTO `colonias` VALUES (102, 'La Palma', 25023, 'Colonia');
INSERT INTO `colonias` VALUES (103, 'El Paraíso', 25023, 'Colonia');
INSERT INTO `colonias` VALUES (104, 'San Vicente', 25023, 'Colonia');
INSERT INTO `colonias` VALUES (105, 'Arboledas Popular', 25023, 'Colonia');
INSERT INTO `colonias` VALUES (106, 'Loma Bonita', 25023, 'Colonia');
INSERT INTO `colonias` VALUES (107, 'Valle de las Palmas', 25023, 'Colonia');
INSERT INTO `colonias` VALUES (108, 'Valle de Santa Elena', 25023, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (109, 'La Rosaleda', 25023, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (110, 'Agua Azul', 25030, 'Colonia');
INSERT INTO `colonias` VALUES (111, 'Arcos de Belén', 25030, 'Colonia');
INSERT INTO `colonias` VALUES (112, 'González Cepeda', 25030, 'Colonia');
INSERT INTO `colonias` VALUES (113, 'Loma de Santa Anita', 25030, 'Colonia');
INSERT INTO `colonias` VALUES (114, 'Magisterio Sección 38', 25034, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (115, 'Santa Anita', 25034, 'Colonia');
INSERT INTO `colonias` VALUES (116, 'Esther Santos', 25034, 'Colonia');
INSERT INTO `colonias` VALUES (117, 'Huertas de Venancio', 25036, 'Colonia');
INSERT INTO `colonias` VALUES (118, 'Condesa', 25038, 'Colonia');
INSERT INTO `colonias` VALUES (119, 'Ampliación San Ramón', 25038, 'Colonia');
INSERT INTO `colonias` VALUES (120, 'Deimos', 25039, 'Colonia');
INSERT INTO `colonias` VALUES (121, 'Ojo de Agua', 25040, 'Colonia');
INSERT INTO `colonias` VALUES (122, 'San Lorenzo', 25040, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (123, 'Barrio Santa Anita', 25040, 'Barrio');
INSERT INTO `colonias` VALUES (124, 'Viramontes', 25040, 'Colonia');
INSERT INTO `colonias` VALUES (125, 'Balcones de Bellavista', 25040, 'Colonia');
INSERT INTO `colonias` VALUES (126, 'Héroes de Chapultepec', 25043, 'Colonia');
INSERT INTO `colonias` VALUES (127, 'Zapateros', 25045, 'Colonia');
INSERT INTO `colonias` VALUES (128, 'Portal de Santiago', 25045, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (129, 'Los Álamos', 25047, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (130, 'Burócratas del Estado', 25048, 'Colonia');
INSERT INTO `colonias` VALUES (131, 'Lomas de Chapultepec', 25048, 'Colonia');
INSERT INTO `colonias` VALUES (132, 'Santa María', 25049, 'Colonia');
INSERT INTO `colonias` VALUES (133, 'Simón Bolívar', 25049, 'Colonia');
INSERT INTO `colonias` VALUES (134, 'Águila de Oro', 25049, 'Barrio');
INSERT INTO `colonias` VALUES (135, 'Benito Juárez', 25050, 'Colonia');
INSERT INTO `colonias` VALUES (136, 'María del Carmen Cabello', 25050, 'Colonia');
INSERT INTO `colonias` VALUES (137, 'Centenario', 25050, 'Colonia');
INSERT INTO `colonias` VALUES (138, 'Chapultepec', 25050, 'Colonia');
INSERT INTO `colonias` VALUES (139, 'La Madrid', 25050, 'Colonia');
INSERT INTO `colonias` VALUES (140, 'Rosa María Gutiérrez', 25050, 'Colonia');
INSERT INTO `colonias` VALUES (141, 'El Salvador', 25056, 'Colonia');
INSERT INTO `colonias` VALUES (142, 'El Volcán', 25057, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (143, 'Los Nogales', 25057, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (144, 'Jesús Cabello', 25057, 'Colonia');
INSERT INTO `colonias` VALUES (145, 'Lomas de San Javier', 25057, 'Colonia');
INSERT INTO `colonias` VALUES (146, 'Colinas de San Francisco', 25057, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (147, 'La Herradura', 25057, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (148, 'Los Nogales II', 25057, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (149, 'Parajes de Oriente', 25057, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (150, 'Bellavista', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (151, 'Francisco I Madero', 25060, 'Unidad habitacional');
INSERT INTO `colonias` VALUES (152, 'Segovia Gil', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (153, 'Lázaro Cárdenas', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (154, 'Los Arcos', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (155, 'Lucio Blanco', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (156, 'Miravalle', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (157, 'San Lorenzo Oriente', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (158, 'Luis Donaldo Colosio', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (159, 'Acueducto', 25060, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (160, 'La Central', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (161, 'Bellavista Mesa de Arizpe', 25060, 'Colonia');
INSERT INTO `colonias` VALUES (162, 'Huertas de San Lorenzo', 25065, 'Colonia');
INSERT INTO `colonias` VALUES (163, '15 de Abril', 25065, 'Colonia');
INSERT INTO `colonias` VALUES (164, 'Cerrada San Lorenzo', 25065, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (165, 'Jesús Garcia Corona', 25065, 'Colonia');
INSERT INTO `colonias` VALUES (166, 'Patria Libre', 25065, 'Colonia');
INSERT INTO `colonias` VALUES (167, 'Nueva Reforma', 25065, 'Colonia');
INSERT INTO `colonias` VALUES (168, 'Quinta Valle', 25067, 'Colonia');
INSERT INTO `colonias` VALUES (169, 'Quinta Esmeralda', 25068, 'Colonia');
INSERT INTO `colonias` VALUES (170, 'Villa Universidad', 25069, 'Colonia');
INSERT INTO `colonias` VALUES (171, 'Valle de Lourdes', 25069, 'Colonia');
INSERT INTO `colonias` VALUES (172, 'Las Haciendas', 25069, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (173, 'Landin', 25070, 'Colonia');
INSERT INTO `colonias` VALUES (174, 'Lomas de Guadalupe', 25070, 'Colonia');
INSERT INTO `colonias` VALUES (175, 'Lourdes', 25070, 'Colonia');
INSERT INTO `colonias` VALUES (176, 'Privada Obregón Sur', 25070, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (177, 'Balcones de Landin', 25070, 'Colonia');
INSERT INTO `colonias` VALUES (178, 'Lomas de Landín', 25070, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (179, 'Privada Rincón de Salazar', 25070, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (180, '26 de Marzo', 25075, 'Colonia');
INSERT INTO `colonias` VALUES (181, 'Ferrocarrilero 7 de Noviembre', 25075, 'Colonia');
INSERT INTO `colonias` VALUES (182, 'Buenos Aires', 25076, 'Colonia');
INSERT INTO `colonias` VALUES (183, 'Los Balcones de Buenavista', 25077, 'Colonia');
INSERT INTO `colonias` VALUES (184, 'Valle Alto', 25077, 'Colonia');
INSERT INTO `colonias` VALUES (185, 'Eulalio Gutiérrez Treviño', 25080, 'Colonia');
INSERT INTO `colonias` VALUES (186, 'Girasol', 25080, 'Colonia');
INSERT INTO `colonias` VALUES (187, 'Parques de la Cañada', 25080, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (188, 'Froylán Mier Narro', 25080, 'Colonia');
INSERT INTO `colonias` VALUES (189, 'Los Periodistas', 25080, 'Colonia');
INSERT INTO `colonias` VALUES (190, 'El Refugio la Soledad', 25083, 'Colonia');
INSERT INTO `colonias` VALUES (191, 'Hacienda del Refugio', 25083, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (192, 'Parque Industrial la Angostura', 25083, 'Zona industrial');
INSERT INTO `colonias` VALUES (193, 'Sierra del Sur', 25083, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (194, 'Hacienda el Mimbre', 25083, 'Equipamiento');
INSERT INTO `colonias` VALUES (195, 'Amistad Alianzas', 25083, 'Zona industrial');
INSERT INTO `colonias` VALUES (196, 'Lomas del Sur', 25084, 'Colonia');
INSERT INTO `colonias` VALUES (197, 'Valle de San Lorenzo', 25084, 'Colonia');
INSERT INTO `colonias` VALUES (198, 'La Estrella', 25084, 'Colonia');
INSERT INTO `colonias` VALUES (199, '69 Batallón de Infantería', 25084, 'Zona militar');
INSERT INTO `colonias` VALUES (200, 'Las Teresitas', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (201, 'Niños Héroes', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (202, 'Lomas del Refugio', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (203, 'Las Rosas', 25084, 'Colonia');
INSERT INTO `colonias` VALUES (204, 'Colinas de San Lorenzo', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (205, 'Parajes de Santa Elena', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (206, 'Hacienda las Isabeles', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (207, 'Villas de la Angostura', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (208, 'Ampliación la Estrella', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (209, 'Nuevo Teresitas', 25084, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (210, 'Guadalupe Victoria', 25085, 'Colonia');
INSERT INTO `colonias` VALUES (211, 'Rincón de Foret', 25085, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (212, 'Foret', 25085, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (213, 'Genaro Vázquez Rojas', 25085, 'Colonia');
INSERT INTO `colonias` VALUES (214, 'El Latifundio', 25085, 'Colonia');
INSERT INTO `colonias` VALUES (215, 'Burócratas Municipales', 25086, 'Colonia');
INSERT INTO `colonias` VALUES (216, 'Ampliación 26 de Marzo', 25086, 'Colonia');
INSERT INTO `colonias` VALUES (217, 'Privada Colombia', 25086, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (218, 'Ampliación Girasol', 25087, 'Colonia');
INSERT INTO `colonias` VALUES (219, 'Hacienda Narro', 25088, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (220, 'Villas de San Francisco', 25088, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (221, 'Viñedos el Álamo', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (222, 'Agua Nueva', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (223, 'Ricardo Flores Magón', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (224, 'Nueva Jerusalén', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (225, 'El Álamo', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (226, '23 de Noviembre', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (227, 'El Progreso', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (228, 'María del Carmen Cavazos', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (229, 'Australia', 25088, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (230, '12 de Octubre', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (231, 'La Esperanza', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (232, 'San Juanita', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (233, 'El Álamo II', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (234, 'Mario Ortiz Rodríguez', 25088, 'Colonia');
INSERT INTO `colonias` VALUES (235, 'El Álamo', 25088, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (236, 'Lomas de Lourdes', 25090, 'Colonia');
INSERT INTO `colonias` VALUES (237, 'Valle Dorado', 25090, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (238, 'Lomas de Santa Cruz', 25092, 'Colonia');
INSERT INTO `colonias` VALUES (239, 'Humberto Dávila Esquivel', 25092, 'Unidad habitacional');
INSERT INTO `colonias` VALUES (240, 'Villas de San Lorenzo', 25092, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (241, 'Las Huertas de Lourdes', 25092, 'Colonia');
INSERT INTO `colonias` VALUES (242, 'Santa Mónica', 25093, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (243, 'Los Buitres', 25093, 'Colonia');
INSERT INTO `colonias` VALUES (244, 'Colinas del Sur', 25093, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (245, '10 de Mayo', 25093, 'Colonia');
INSERT INTO `colonias` VALUES (246, 'Hacienda el Cortijo', 25093, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (247, 'Mesa de Lourdes', 25093, 'Colonia');
INSERT INTO `colonias` VALUES (248, 'Portal del Sur', 25093, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (249, 'Ampliación Colinas del Sur', 25093, 'Colonia');
INSERT INTO `colonias` VALUES (250, 'Los Buitres II', 25093, 'Colonia');
INSERT INTO `colonias` VALUES (251, 'Monteverde Residencial', 25094, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (252, 'Paseo de la Estrella', 25094, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (253, 'Privadas la Estrella', 25094, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (254, 'Bosques de las Lomas Residencial', 25094, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (255, 'Cumbres Vista Residencial', 25094, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (256, 'Portal de las Lomas', 25094, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (257, 'Miguel Hidalgo', 25096, 'Colonia');
INSERT INTO `colonias` VALUES (258, 'Vistas de Peña', 25096, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (259, 'Vistas de Peña Sur', 25096, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (260, 'María de León', 25096, 'Colonia');
INSERT INTO `colonias` VALUES (261, 'Federico Berrueto Ramón Popular', 25096, 'Colonia');
INSERT INTO `colonias` VALUES (262, 'Federico Berrueto Ramón', 25096, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (263, 'Lomas Verdes', 25096, 'Colonia');
INSERT INTO `colonias` VALUES (264, 'Vicente Guerrero', 25097, 'Colonia');
INSERT INTO `colonias` VALUES (265, 'Las Rosas', 25097, 'Colonia');
INSERT INTO `colonias` VALUES (266, 'Nazario S Ortiz Garza', 25100, 'Colonia');
INSERT INTO `colonias` VALUES (267, 'Industrial Valle de Saltillo', 25100, 'Colonia');
INSERT INTO `colonias` VALUES (268, 'Hacienda San Rafael', 25100, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (269, 'Omega', 25100, 'Colonia');
INSERT INTO `colonias` VALUES (270, 'La Purísima', 25100, 'Colonia');
INSERT INTO `colonias` VALUES (271, 'Asturias', 25107, 'Colonia');
INSERT INTO `colonias` VALUES (272, 'Portal de Asturias', 25107, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (273, 'Rincón de Asturias', 25107, 'Colonia');
INSERT INTO `colonias` VALUES (274, 'Valle Verde Sector II', 25107, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (275, 'Nuevo México', 25107, 'Colonia');
INSERT INTO `colonias` VALUES (276, 'Ciudad las Torres', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (277, 'Las Torres', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (278, 'Nuevo Atardecer', 25110, 'Colonia');
INSERT INTO `colonias` VALUES (279, 'Portales', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (280, 'Evaristo Pérez Arreola', 25110, 'Colonia');
INSERT INTO `colonias` VALUES (281, 'Valle de las Torres', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (282, 'Flora Ortega', 25110, 'Colonia');
INSERT INTO `colonias` VALUES (283, 'El Rodeo', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (284, 'Valle Azteca', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (285, 'La Florencia', 25110, 'Colonia');
INSERT INTO `colonias` VALUES (286, 'Valle de las Torres II', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (287, 'Balcones de las Torres', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (288, 'Valle Satélite', 25110, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (289, 'Satélite Sur', 25113, 'Colonia');
INSERT INTO `colonias` VALUES (290, 'Parque Industrial las Torres', 25114, 'Zona industrial');
INSERT INTO `colonias` VALUES (291, 'Satélite Norte', 25115, 'Colonia');
INSERT INTO `colonias` VALUES (292, 'Santorini', 25115, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (293, 'Saltillo 2000', 25115, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (294, 'Portal de los Agaves', 25115, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (295, 'Portal del Quijote', 25115, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (296, 'San José de Flores', 25115, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (297, 'Portal del Pedregal', 25115, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (298, 'Valencia', 25116, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (299, 'Andalucía', 25116, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (300, 'San Isidro', 25116, 'Colonia');
INSERT INTO `colonias` VALUES (301, 'Ankara Residencial', 25117, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (302, 'Triana', 25117, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (303, 'Privada Lantana', 25117, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (304, 'Privada Luxor', 25117, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (305, 'Villas Castellana', 25117, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (306, 'Real Ankara', 25117, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (307, 'El Rocal Residencial', 25117, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (308, 'Santa Fe', 25117, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (309, 'Francisco I Madero', 25120, 'Colonia');
INSERT INTO `colonias` VALUES (310, 'Pedregal de los Santos Sur', 25123, 'Colonia');
INSERT INTO `colonias` VALUES (311, 'Ejido Padres Santos', 25123, 'Colonia');
INSERT INTO `colonias` VALUES (312, 'La Magueyada', 25123, 'Colonia');
INSERT INTO `colonias` VALUES (313, 'Ejido la Vega', 25123, 'Colonia');
INSERT INTO `colonias` VALUES (314, 'Las Cumbres', 25124, 'Colonia');
INSERT INTO `colonias` VALUES (315, 'Rancho Flores', 25124, 'Colonia');
INSERT INTO `colonias` VALUES (316, 'Loma Dorada', 25124, 'Colonia');
INSERT INTO `colonias` VALUES (317, 'Ocho de Enero', 25124, 'Colonia');
INSERT INTO `colonias` VALUES (318, 'Ignacio Allende', 25124, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (319, 'Residencial Rincón de San Vicente', 25124, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (320, 'Roma', 25125, 'Colonia');
INSERT INTO `colonias` VALUES (321, 'Adolfo López Mateos', 25125, 'Colonia');
INSERT INTO `colonias` VALUES (322, 'Josefa Ortiz de Domínguez', 25128, 'Colonia');
INSERT INTO `colonias` VALUES (323, 'Puerto de Flores', 25128, 'Colonia');
INSERT INTO `colonias` VALUES (324, '1° de Mayo', 25128, 'Colonia');
INSERT INTO `colonias` VALUES (325, 'Anáhuac', 25130, 'Colonia');
INSERT INTO `colonias` VALUES (326, 'Antonio Cárdenas', 25130, 'Colonia');
INSERT INTO `colonias` VALUES (327, 'Gustavo Espinosa Mireles', 25130, 'Colonia');
INSERT INTO `colonias` VALUES (328, 'Isabel Amalia Dávila', 25130, 'Colonia');
INSERT INTO `colonias` VALUES (329, 'Pueblo Insurgentes', 25137, 'Colonia');
INSERT INTO `colonias` VALUES (330, 'Paraíso', 25137, 'Colonia');
INSERT INTO `colonias` VALUES (331, 'Hacienda la Magueyada', 25137, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (332, 'González Norte', 25138, 'Colonia');
INSERT INTO `colonias` VALUES (333, 'Altaria Residencial', 25138, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (334, 'Emilio Carranza', 25138, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (335, 'Valle Universidad', 25138, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (336, 'Privada Guadalupe', 25138, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (337, 'Cerrada Guadalupe', 25138, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (338, 'Cerro del Pueblo', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (339, 'Ejército Constitucionalista', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (340, 'Independencia', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (341, 'Panteones', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (342, 'Hacienda San Pablo', 25140, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (343, 'Las Mitras', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (344, 'Sierras del Poniente', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (345, 'Azteca', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (346, 'Valle de San Antonio', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (347, 'Campo Verde', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (348, 'Obrera', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (349, 'María Luisa', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (350, 'Antonio Cárdenas Sur', 25140, 'Colonia');
INSERT INTO `colonias` VALUES (351, 'Oscar Flores Tapia', 25146, 'Colonia');
INSERT INTO `colonias` VALUES (352, 'Loma Alta', 25147, 'Colonia');
INSERT INTO `colonias` VALUES (353, 'Alfredo V Bonfil', 25150, 'Colonia');
INSERT INTO `colonias` VALUES (354, 'Mirador', 25150, 'Colonia');
INSERT INTO `colonias` VALUES (355, 'Universo', 25150, 'Colonia');
INSERT INTO `colonias` VALUES (356, 'Valle de las Flores Popular', 25150, 'Colonia');
INSERT INTO `colonias` VALUES (357, 'Ejido la Minita', 25154, 'Colonia');
INSERT INTO `colonias` VALUES (358, 'Los Balcones', 25155, 'Colonia');
INSERT INTO `colonias` VALUES (359, 'Puerto de la Virgen', 25155, 'Colonia');
INSERT INTO `colonias` VALUES (360, 'Rincón de Guadalupe', 25155, 'Colonia');
INSERT INTO `colonias` VALUES (361, 'Valle del Poniente', 25155, 'Colonia');
INSERT INTO `colonias` VALUES (362, 'Las Margaritas', 25155, 'Colonia');
INSERT INTO `colonias` VALUES (363, 'Francisco Villa', 25156, 'Colonia');
INSERT INTO `colonias` VALUES (364, 'Los Fresnos', 25157, 'Colonia');
INSERT INTO `colonias` VALUES (365, 'Valle Escondido', 25157, 'Colonia');
INSERT INTO `colonias` VALUES (366, 'Valle Escondido Sur', 25157, 'Colonia');
INSERT INTO `colonias` VALUES (367, 'Venustiano Carranza', 25157, 'Colonia');
INSERT INTO `colonias` VALUES (368, 'Alameda', 25160, 'Colonia');
INSERT INTO `colonias` VALUES (369, 'Del Valle', 25160, 'Colonia');
INSERT INTO `colonias` VALUES (370, 'Zamora', 25160, 'Colonia');
INSERT INTO `colonias` VALUES (371, 'Bordo Ferrocarril', 25160, 'Colonia');
INSERT INTO `colonias` VALUES (372, 'Huerta los Pilares', 25160, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (373, 'Privada Quinta Narro', 25160, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (374, 'Guayulera Tierra y Esperanza', 25167, 'Colonia');
INSERT INTO `colonias` VALUES (375, 'Ampliación Pacheco', 25167, 'Colonia');
INSERT INTO `colonias` VALUES (376, 'Providencia', 25167, 'Colonia');
INSERT INTO `colonias` VALUES (377, 'Privada Coahuila y Zacatecas', 25167, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (378, 'Privada Beta Centauro', 25168, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (379, 'Brisas del Valle', 25169, 'Colonia');
INSERT INTO `colonias` VALUES (380, 'Unidad Modelo', 25169, 'Colonia');
INSERT INTO `colonias` VALUES (381, 'El Bosque', 25170, 'Colonia');
INSERT INTO `colonias` VALUES (382, 'La Minita', 25170, 'Colonia');
INSERT INTO `colonias` VALUES (383, 'La Peñita', 25170, 'Colonia');
INSERT INTO `colonias` VALUES (384, 'Los Cuernitos', 25179, 'Colonia');
INSERT INTO `colonias` VALUES (385, 'Chamizal', 25180, 'Colonia');
INSERT INTO `colonias` VALUES (386, 'Guayulera', 25180, 'Colonia');
INSERT INTO `colonias` VALUES (387, 'Ruiz Cortines', 25180, 'Colonia');
INSERT INTO `colonias` VALUES (388, 'San Miguel', 25186, 'Colonia');
INSERT INTO `colonias` VALUES (389, 'El Edén', 25186, 'Colonia');
INSERT INTO `colonias` VALUES (390, 'Río Verde', 25188, 'Colonia');
INSERT INTO `colonias` VALUES (391, '5 de Mayo', 25190, 'Colonia');
INSERT INTO `colonias` VALUES (392, 'El Tanquecito', 25190, 'Colonia');
INSERT INTO `colonias` VALUES (393, 'Providencia', 25190, 'Colonia');
INSERT INTO `colonias` VALUES (394, 'Rincón de los Pastores', 25193, 'Colonia');
INSERT INTO `colonias` VALUES (395, 'Héroes de Nacozari', 25193, 'Colonia');
INSERT INTO `colonias` VALUES (396, 'Ignacio Zaragoza Popular', 25194, 'Colonia');
INSERT INTO `colonias` VALUES (397, 'Valle Verde', 25194, 'Colonia');
INSERT INTO `colonias` VALUES (398, 'Julieta Pérez', 25194, 'Colonia');
INSERT INTO `colonias` VALUES (399, 'Diana Laura Riojas de Colosio', 25194, 'Colonia');
INSERT INTO `colonias` VALUES (400, 'Los Berros', 25194, 'Colonia');
INSERT INTO `colonias` VALUES (401, 'Patria Nueva', 25195, 'Colonia');
INSERT INTO `colonias` VALUES (402, 'Santa Teresa', 25196, 'Colonia');
INSERT INTO `colonias` VALUES (403, 'Ladrilleros', 25197, 'Colonia');
INSERT INTO `colonias` VALUES (404, 'Los Rosarios Popular', 25197, 'Colonia');
INSERT INTO `colonias` VALUES (405, 'La Esmeralda', 25197, 'Colonia');
INSERT INTO `colonias` VALUES (406, 'La Joyita', 25197, 'Colonia');
INSERT INTO `colonias` VALUES (407, 'El Morillo', 25197, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (408, 'La Romita', 25197, 'Colonia');
INSERT INTO `colonias` VALUES (409, 'Los Pinos', 25198, 'Colonia');
INSERT INTO `colonias` VALUES (410, 'San Isidro', 25199, 'Colonia');
INSERT INTO `colonias` VALUES (411, 'Las Huertas', 25200, 'Colonia');
INSERT INTO `colonias` VALUES (412, 'Los Rodríguez', 25200, 'Colonia');
INSERT INTO `colonias` VALUES (413, 'Arboledas Residencial', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (414, 'Los Zendejos', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (415, 'La Rioja Terrán', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (416, 'La Rioja', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (417, 'Villanatura', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (418, 'Villas de Sayavedra', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (419, 'Jardines de Versalles', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (420, 'Las Cabañas', 25200, 'Colonia');
INSERT INTO `colonias` VALUES (421, 'Villas del Ranchito', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (422, 'Rincón de Sayavedra', 25200, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (423, 'Las Magnolias', 25203, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (424, 'Jacarandas Jardín', 25203, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (425, 'Nuestra Señora de Fátima', 25203, 'Colonia');
INSERT INTO `colonias` VALUES (426, 'Habita', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (427, 'Los González', 25204, 'Colonia');
INSERT INTO `colonias` VALUES (428, 'San Alberto', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (429, 'Residencial San Patricio', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (430, 'El Portal', 25204, 'Colonia');
INSERT INTO `colonias` VALUES (431, 'Privada Emilio Rodríguez', 25204, 'Colonia');
INSERT INTO `colonias` VALUES (432, 'La Cantera Residencial', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (433, 'Habita II', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (434, 'La Joya', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (435, 'Albareda Residencial', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (436, 'Saqqara', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (437, 'Los Pinos', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (438, 'Valle Real', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (439, 'Villa Toscana', 25204, 'Colonia');
INSERT INTO `colonias` VALUES (440, 'Villas de San Miguel', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (441, 'Los Siller', 25204, 'Colonia');
INSERT INTO `colonias` VALUES (442, 'San Patricio Plus', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (443, 'San José Residencial', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (444, 'Hacienda San Jerónimo', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (445, 'Villas de Aranjuez', 25204, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (446, 'Jardines Coloniales', 25206, 'Colonia');
INSERT INTO `colonias` VALUES (447, 'Parque Industrial Ventura', 25206, 'Zona industrial');
INSERT INTO `colonias` VALUES (448, 'Las Quintas', 25206, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (449, 'Privada Coloniales', 25206, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (450, 'Los Algodones', 25207, 'Colonia');
INSERT INTO `colonias` VALUES (451, 'Country Club Residencial', 25207, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (452, 'Puerta del Sol', 25207, 'Colonia');
INSERT INTO `colonias` VALUES (453, 'El Suspiro', 25207, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (454, 'Valle Hermoso', 25207, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (455, 'Los Cedros Residencial', 25207, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (456, 'Albatros Residencial', 25207, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (457, 'Jardines del Campestre Residencial', 25208, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (458, 'Loma Blanca', 25208, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (459, 'Los Bosques', 25208, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (460, 'Vivennto Residencial', 25208, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (461, 'Nogalar del Campestre', 25208, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (462, 'Campestre Capellanía', 25208, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (463, 'Los Valdez', 25209, 'Colonia');
INSERT INTO `colonias` VALUES (464, 'Villa San Juan', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (465, 'Rincón de los Adobes', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (466, 'Rincón de Alcántara', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (467, 'Sorrento', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (468, 'Lomas de Peña', 25209, 'Colonia');
INSERT INTO `colonias` VALUES (469, 'San Juan Bautista', 25209, 'Colonia');
INSERT INTO `colonias` VALUES (470, 'Torrealta Residencial', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (471, 'Rincón de los Encinos', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (472, 'Punta Bosque', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (473, 'La Poza', 25209, 'Colonia');
INSERT INTO `colonias` VALUES (474, 'Peña Alta', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (475, 'Seterra Residencial', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (476, 'Campestre la Poza', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (477, 'El Campanario', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (478, 'Las Misiones', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (479, 'Quinta Real', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (480, 'Los Arrayanes', 25209, 'Colonia');
INSERT INTO `colonias` VALUES (481, 'Santa Rosa Residencial', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (482, 'Villa del Carmen Residencial', 25209, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (483, 'Hacienda de Peña', 25210, 'Colonia');
INSERT INTO `colonias` VALUES (484, 'Las Brisas', 25210, 'Colonia');
INSERT INTO `colonias` VALUES (485, 'Los Álamos', 25210, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (486, 'Nueva España', 25210, 'Colonia');
INSERT INTO `colonias` VALUES (487, 'Rancho de Peña', 25210, 'Colonia');
INSERT INTO `colonias` VALUES (488, 'Rivera del Valle', 25210, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (489, 'La Noria', 25210, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (490, 'Villa Vergel Residencial', 25210, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (491, 'Privadas de Santiago', 25210, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (492, 'Valle las Palmas', 25210, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (493, 'Oasis', 25210, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (494, 'Valle San Agustín', 25215, 'Colonia');
INSERT INTO `colonias` VALUES (495, 'Río Bravo', 25220, 'Unidad habitacional');
INSERT INTO `colonias` VALUES (496, 'Virreyes Obrera', 25220, 'Colonia');
INSERT INTO `colonias` VALUES (497, 'Virreyes Popular', 25220, 'Colonia');
INSERT INTO `colonias` VALUES (498, 'Residencial los Encinos', 25220, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (499, 'Zona Industrial', 25220, 'Zona industrial');
INSERT INTO `colonias` VALUES (500, 'Virreyes Colonial', 25225, 'Colonia');
INSERT INTO `colonias` VALUES (501, 'Brisas Poniente', 25225, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (502, 'Virreyes Industrial', 25225, 'Zona industrial');
INSERT INTO `colonias` VALUES (503, 'Villa Olímpica', 25230, 'Colonia');
INSERT INTO `colonias` VALUES (504, 'FOVISSSTE Virreyes', 25230, 'Unidad habitacional');
INSERT INTO `colonias` VALUES (505, 'Virreyes Residencial', 25230, 'Colonia');
INSERT INTO `colonias` VALUES (506, 'Valle de los Virreyes', 25238, 'Colonia');
INSERT INTO `colonias` VALUES (507, 'Virreyes Pensiones', 25239, 'Colonia');
INSERT INTO `colonias` VALUES (508, 'Cima de Virreyes Residencial', 25239, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (509, 'Kiosco', 25240, 'Colonia');
INSERT INTO `colonias` VALUES (510, 'Jardín', 25240, 'Colonia');
INSERT INTO `colonias` VALUES (511, 'La Salle', 25240, 'Colonia');
INSERT INTO `colonias` VALUES (512, 'Privadas Luxemburgo', 25240, 'Colonia');
INSERT INTO `colonias` VALUES (513, 'Santiago', 25240, 'Colonia');
INSERT INTO `colonias` VALUES (514, 'San Luis', 25240, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (515, 'Villas de San Fernando', 25240, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (516, 'Villa Olímpica Oriente', 25240, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (517, 'Los Doctores', 25250, 'Colonia');
INSERT INTO `colonias` VALUES (518, 'Villas de San Carlos', 25250, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (519, 'Villas de San Gabriel', 25250, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (520, 'Villas de San Isidro', 25250, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (521, 'Alpes Norte', 25253, 'Colonia');
INSERT INTO `colonias` VALUES (522, 'Lagos Continental', 25253, 'Colonia');
INSERT INTO `colonias` VALUES (523, 'Residencial los Reales', 25253, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (524, 'Centro de Investigación en Química Aplicada', 25253, 'Equipamiento');
INSERT INTO `colonias` VALUES (525, 'San Isidro', 25254, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (526, 'Real de Peña', 25256, 'Colonia');
INSERT INTO `colonias` VALUES (527, 'Insurgentes', 25260, 'Colonia');
INSERT INTO `colonias` VALUES (528, 'Jardines del Valle', 25260, 'Colonia');
INSERT INTO `colonias` VALUES (529, 'Los Maestros', 25260, 'Colonia');
INSERT INTO `colonias` VALUES (530, 'Universidad', 25260, 'Colonia');
INSERT INTO `colonias` VALUES (531, 'Privada Santa María', 25260, 'Colonia');
INSERT INTO `colonias` VALUES (532, 'República Poniente', 25265, 'Colonia');
INSERT INTO `colonias` VALUES (533, 'Cumbres', 25270, 'Colonia');
INSERT INTO `colonias` VALUES (534, 'Latinoamericana', 25270, 'Colonia');
INSERT INTO `colonias` VALUES (535, 'Alpes', 25270, 'Colonia');
INSERT INTO `colonias` VALUES (536, 'Los Ángeles', 25270, 'Colonia');
INSERT INTO `colonias` VALUES (537, 'Jardín Oriente', 25277, 'Colonia');
INSERT INTO `colonias` VALUES (538, 'Residencial los Parques', 25279, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (539, 'El Olmo', 25280, 'Colonia');
INSERT INTO `colonias` VALUES (540, 'Guanajuato', 25280, 'Colonia');
INSERT INTO `colonias` VALUES (541, 'ISSSTE', 25280, 'Unidad habitacional');
INSERT INTO `colonias` VALUES (542, 'Jardines del Lago', 25280, 'Colonia');
INSERT INTO `colonias` VALUES (543, 'República', 25280, 'Colonia');
INSERT INTO `colonias` VALUES (544, 'República Norte', 25280, 'Colonia');
INSERT INTO `colonias` VALUES (545, 'República Oriente', 25280, 'Colonia');
INSERT INTO `colonias` VALUES (546, 'Tecnológico', 25280, 'Colonia');
INSERT INTO `colonias` VALUES (547, 'Rancho las Varas', 25280, 'Colonia');
INSERT INTO `colonias` VALUES (548, 'Topo Chico', 25284, 'Colonia');
INSERT INTO `colonias` VALUES (549, 'Joyas del Boulevard', 25285, 'Colonia');
INSERT INTO `colonias` VALUES (550, 'Guanajuato Oriente', 25286, 'Colonia');
INSERT INTO `colonias` VALUES (551, 'Los Adobes', 25286, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (552, 'América', 25290, 'Colonia');
INSERT INTO `colonias` VALUES (553, 'Europa', 25290, 'Colonia');
INSERT INTO `colonias` VALUES (554, 'Oceanía', 25290, 'Colonia');
INSERT INTO `colonias` VALUES (555, 'Oceanía Boulevares', 25290, 'Colonia');
INSERT INTO `colonias` VALUES (556, 'Saltillo 400', 25290, 'Colonia');
INSERT INTO `colonias` VALUES (557, 'Valle de las Flores INFONAVIT', 25290, 'Unidad habitacional');
INSERT INTO `colonias` VALUES (558, 'Privadas de Aragón', 25290, 'Colonia');
INSERT INTO `colonias` VALUES (559, 'Portales de Aragón', 25290, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (560, 'Las Flores', 25290, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (561, 'Avícola', 25290, 'Colonia');
INSERT INTO `colonias` VALUES (562, 'Real Hibernia', 25293, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (563, 'Villa Hibernia', 25293, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (564, 'Rincón del Cielo', 25293, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (565, 'Rinconada de la Hibernia', 25293, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (566, 'Terranova', 25294, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (567, 'Terralta', 25294, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (568, 'Magisterio Sección 38', 25294, 'Unidad habitacional');
INSERT INTO `colonias` VALUES (569, 'Los Zacatones', 25294, 'Colonia');
INSERT INTO `colonias` VALUES (570, 'Parque Industrial Cerritos', 25294, 'Zona industrial');
INSERT INTO `colonias` VALUES (571, 'Visalta', 25294, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (572, 'El Sáuz', 25294, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (573, 'Santa Bárbara', 25294, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (574, 'San José de los Cerritos', 25294, 'Colonia');
INSERT INTO `colonias` VALUES (575, 'Leandro Valle', 25294, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (576, 'Los Cerritos', 25294, 'Colonia');
INSERT INTO `colonias` VALUES (577, 'Camino Real', 25294, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (578, 'Ex Hacienda los Cerritos', 25294, 'Zona industrial');
INSERT INTO `colonias` VALUES (579, 'Hacienda Real', 25294, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (580, 'Residencial el Tapanco', 25295, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (581, 'Las Praderas', 25295, 'Colonia');
INSERT INTO `colonias` VALUES (582, 'Las Margaritas', 25295, 'Colonia');
INSERT INTO `colonias` VALUES (583, 'Bonanza', 25296, 'Colonia');
INSERT INTO `colonias` VALUES (584, 'Bugambilias', 25296, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (585, 'La Florida', 25296, 'Colonia');
INSERT INTO `colonias` VALUES (586, 'Nueva Aurora', 25296, 'Colonia');
INSERT INTO `colonias` VALUES (587, 'Villas de la Aurora', 25296, 'Colonia');
INSERT INTO `colonias` VALUES (588, 'Hacienda la Aurora Residencial', 25296, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (589, 'Cruz del Aire', 25296, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (590, 'Rincón de la Florida', 25296, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (591, 'La Rosa', 25296, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (592, 'Los Geranios', 25296, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (593, 'La Hibernia', 25297, 'Colonia');
INSERT INTO `colonias` VALUES (594, 'Los Cipreses', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (595, 'Nueva Libertad', 25297, 'Colonia');
INSERT INTO `colonias` VALUES (596, 'Los Tulipanes', 25297, 'Colonia');
INSERT INTO `colonias` VALUES (597, 'Alcazar Residencial', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (598, 'Los Chabacanos', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (599, 'Gustavo Díaz Ordaz', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (600, 'La Fragua', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (601, 'Privada Tulipanes', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (602, 'Los Olivos Residencial', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (603, 'El Baluarte', 25297, 'Colonia');
INSERT INTO `colonias` VALUES (604, 'El Rosario', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (605, 'Balcones de la Aurora', 25297, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (606, 'Portareal Residencial', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (607, 'Universidad la Salle', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (608, 'La Libertad el Puente', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (609, 'La Aurora', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (610, 'Los Manantiales', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (611, 'Las Canteras', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (612, 'Terrazas Residencial', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (613, 'Villas la Joya', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (614, 'La Libertad', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (615, 'La Trinidad', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (616, 'Real de Torrecillas Residencial', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (617, 'Villa Fontana', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (618, 'Tierra Santa Residencial', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (619, 'Lenna Residencial', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (620, 'Villa Colonial', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (621, 'Plaza Armillita', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (622, 'Bosques de la Aurora', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (623, 'Jardines del Plaza', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (624, 'Cerrada del Plaza', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (625, 'La Herradura', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (626, 'Privadas Plaza', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (627, 'La Escondida', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (628, 'Faena', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (629, 'Rincón Campestre', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (630, 'Emiliano Zapata', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (631, 'San Ángel', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (632, 'Santa Cristina', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (633, 'La Palmilla', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (634, 'Rosales de la Aurora', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (635, 'La Cieneguita', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (636, 'San Luis', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (637, 'Real de Villas de la Aurora', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (638, 'El Toreo', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (639, 'Hacienda San Carlos', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (640, 'La Ciudadela', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (641, 'Los Molinos', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (642, 'Torrecillas y Ramones', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (643, 'Jardines de los Bosques', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (644, 'Residencial Plaza', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (645, 'San José Oriente', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (646, 'Conejo Ixtlero', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (647, 'Villa Bonita', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (648, 'Villas de San Sebastián', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (649, 'Rincones de la Aurora', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (650, 'Alondra', 25298, 'Colonia');
INSERT INTO `colonias` VALUES (651, 'Villas de Guadalupe', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (652, 'Villas del Camino Real', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (653, 'Puerta del Rey', 25298, 'Fraccionamiento');
INSERT INTO `colonias` VALUES (654, 'Providencia', 25300, 'Ejido');
INSERT INTO `colonias` VALUES (655, 'San José de la Joya', 25300, 'Ejido');
INSERT INTO `colonias` VALUES (656, 'Parque Industrial Santa Mónica', 25300, 'Zona industrial');
INSERT INTO `colonias` VALUES (657, 'Parque Industrial Santa Fe', 25300, 'Zona industrial');
INSERT INTO `colonias` VALUES (658, 'Chrysler de México', 25300, 'Zona industrial');
INSERT INTO `colonias` VALUES (659, 'El Clavel', 25301, 'Ranchería');
INSERT INTO `colonias` VALUES (660, 'Hedionda del Lobo', 25301, 'Ejido');
INSERT INTO `colonias` VALUES (661, 'La Noria', 25301, 'Ejido');
INSERT INTO `colonias` VALUES (662, 'El Derramadero', 25302, 'Ejido');
INSERT INTO `colonias` VALUES (663, 'Santa Teresa de los Muchachos', 25302, 'Ejido');
INSERT INTO `colonias` VALUES (664, 'El Refugio de las Cajas', 25302, 'Ejido');
INSERT INTO `colonias` VALUES (665, 'Cadereyta (La Pompa)', 25302, 'Rancho');
INSERT INTO `colonias` VALUES (666, 'El Campestre', 25302, 'Ranchería');
INSERT INTO `colonias` VALUES (667, 'Rancho Nuevo', 25303, 'Ejido');
INSERT INTO `colonias` VALUES (668, 'Chapula', 25303, 'Ejido');
INSERT INTO `colonias` VALUES (669, 'San Blas', 25303, 'Ejido');
INSERT INTO `colonias` VALUES (670, 'Santa Rita', 25303, 'Ejido');
INSERT INTO `colonias` VALUES (671, 'San Eligio (Anexo Santa Teresa)', 25303, 'Ejido');
INSERT INTO `colonias` VALUES (672, 'La Nogalera (San Alberto)', 25303, 'Colonia');
INSERT INTO `colonias` VALUES (673, 'Los Carrizales', 25303, 'Colonia');
INSERT INTO `colonias` VALUES (674, 'San Juan de la Vaquería', 25304, 'Ejido');
INSERT INTO `colonias` VALUES (675, 'Daimler Freightliner', 25304, 'Zona industrial');
INSERT INTO `colonias` VALUES (676, 'Parque Industrial Alianza Derramadero', 25304, 'Zona industrial');
INSERT INTO `colonias` VALUES (677, 'Pino Real [Fraccionamiento Campestre]', 25305, 'Rancho');
INSERT INTO `colonias` VALUES (678, 'San José de los Cerritos', 25305, 'Exhacienda');
INSERT INTO `colonias` VALUES (679, 'Cuauhtémoc', 25306, 'Ejido');
INSERT INTO `colonias` VALUES (680, 'El Recreo', 25306, 'Ejido');
INSERT INTO `colonias` VALUES (681, 'La Encantada', 25307, 'Ejido');
INSERT INTO `colonias` VALUES (682, 'La Encantada [Estación]', 25307, 'Paraje');
INSERT INTO `colonias` VALUES (683, 'El Caracol', 25310, 'Rancho');
INSERT INTO `colonias` VALUES (684, 'El Sauz', 25310, 'Ejido');
INSERT INTO `colonias` VALUES (685, 'Cinco de Mayo', 25310, 'Ejido');
INSERT INTO `colonias` VALUES (686, 'Cuautla', 25311, 'Ejido');
INSERT INTO `colonias` VALUES (687, 'La Majada y Tinaja', 25311, 'Ejido');
INSERT INTO `colonias` VALUES (688, 'Plan de Ayala', 25311, 'Ejido');
INSERT INTO `colonias` VALUES (689, 'Puebla', 25311, 'Ejido');
INSERT INTO `colonias` VALUES (690, 'El Paraíso', 25311, 'Colonia');
INSERT INTO `colonias` VALUES (691, 'Llanos de la Unión', 25313, 'Ejido');
INSERT INTO `colonias` VALUES (692, 'José María Morelos (Tanque Roto)', 25313, 'Ejido');
INSERT INTO `colonias` VALUES (693, 'Buenavista', 25315, 'Colonia');
INSERT INTO `colonias` VALUES (694, 'La Angostura', 25315, 'Ejido');
INSERT INTO `colonias` VALUES (695, 'Eulalio Gutiérrez Treviño', 25315, 'Colonia');
INSERT INTO `colonias` VALUES (696, 'La Parcela 74', 25316, 'Ranchería');
INSERT INTO `colonias` VALUES (697, 'La Magueyada', 25316, 'Colonia');
INSERT INTO `colonias` VALUES (698, 'Llanos de la Unión', 25317, 'Ejido');
INSERT INTO `colonias` VALUES (699, 'Ampliación Rincón de los Pastores', 25317, 'Ejido');
INSERT INTO `colonias` VALUES (700, 'Palma Gorda', 25318, 'Ejido');
INSERT INTO `colonias` VALUES (701, 'Agua Nueva [Estación]', 25320, 'Paraje');
INSERT INTO `colonias` VALUES (702, 'El Jagüey de Ferniza', 25320, 'Ejido');
INSERT INTO `colonias` VALUES (703, 'Parque Industrial Derramadero', 25320, 'Zona industrial');
INSERT INTO `colonias` VALUES (704, 'La Peñita', 25320, 'Colonia');
INSERT INTO `colonias` VALUES (705, 'Santa Fe de los Linderos', 25321, 'Ejido');
INSERT INTO `colonias` VALUES (706, 'Santa Fe de los Linderos (Sector 2)', 25321, 'Ejido');
INSERT INTO `colonias` VALUES (707, 'Hedionda Grande', 25322, 'Ejido');
INSERT INTO `colonias` VALUES (708, 'Agua Nueva', 25324, 'Ejido');
INSERT INTO `colonias` VALUES (709, 'Los Ángeles', 25324, 'Rancho');
INSERT INTO `colonias` VALUES (710, 'Estación Carneros', 25325, 'Paraje');
INSERT INTO `colonias` VALUES (711, 'Las Colonias', 25325, 'Ejido');
INSERT INTO `colonias` VALUES (712, 'Buñuelos', 25326, 'Ejido');
INSERT INTO `colonias` VALUES (713, 'San Felipe', 25326, 'Ejido');
INSERT INTO `colonias` VALUES (714, 'Tanque de Emergencia', 25327, 'Ejido');
INSERT INTO `colonias` VALUES (715, 'El Cercado', 25328, 'Ejido');
INSERT INTO `colonias` VALUES (716, 'Puyas y las Hormigas (Las Hormigas)', 25328, 'Ejido');
INSERT INTO `colonias` VALUES (717, 'La Esperanza (Las Puyas)', 25329, 'Ejido');
INSERT INTO `colonias` VALUES (718, 'San José del Alamito', 25329, 'Ejido');
INSERT INTO `colonias` VALUES (719, 'El Venado (Profesor Roberto Barrios)', 25329, 'Ejido');
INSERT INTO `colonias` VALUES (720, 'Estación el Fraile', 25330, 'Paraje');
INSERT INTO `colonias` VALUES (721, 'La India', 25330, 'Ejido');
INSERT INTO `colonias` VALUES (722, 'Santa Anita', 25331, 'Rancho');
INSERT INTO `colonias` VALUES (723, 'Santa Victoria', 25331, 'Ejido');
INSERT INTO `colonias` VALUES (724, 'Astillero', 25332, 'Ejido');
INSERT INTO `colonias` VALUES (725, 'Palmas Altas', 25332, 'Ejido');
INSERT INTO `colonias` VALUES (726, 'Tinajuela', 25332, 'Ejido');
INSERT INTO `colonias` VALUES (727, 'Zacatera', 25333, 'Ejido');
INSERT INTO `colonias` VALUES (728, 'Refugio de Altamira', 25333, 'Ejido');
INSERT INTO `colonias` VALUES (729, 'Benito Juárez', 25334, 'Ejido');
INSERT INTO `colonias` VALUES (730, 'El Mezquite', 25334, 'Ejido');
INSERT INTO `colonias` VALUES (731, 'El Salitre', 25334, 'Ejido');
INSERT INTO `colonias` VALUES (732, 'Guadalupe Victoria', 25334, 'Ejido');
INSERT INTO `colonias` VALUES (733, 'Las Mangas', 25334, 'Ejido');
INSERT INTO `colonias` VALUES (734, 'Potrero de San Pedro', 25334, 'Ejido');
INSERT INTO `colonias` VALUES (735, 'Gómez Farías', 25335, 'Ranchería');
INSERT INTO `colonias` VALUES (736, 'San Miguel (San Miguel del Banco)', 25335, 'Ejido');
INSERT INTO `colonias` VALUES (737, 'La Puerta (Anexo San Miguel del Banco)', 25335, 'Ejido');
INSERT INTO `colonias` VALUES (738, 'Presa de los Muchachos', 25336, 'Ejido');
INSERT INTO `colonias` VALUES (739, 'San Francisco del Ejido', 25336, 'Ejido');
INSERT INTO `colonias` VALUES (740, 'San Juan del Retiro', 25336, 'Ejido');
INSERT INTO `colonias` VALUES (741, 'Nuevo Gómez Farías', 25336, 'Ejido');
INSERT INTO `colonias` VALUES (742, 'La Cuchilla', 25336, 'Ejido');
INSERT INTO `colonias` VALUES (743, 'El Colorado', 25337, 'Ejido');
INSERT INTO `colonias` VALUES (744, 'El Rayado', 25337, 'Ejido');
INSERT INTO `colonias` VALUES (745, 'Presa de Guadalupe', 25337, 'Ejido');
INSERT INTO `colonias` VALUES (746, 'El Porvenir', 25337, 'Ejido');
INSERT INTO `colonias` VALUES (747, 'Jazminal', 25338, 'Ejido');
INSERT INTO `colonias` VALUES (748, 'Punta Santa Elena', 25338, 'Ejido');
INSERT INTO `colonias` VALUES (749, 'Presa de San Pedro', 25340, 'Ejido');
INSERT INTO `colonias` VALUES (750, 'Santa Rosa', 25340, 'Ejido');
INSERT INTO `colonias` VALUES (751, 'Encarnación de Guzmán', 25343, 'Ejido');
INSERT INTO `colonias` VALUES (752, 'San Isidro', 25343, 'Rancho');
INSERT INTO `colonias` VALUES (753, 'Tanque Escondido', 25343, 'Ejido');
INSERT INTO `colonias` VALUES (754, 'Puerto Rocamontes', 25343, 'Colonia');
INSERT INTO `colonias` VALUES (755, 'Santa Elena [Estación]', 25344, 'Paraje');
INSERT INTO `colonias` VALUES (756, 'La Colonia de San Sebastián', 25344, 'Ejido');
INSERT INTO `colonias` VALUES (757, 'Presa de San Javier', 25345, 'Ejido');
INSERT INTO `colonias` VALUES (758, 'La Purísima', 25346, 'Ejido');
INSERT INTO `colonias` VALUES (759, 'La Ventura', 25347, 'Ejido');
INSERT INTO `colonias` VALUES (760, 'Tanque del Cerro', 25347, 'Ejido');
INSERT INTO `colonias` VALUES (761, 'El Ranchito', 25348, 'Ejido');

-- ----------------------------
-- Table structure for cuadrillas
-- ----------------------------
DROP TABLE IF EXISTS `cuadrillas`;
CREATE TABLE `cuadrillas`  (
  `id_cuadrilla` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_cuadrilla`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cuadrillas
-- ----------------------------
INSERT INTO `cuadrillas` VALUES (4, 'Limpieza Sureste');

-- ----------------------------
-- Table structure for empleados
-- ----------------------------
DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados`  (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cargo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `es_jefe_cuadrilla` tinyint(1) NULL DEFAULT 0,
  `id_cuadrilla` int NULL DEFAULT NULL,
  `id_usuario` int NULL DEFAULT NULL,
  PRIMARY KEY (`id_empleado`) USING BTREE,
  INDEX `id_cuadrilla`(`id_cuadrilla` ASC) USING BTREE,
  INDEX `id_usuario`(`id_usuario` ASC) USING BTREE,
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`id_cuadrilla`) REFERENCES `cuadrillas` (`id_cuadrilla`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of empleados
-- ----------------------------
INSERT INTO `empleados` VALUES (1, 'Rafael Jimenez Martínez', 'General', 0, 4, 2);

-- ----------------------------
-- Table structure for observadores
-- ----------------------------
DROP TABLE IF EXISTS `observadores`;
CREATE TABLE `observadores`  (
  `id_observador` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NULL DEFAULT NULL,
  `id_actividad` int NULL DEFAULT NULL,
  `mensaje` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_observador`) USING BTREE,
  INDEX `id_usuario`(`id_usuario` ASC) USING BTREE,
  INDEX `id_actividad`(`id_actividad` ASC) USING BTREE,
  CONSTRAINT `observadores_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `observadores_ibfk_2` FOREIGN KEY (`id_actividad`) REFERENCES `actividades_limpieza` (`id_actividad`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of observadores
-- ----------------------------

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios`  (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `rol` enum('ADMINISTRADOR','EMPLEADO') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_usuario`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES (1, 'GerardoCasten', 'Casten4all_', 'ADMINISTRADOR');
INSERT INTO `usuarios` VALUES (2, 'RafaelJmz', '12345', 'EMPLEADO');

SET FOREIGN_KEY_CHECKS = 1;
