use blumenundtiere;

#Nahrung:
INSERT INTO NAHRUNG (NahrungsID , NahrungsName)
VALUES (1,"Nektar");
INSERT INTO NAHRUNG (NahrungsID , NahrungsName)
VALUES (2,"Planzensaft");
INSERT INTO NAHRUNG (NahrungsID , NahrungsName)
VALUES (3,"Pollen");
INSERT INTO NAHRUNG (NahrungsID , NahrungsName)
VALUES (4,"Kerne");

#übersetzung:
INSERT INTO übersetzung (NamenID,latname,dtname) VALUES (1,"Helianthusannuus","Sonnenblume");
INSERT INTO übersetzung (NamenID,latname,dtname) VALUES (2,"Papaver","Mohn");
INSERT INTO übersetzung (NamenID,latname,dtname) VALUES (3,"Tulipa","Tulpe");

#Blume
INSERT INTO blume (BlumenNr,Blütezeit,NamenID) VALUES
(1,"Juni-September",1);
INSERT INTO blume
(BlumenNr,Blütezeit,NamenID) VALUES
(2,"Mai-September",2);
INSERT INTO blume
(BlumenNr,Blütezeit,NamenID) VALUES
(3,"April-Juni",3);



#tier:
INSERT INTO tier(tierNr,NamenID)
VALUES(2,1);
INSERT INTO tier(tierNr,NamenID)
VALUES(1,2);
INSERT INTO tier(tierNr,NamenID)
VALUES(3,3);

#tierZuNahrung:
INSERT INTO tierzunahrung (NahrungsID,tierNr)
VALUES (1,2);
INSERT INTO tierzunahrung (NahrungsID,tierNr)
VALUES (2,1);
INSERT INTO tierzunahrung (NahrungsID,tierNr)
VALUES (3,3);

#Blumenzunahrung:
INSERT INTO  blumezunahrung (BlumenNr,NahrungsID) VALUES (1,2);
INSERT INTO  blumezunahrung (BlumenNr,NahrungsID) VALUES (2,1);
INSERT INTO  blumezunahrung (BlumenNr,NahrungsID) VALUES (3,3);