USE projektverwaltung;

INSERT INTO Ort (PLZ, NAME) 
VALUES (32257,"Buende");

INSERT INTO Ort (PLZ, NAME) 
VALUES (32584,"Loehne");

INSERT INTO Ort (PLZ, NAME) 
VALUES (32278,"Kirchlengern");


INSERT INTO abteilung (Abtlgs_Nr, NAME)
VALUES (1,"Versandabteilung");

INSERT INTO abteilung (Abtlgs_Nr, NAME)
VALUES (2,"Kundenservice");

INSERT INTO abteilung (Abtlgs_Nr, NAME)
VALUES (3,"Personalabteilung");

INSERT INTO abteilung (Abtlgs_Nr, NAME)
VALUES (4,"Geschäftsleitung");

INSERT INTO abteilung (Abtlgs_Nr, NAME)
VALUES (5,"Marketingabteilung");

INSERT INTO abteilung (Abtlgs_Nr, NAME)
VALUES (6,"Finanzabteilung");

INSERT INTO abteilung (Abtlgs_Nr, NAME)
VALUES (7,"Reinigungsdienst");


INSERT INTO projekt (ProjektNr, NAME)
VALUES (1,"Mauerbau"); 

INSERT INTO projekt (ProjektNr, NAME)
VALUES (2,"NeuesRathaus"); 

INSERT INTO projekt (ProjektNr, NAME)
VALUES (3,"sanierungenwasserleitung"); 

INSERT INTO projekt (ProjektNr, NAME)
VALUES (4,"RestaurierungHermannsdenkmal"); 

INSERT INTO projekt (ProjektNr, NAME)
VALUES (5,"Kirchenanbau"); 


INSERT INTO arbeitnehmer (AN_NR, Abtlgs_Nr, NAME, Vorname, Telefon, Straße, PLZ, GEB_DATUM)
VALUES (4,1,"Schmitt","Gunter",4662782,"gotestaßenr22",32257,"1257-3-2");

INSERT INTO arbeitnehmer (AN_NR, Abtlgs_Nr, NAME, Vorname, Telefon, Straße, PLZ, GEB_DATUM)
VALUES (6,2,"Bekker","Herbert",3564376,"gotestaßenr32",32257,"1425-3-2");

INSERT INTO arbeitnehmer (AN_NR, Abtlgs_Nr, NAME, Vorname, Telefon, Straße, PLZ, GEB_DATUM)
VALUES (8,3,"Schmitt","Kevin",2465970,"gotestaßenr42",32257,"1258-2-3");

INSERT INTO arbeitnehmer (AN_NR, Abtlgs_Nr, NAME, Vorname, Telefon, Straße, PLZ, GEB_DATUM)
VALUES (10,4,"Meier","Chantal",1367564,"keiuvestaßenr52",32584,"1426-3-2");

INSERT INTO arbeitnehmer (AN_NR, Abtlgs_Nr, NAME, Vorname, Telefon, Straße, PLZ, GEB_DATUM)
VALUES (12,5,"Schneider","Callahan",9269158,"keiuvestaßenr62",32584,"1259-3-3");

INSERT INTO arbeitnehmer (AN_NR, Abtlgs_Nr, NAME, Vorname, Telefon, Straße, PLZ, GEB_DATUM)
VALUES (14,6,"Schneider","Gustaf",4829248,"dobbestaßenr72",32278,"1427-3-3");

INSERT INTO arbeitnehmer (AN_NR, Abtlgs_Nr, NAME, Vorname, Telefon, Straße, PLZ, GEB_DATUM)
VALUES (16,7,"Lee","Mohammed",1927654,"dobbestaßenr82",32278,"1257-2-22");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (16,3,"K.Schmitt");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (16 ,2,"M.Lee");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (4,4,"Ch.Meier");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (4,1,"Ch.Meier");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (6,2,"G.Schneider");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (8,3,"K.Schmitt");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (10,4,"Ch.Meier");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (12,5,"C.Schneider");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (14,2,"M.Lee");

INSERT INTO mitarbeiterzuprojekt (AN_NR, ProjektNr, Verantwortlich)
VALUES (6,4,"Ch.Meier");