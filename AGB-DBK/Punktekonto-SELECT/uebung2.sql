use uebungen;
SELECT * FROM t_produkt WHERE name LIKE "Mutter%" ORDER BY CAST(REPLACE(name,"Mutter M",'') AS INT) DESC;
SELECT *, COUNT(id) AS AnzahlProdukt FROM t_artikel WHERE
    lieferant = (SELECT id FROM t_liefer WHERE name = 'Klecks')
		GROUP BY name;
SELECT * FROM t_artikel WHERE code >=3400 and code <= 4400;
SELECT * FROM t_produkt WHERE name LIKE "Unterleg%" and CAST(REPLACE(name,"Unterlegscheibe M",'') AS INT) IN (4,6,8);
SELECT *,COUNT(id) AS AnzahlMitarbeiter FROM t_ma WHERE plz BETWEEN 10115 AND 20999 
	GROUP BY ort ORDER BY vname ASC; #Verlangt die Aufgabe das? 4 Zeilen Schwerin oder pro Zeile nur eine Stadt? GROUP BY? Das ergibt keinen Sinn!
#SELECT * FROM t_produkt WHERE name like "M%" order by id desc;
#like "U__________"
