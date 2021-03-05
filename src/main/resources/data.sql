--Creation of the database
DROP TABLE IF EXISTS GROCERY_ITEM_ORDER;
DROP TABLE IF EXISTS GROCERY_ORDER;
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS GROCERY_ITEM;
DROP TABLE IF EXISTS FEEDBACK;

--Tables
CREATE TABLE USER(
  ID_USER INTEGER IDENTITY PRIMARY KEY,
  FULL_NAME VARCHAR(100) NOT NULL,
  EMAIL VARCHAR(255) NOT NULL
);

CREATE TABLE FEEDBACK(
  ID_FEEDBACK INTEGER IDENTITY PRIMARY KEY,
  RATE INTEGER NOT NULL,
  COMMENT CLOB NOT NULL,
  CREATED TIMESTAMP NOT NULL
);

CREATE TABLE GROCERY_ORDER(
  ID_GROCERY_ORDER INTEGER IDENTITY PRIMARY KEY,
  SHIPPING_ADDRESS CLOB,
  CREATION_DATE DATE,
  ID_USER INTEGER NOT NULL,
  ID_FEEDBACK INTEGER,
  FOREIGN KEY (ID_USER) REFERENCES USER(ID_USER),
  FOREIGN KEY (ID_FEEDBACK) REFERENCES FEEDBACK(ID_FEEDBACK)
);

CREATE TABLE GROCERY_ITEM(
  ID_GROCERY_ITEM INTEGER IDENTITY PRIMARY KEY,
  ITEM_NAME VARCHAR(50) NOT NULL,
  PRICE DOUBLE NOT NULL,
  ID_FEEDBACK INTEGER,
  FOREIGN KEY(ID_FEEDBACK) REFERENCES FEEDBACK(ID_FEEDBACK)
);

CREATE TABLE GROCERY_ITEM_ORDER(
  ID_GROCERY_ITEM_ORDER INTEGER IDENTITY PRIMARY KEY,
  ID_GROCERY_ITEM INTEGER,
  ID_GROCERY_ORDER INTEGER,
  FOREIGN KEY (ID_GROCERY_ITEM) REFERENCES GROCERY_ITEM(ID_GROCERY_ITEM),
  FOREIGN KEY (ID_GROCERY_ORDER) REFERENCES GROCERY_ORDER(ID_GROCERY_ORDER)
);

