use vorlesungen;
#SELECT * FROM professoren CROSS JOIN vorlesungen.assistenten;
SELECT * FROM professoren CROSS JOIN hoeren;
SELECT * FROM professoren CROSS JOIN pruefen;
SELECT * FROM professoren CROSS JOIN studenten;
SELECT * FROM professoren CROSS JOIN vorlesung;

#SELECT * FROM professoren INNER JOIN hoeren;
SELECT * FROM professoren INNER JOIN pruefen ON professoren.persNr=pruefen.PersNr;
SELECT * FROM studenten INNER JOIN hoeren ON studenten.MatrNr=hoeren.MatrNr;
SELECT * FROM professoren INNER JOIN vorlesung ON professoren.persNr=vorlesung.gelesen_von;
SELECT * FROM studenten INNER JOIN vorlesung ON studenten.semester=vorlesung.sws;

SELECT * FROM professoren NATURAL JOIN hoeren;
SELECT * FROM professoren NATURAL JOIN pruefen;
SELECT * FROM professoren NATURAL JOIN studenten;#
SELECT * FROM professoren NATURAL JOIN vorlesung;
SELECT * FROM professoren NATURAL JOIN assistenten;#
SELECT * FROM studenten NATURAL JOIN vorlesung;

SELECT * FROM professoren INNER JOIN pruefen ON professoren.persNr<=pruefen.PersNr;
SELECT * FROM studenten INNER JOIN hoeren ON studenten.MatrNr<hoeren.MatrNr;
SELECT * FROM professoren INNER JOIN vorlesung ON professoren.persNr>=vorlesung.gelesen_von;
SELECT * FROM studenten INNER JOIN vorlesung ON studenten.semester<vorlesung.sws;
SELECT * FROM studenten INNER JOIN hoeren ON studenten.MatrNr<>hoeren.MatrNr;

SELECT * FROM professoren LEFT JOIN assistenten ON professoren.persNr=assistenten.boss;
SELECT * FROM professoren LEFT JOIN pruefen ON professoren.persNr=pruefen.PersNr;
SELECT * FROM studenten LEFT JOIN hoeren ON studenten.MatrNr=hoeren.MatrNr;
SELECT * FROM professoren LEFT JOIN vorlesung ON professoren.persNr=vorlesung.gelesen_von;
SELECT * FROM studenten LEFT JOIN vorlesung ON studenten.semester=vorlesung.sws;

SELECT * FROM professoren RIGHT JOIN assistenten ON professoren.persNr=assistenten.boss;
SELECT * FROM professoren RIGHT JOIN pruefen ON professoren.persNr=pruefen.PersNr;
SELECT * FROM studenten RIGHT JOIN hoeren ON studenten.MatrNr=hoeren.MatrNr;
SELECT * FROM professoren RIGHT JOIN vorlesung ON professoren.persNr=vorlesung.gelesen_von;
SELECT * FROM studenten RIGHT JOIN vorlesung ON studenten.semester=vorlesung.sws;

#SELECT * FROM professoren FULL JOIN assistenten ON professoren.persNr=assistenten.boss;
#SELECT * FROM professoren FULL JOIN pruefen ON professoren.persNr=pruefen.PersNr;
#SELECT * FROM studenten FULL JOIN hoeren ON studenten.MatrNr=hoeren.MatrNr;
#SELECT * FROM professoren FULL JOIN vorlesung ON professoren.persNr=vorlesung.gelesen_von;
#SELECT * FROM studenten FULL JOIN vorlesung ON studenten.semester=vorlesung.sws;


SELECT * FROM professoren LEFT JOIN assistenten ON professoren.persNr=assistenten.boss UNION ALL SELECT * FROM professoren LEFT JOIN assistenten ON professoren.persNr=assistenten.boss;
SELECT * FROM professoren LEFT JOIN pruefen ON professoren.persNr=pruefen.PersNr UNION ALL SELECT * FROM professoren RIGHT JOIN pruefen ON professoren.persNr=pruefen.PersNr;
SELECT * FROM studenten LEFT JOIN hoeren ON studenten.MatrNr=hoeren.MatrNr UNION ALL SELECT * FROM studenten RIGHT JOIN hoeren ON studenten.MatrNr=hoeren.MatrNr;
SELECT * FROM professoren LEFT JOIN vorlesung ON professoren.persNr=vorlesung.gelesen_von UNION ALL SELECT * FROM professoren RIGHT JOIN vorlesung ON professoren.persNr=vorlesung.gelesen_von;
SELECT * FROM studenten LEFT JOIN vorlesung ON studenten.semester=vorlesung.sws UNION ALL SELECT * FROM studenten RIGHT JOIN vorlesung ON studenten.semester=vorlesung.sws;

#u-sql hat semi join! semi müssen wir uns zusammenbasteln!
SELECT professoren.* FROM professoren NATURAL JOIN hoeren;#semi join = natural join+left/right
SELECT professoren.* FROM professoren NATURAL JOIN pruefen;
SELECT professoren.* FROM professoren NATURAL JOIN voraussetzen;
SELECT professoren.* FROM professoren NATURAL JOIN vorlesung;
SELECT voraussetzen.* FROM professoren NATURAL JOIN voraussetzen;#natural join überprüft welche gleichnamigen spalten die gleichen werte haben
SELECT studenten.* FROM studenten NATURAL JOIN vorlesung;

#SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
#FROM Customers A, Customers B

SELECT A.persNr AS persNr, B.persNr AS persNr2, A.name
FROM professoren A, professoren B WHERE A.persNr=B.persNr;
SELECT A.persNr AS persNr, B.persNr AS persNr2, A.name
FROM professoren A, professoren B WHERE B.persNr=A.persNr;
SELECT B.persNr AS persNr, A.persNr AS persNr2, B.name
FROM professoren B, professoren A WHERE B.persNr=A.persNr;
SELECT B.persNr AS persNr, A.persNr AS persNr2, B.name
FROM professoren B, professoren A WHERE A.persNr=B.persNr;
SELECT B.persNr AS persNr, A.persNr AS persNr2, B.name
FROM professoren B, professoren A WHERE A.persNr<B.persNr;