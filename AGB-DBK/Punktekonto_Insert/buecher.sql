#SHOW DATABASES;
USE BUECHER;
INSERT INTO ORT(PLZ, Name) VALUES("32602", "Vlotho");
INSERT INTO ORT(PLZ, Name) VALUES("32549", "Bad Oeynhausen");
INSERT INTO ORT(PLZ, Name) VALUES("38492", "Wunderhausen");

INSERT INTO AUTOR(AutorNr, Name, Strasse, PLZ)
VALUES("01", "Peter Mueller", "Vlothoerstrasse", "32602");
INSERT INTO AUTOR(AutorNr, Name, Strasse, PLZ)
VALUES("02", "Klaus Frederick", "Bad Oeynhausenerstrasse", "32549");
INSERT INTO AUTOR(AutorNr, Name, Strasse, PLZ)
VALUES("03", "Dieter Bork", "Eichenweg", "38492");

INSERT INTO VERLAG(VerlagNr, Name,PLZ)
VALUES("123456", "Cornelsen","32602");
INSERT INTO VERLAG(VerlagNr, Name,PLZ)
VALUES("654321", "Neslenroc","32549");
INSERT INTO VERLAG(VerlagNr, Name,PLZ)
VALUES("1234789", "Rocneslen","38492");

INSERT INTO BUCH(ISBN, Titel, VerlagNr)
VALUES("4781392", "Oblivion","123456");
INSERT INTO BUCH(ISBN, Titel, VerlagNr)
VALUES("2931874", "Skyrim", "654321");
INSERT INTO BUCH(ISBN, Titel, VerlagNr)
VALUES("1392874", "Morrowwind", "1234789");

INSERT INTO BUCHZUAUTOR(AutorNr, ISBN)
VALUES("01", "4781392");
INSERT INTO BUCHZUAUTOR(AutorNr, ISBN)
VALUES("02", "2931874");
INSERT INTO BUCHZUAUTOR(AutorNr, ISBN)
VALUES("03", "1392874");