--GENERATED DATA
--USERS
INSERT INTO USER(FULL_NAME, EMAIL) VALUES ('Fulanito Perez', 'fulanito123@correo.com');
INSERT INTO USER(FULL_NAME, EMAIL) VALUES ('Perenganito Sanchez', 'perenganito123@correo.com');
INSERT INTO USER(FULL_NAME, EMAIL) VALUES ('Ivan Martinez','ivan123@correo.com');
--FEEDBACKS
INSERT INTO FEEDBACK (RATE,COMMENT,CREATED) VALUES (1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec','2020-05-06 07:17:57'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper.','2020-04-13 14:12:22'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2019-07-31 16:48:04'),(3,'Lorem ipsum dolor','2020-04-17 05:14:34'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus','2020-12-08 19:58:13'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam','2019-12-13 06:48:49'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet','2019-11-10 11:53:33'),(3,'Lorem ipsum','2020-11-20 02:37:54'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non,','2020-04-10 10:49:56'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam','2020-05-13 03:46:55'),(4,'Lorem ipsum dolor sit','2020-02-23 23:49:27'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet','2020-04-23 10:53:58'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing','2020-06-26 13:27:37'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida','2019-05-17 08:39:30'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed','2020-08-11 16:21:28'),(3,'Lorem ipsum dolor sit amet, consectetuer','2020-03-06 13:34:33'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet','2019-06-13 10:52:09'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus.','2019-11-01 14:00:52'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna','2019-05-22 10:05:01'),(5,'Lorem','2020-01-30 02:54:12'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed','2019-10-16 12:42:41'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2020-05-30 07:33:08'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet','2019-06-15 04:05:49'),(1,'Lorem ipsum dolor','2019-07-16 07:38:47'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien,','2020-02-21 22:03:24');
INSERT INTO FEEDBACK (RATE,COMMENT,CREATED) VALUES (1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et','2020-06-20 12:17:34'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper.','2021-01-12 22:34:45'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut','2019-09-28 21:18:32'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2019-12-08 19:24:15'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et','2019-08-24 10:10:50'),(1,'Lorem ipsum dolor sit amet,','2020-05-06 04:04:27'),(1,'Lorem ipsum dolor sit amet, consectetuer','2020-07-10 10:14:15'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non,','2019-11-06 05:59:13'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing','2019-12-20 06:54:59'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2020-02-11 06:23:54'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu','2021-01-10 05:34:14'),(3,'Lorem ipsum dolor sit amet,','2020-04-12 18:12:25'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu','2020-08-12 04:24:37'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec','2020-11-22 15:46:55'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2019-08-11 13:32:38'),(3,'Lorem ipsum dolor sit','2020-02-18 08:47:32'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing','2021-01-02 15:30:10'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at','2020-03-12 15:49:11'),(5,'Lorem ipsum','2020-11-30 15:18:13'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer','2020-07-22 18:52:16'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer','2020-05-19 08:18:56'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut','2020-12-14 03:18:54'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque','2020-04-28 20:01:12'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus','2020-05-02 15:25:19'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.','2020-07-12 02:20:23');
INSERT INTO FEEDBACK (RATE,COMMENT,CREATED) VALUES (2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer','2019-07-02 15:45:48'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper.','2019-03-20 19:59:05'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus','2020-03-31 13:00:50'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et','2019-03-04 23:21:01'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing','2020-04-16 07:49:24'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer','2020-08-07 11:25:01'),(3,'Lorem ipsum dolor','2019-07-22 10:28:11'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec','2019-12-07 17:57:17'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor.','2019-05-11 16:51:08'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna','2020-06-03 20:10:35'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna','2019-09-20 09:08:19'),(1,'Lorem ipsum','2019-08-17 16:15:46'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at','2021-02-21 09:55:44'),(5,'Lorem ipsum dolor sit','2021-01-16 10:00:41'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus','2020-06-29 10:11:49'),(3,'Lorem ipsum','2019-05-23 10:03:50'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec','2019-10-19 06:11:56'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer','2020-04-03 18:36:29'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2019-07-05 08:46:01'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2020-05-31 21:50:33'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec','2020-07-02 10:15:00'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2021-02-09 13:42:14'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna','2020-07-19 19:13:15'),(5,'Lorem ipsum dolor sit amet, consectetuer','2019-12-29 20:58:38'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et','2021-01-18 15:47:55');
INSERT INTO FEEDBACK (RATE,COMMENT,CREATED) VALUES (1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus.','2019-12-28 05:08:30'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor.','2019-07-19 03:23:26'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet','2019-07-02 22:59:09'),(5,'Lorem ipsum','2021-02-14 13:26:55'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut','2020-03-10 08:25:50'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida','2020-03-31 07:39:35'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed','2020-06-21 08:19:02'),(2,'Lorem ipsum dolor','2019-10-06 01:30:56'),(2,'Lorem ipsum dolor sit','2020-10-20 20:06:41'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu','2020-12-31 01:48:33'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at','2020-01-06 03:38:36'),(1,'Lorem','2019-12-17 17:13:15'),(2,'Lorem ipsum dolor sit amet,','2019-06-25 22:07:05'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus','2019-10-02 07:38:17'),(4,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non,','2019-04-11 15:56:33'),(3,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non,','2020-09-14 11:57:59'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at','2019-03-11 00:57:43'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at','2020-01-12 06:07:20'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet','2019-06-21 08:22:24'),(5,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu','2020-04-03 00:04:22'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec','2020-05-13 17:22:37'),(5,'Lorem ipsum dolor sit amet,','2020-01-03 01:25:54'),(1,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper.','2019-09-03 06:10:51'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.','2020-07-28 05:16:01'),(2,'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur','2020-01-22 05:41:42');
--GROCERY ORDERS
INSERT INTO GROCERY_ORDER (SHIPPING_ADDRESS,CREATION_DATE,ID_USER,ID_FEEDBACK) VALUES ('P.O. Box 893, 2818 Ac St.','2020-08-11',2,1),('714-2667 Ullamcorper St.','2020-07-14',2,2),('1502 Montes, Avenue','2019-09-14',3,3),('Ap #228-1252 Ac Rd.','2019-04-08',3,4),('120 Justo. St.','2019-12-12',3,5),('Ap #998-9418 Aliquam St.','2021-01-31',1,6),('Ap #171-7180 Varius Rd.','2019-09-22',3,7),('3643 Suspendisse Street','2020-03-08',2,8),('Ap #840-7057 Phasellus St.','2019-04-20',1,9),('Ap #840-2115 Nisl Avenue','2019-07-20',1,10),('1466 Id, Road','2019-12-30',2,11),('Ap #118-9994 At Av.','2019-09-30',1,12),('877-9255 Mauris. Rd.','2019-08-17',1,13),('454-9466 Risus. Ave','2019-03-06',3,14),('P.O. Box 554, 4351 Libero Road','2019-03-20',1,15),('6234 Mauris Road','2019-03-13',2,16),('439-4184 Eu Road','2019-07-01',1,17),('Ap #600-5991 Nunc. Rd.','2020-08-21',1,18),('918-1011 Nulla. St.','2021-01-16',1,19),('P.O. Box 870, 4957 Risus. St.','2019-12-20',1,20),('P.O. Box 264, 9580 Interdum. Av.','2020-03-22',3,21),('P.O. Box 236, 9765 Egestas, St.','2019-12-23',3,22),('433-1996 Non, St.','2020-07-12',2,23),('Ap #336-5819 Semper Avenue','2019-10-13',3,24),('4307 Aliquam St.','2021-01-13',1,25);
INSERT INTO GROCERY_ORDER (SHIPPING_ADDRESS,CREATION_DATE,ID_USER,ID_FEEDBACK) VALUES ('9527 Ut Av.','2020-08-09',1,26),('903 Eu, Ave','2020-10-30',1,27),('Ap #949-3797 Augue St.','2019-05-23',2,28),('Ap #203-8552 Magnis Avenue','2020-02-17',2,29),('P.O. Box 260, 1442 Dis Ave','2019-12-11',3,30),('P.O. Box 556, 4768 Eu Rd.','2019-11-17',3,31),('P.O. Box 579, 5012 Lobortis. Avenue','2020-03-14',2,32),('213-5750 Nibh Ave','2019-12-25',3,33),('Ap #309-7888 Nullam Street','2019-11-24',1,34),('Ap #735-7093 Convallis St.','2019-09-16',1,35),('Ap #996-7459 Ultrices Rd.','2020-07-18',1,36),('9429 Integer Ave','2020-08-08',2,37),('Ap #904-6531 Senectus Av.','2019-10-02',2,38),('P.O. Box 514, 8153 Volutpat. St.','2019-12-24',3,39),('P.O. Box 712, 8723 Non, Rd.','2021-01-12',2,40),('805-3870 Dolor. Street','2020-07-01',2,41),('Ap #388-9903 Proin Rd.','2019-07-10',1,42),('140-1593 Tempus, Ave','2020-02-07',1,43),('4061 Rutrum. St.','2020-09-11',2,44),('440-5007 Neque Street','2019-12-23',3,45),('P.O. Box 293, 9742 Erat Rd.','2019-12-01',1,46),('Ap #351-5385 Pellentesque, Av.','2021-02-23',3,47),('P.O. Box 168, 5606 Duis Rd.','2020-02-11',2,48),('6146 Etiam Avenue','2020-05-13',3,49),('142-1606 Ipsum Avenue','2020-02-04',3,50);
INSERT INTO GROCERY_ORDER (SHIPPING_ADDRESS,CREATION_DATE,ID_USER,ID_FEEDBACK) VALUES ('9822 Tincidunt Rd.','2020-04-09',2,51),('Ap #491-4050 In Street','2020-10-09',3,52),('Ap #661-2206 Vulputate St.','2019-11-09',3,53),('Ap #329-263 Lectus Avenue','2021-02-02',1,54),('6691 Auctor Avenue','2020-09-09',1,55),('4966 Risus. Rd.','2020-09-29',1,56),('727-2797 Phasellus Street','2020-08-11',1,57),('P.O. Box 922, 5431 Cursus. Road','2020-10-02',1,58),('P.O. Box 311, 9988 Phasellus Avenue','2020-01-01',2,59),('1119 Donec St.','2019-05-06',2,60),('Ap #545-3178 Elit. Ave','2019-03-21',3,61),('Ap #720-899 Vulputate, Av.','2020-12-11',1,62),('126-2729 Lobortis. St.','2019-11-08',3,63),('Ap #677-1756 Diam. Rd.','2019-04-04',3,64),('6845 Ut Rd.','2021-01-04',1,65),('699-6378 Blandit St.','2019-12-17',3,66),('4484 Lobortis Ave','2020-11-09',2,67),('2992 Conubia Ave','2019-11-30',1,68),('105-3573 A, Street','2020-04-21',1,69),('P.O. Box 197, 7936 Nullam St.','2019-03-15',2,70),('Ap #235-3867 Malesuada St.','2020-06-11',3,71),('Ap #475-3141 Vel Ave','2019-09-01',1,72),('P.O. Box 225, 7976 Nullam St.','2020-03-16',3,73),('587 Blandit. Av.','2020-07-02',3,74),('P.O. Box 141, 8788 Dapibus Av.','2019-08-28',2,75);
INSERT INTO GROCERY_ORDER (SHIPPING_ADDRESS,CREATION_DATE,ID_USER,ID_FEEDBACK) VALUES ('370-308 Primis St.','2020-04-30',2,76),('Ap #624-3518 Duis Rd.','2019-07-13',3,77),('2880 Est St.','2019-03-18',3,78),('7133 Sit Avenue','2021-01-30',2,79),('P.O. Box 532, 8662 Lacus. Road','2020-08-08',1,80),('863-4732 Amet Road','2019-11-30',3,81),('4113 A, Ave','2019-07-10',3,82),('P.O. Box 687, 3643 Mi St.','2021-01-13',2,83),('587-1666 Consequat, St.','2020-06-15',3,84),('3253 Vitae Ave','2020-09-13',3,85),('Ap #987-4332 Mi Rd.','2019-12-11',2,86),('P.O. Box 691, 3695 A, Ave','2019-06-08',1,87),('Ap #290-9231 Pulvinar Av.','2020-08-13',3,88),('Ap #208-122 Tincidunt, Road','2019-10-07',2,89),('P.O. Box 162, 6400 Tempus Rd.','2019-12-07',3,90),('Ap #176-872 Consequat Street','2019-08-07',2,91),('P.O. Box 268, 1700 Id, St.','2019-08-15',3,92),('Ap #932-8699 Commodo St.','2019-06-16',1,93),('181-4662 Laoreet, St.','2019-05-16',1,94),('652-9399 Dolor St.','2020-04-06',3,95),('Ap #910-1343 Mollis St.','2019-08-06',3,96),('995-6659 Est Street','2020-07-28',2,97),('Ap #472-5927 Amet, Road','2019-06-12',3,98),('983-3018 Porttitor Rd.','2020-03-04',1,99),('216-6075 Quis Ave','2019-05-07',2,100);
--ITEMS
INSERT INTO GROCERY_ITEM (ITEM_NAME, PRICE) VALUES ('RICE',25.1);
INSERT INTO GROCERY_ITEM (ITEM_NAME, PRICE) VALUES ('MILK',10.34);
INSERT INTO GROCERY_ITEM (ITEM_NAME, PRICE) VALUES ('12 EGGS',40.55);
INSERT INTO GROCERY_ITEM (ITEM_NAME, PRICE) VALUES ('BREAD',20.9);
INSERT INTO GROCERY_ITEM (ITEM_NAME, PRICE) VALUES ('COMIC BOOK',320.0);
--ITEMS-ORDERS
INSERT INTO GROCERY_ITEM_ORDER (ID_GROCERY_ITEM,ID_GROCERY_ORDER) VALUES (4,35),(4,80),(5,14),(3,14),(2,29),(2,92),(1,41),(2,81),(5,54),(5,77),(5,15),(3,25),(3,89),(4,79),(1,89),(5,10),(2,53),(5,27),(4,86),(3,6),(3,77),(2,26),(3,43),(4,22),(4,70);

COMMIT;