use vorlesungen;



#Listen Sie die Namen aller Studenten und die Namen der Vorlesungen auf,
#die die Vorlesungen des Professors Russel (PersNr 2126) hören. Vermeiden Sie Doppelnennungen. 
SELECT DISTINCT
    studenten.name, vorlesung.titel
FROM
    (((professoren
    INNER JOIN vorlesung ON professoren.persNr = vorlesung.gelesen_von)
    INNER JOIN hoeren)
    INNER JOIN studenten ON studenten.MatrNr = hoeren.MatrNr)
WHERE
    professoren.persNr = 2126;



#Finden Sie heraus, welche Studenten (Studentenname) welche Vorlesung (Titel) besuchen.
#Listen Sie dabei auch die Semesteranzahl der Studenten mit auf. Sortieren Sie anhand der Vorlesung. 
SELECT 
    studenten.name, studenten.semester, vorlesung.titel
FROM
    studenten
        INNER JOIN
    vorlesung
ORDER BY vorlesung.titel;
#inner join hoeren


#Geben Sie an, welche der Vorlesung (Nummer, Titel),
#die von Professor Sokrates (PersNr 2125) gelesen werden,
#einen Vorgänger hat. Vermeiden Sie Doppelnennungen. 
SELECT DISTINCT
    vorlesung.VorlNr AS Nummer, vorlesung.titel AS Titel, voraussetzen.vorgaenger
FROM
    ((professoren
    INNER JOIN vorlesung ON professoren.persNr = vorlesung.gelesen_von)
    INNER JOIN voraussetzen ON voraussetzen.nachfolger = vorlesung.VorlNr)
WHERE
    professoren.persNr = 2125; #Doppelnennungen vermieden!



#4. Geben Sie die Raumnummer an, in der Student Jonas (MatrikelNr 25403) geprüft wurde. Vermeiden Sie Doppelnennungen.  
SELECT DISTINCT
    professoren.raum
FROM
    (((studenten
    INNER JOIN pruefen ON studenten.MatrNr = pruefen.MatrNr)
    INNER JOIN vorlesung ON pruefen.VorlNr = vorlesung.VorlNr)
    INNER JOIN professoren ON vorlesung.gelesen_von = professoren.persNr)
WHERE
    studenten.MatrNr = 25403;



#5. Finden Sie mindestens eine weitere Abfrage über mindestens drei Tabellen! 
SELECT DISTINCT
    studenten.name, professoren.raum
FROM
    (((studenten
        INNER JOIN
    pruefen ON studenten.MatrNr = pruefen.MatrNr)
        INNER JOIN
    vorlesung ON pruefen.VorlNr = vorlesung.VorlNr)
        INNER JOIN
    professoren ON vorlesung.gelesen_von = professoren.persNr)
WHERE
    studenten.MatrNr = 28106;