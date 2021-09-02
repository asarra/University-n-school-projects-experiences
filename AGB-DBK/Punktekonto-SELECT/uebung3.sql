SELECT * FROM uebungen.t_proj ORDER BY name ASC;
SELECT *,COUNT(AN_NR) AS AnzahlArbeitnehmer FROM projektverwaltung.arbeitnehmer GROUP BY PLZ;
SELECT * FROM projektverwaltung.mitarbeiterzuprojekt WHERE VERANTWORTLICH LIKE '%Meier' AND
	NOT '%Schmitt' OR '%Lee' AND PROJEKTNR IN (1 , 4);
SELECT * FROM buecher.ort WHERE PLZ=32549;
SELECT * FROM mitfahrgelegenheit.schüler WHERE `ALTER` BETWEEN 20 AND 21;
SELECT DISTINCT Vorname FROM kuenstlerverwaltung.kuenstlerin;#DISTINCT
SELECT name FROM uebungen.t_proj;
SELECT id,preis FROM uebungen.t_lager;
SELECT name, ort FROM uebungen.t_abt ORDER BY ort;