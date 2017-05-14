/*
	2355 Sehai Fation
	2343 Rentas Nikolas
	2359 Spyrakhs Kwnstantinos
*/

-- Auto to ddl sql arxeio kanei backup th bash dedomenwn

-- indicators table backup
SELECT * INTO OUTFILE '/indicators_backup.txt' FROM indicators;

-- countries table backup
SELECT * INTO OUTFILE 'countries_backup.txt' FROM countries;

-- series table backup
SELECT * INTO OUTFILE '/series_backup.txt' FROM series;

-- private sector data table backup
SELECT * INTO OUTFILE '/private_sector_data_backup.txt' FROM private_sector_data;
