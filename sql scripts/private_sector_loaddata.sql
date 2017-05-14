/*
	2355 Sehai Fation
	2343 Rentas Nikolas
	2359 Spyrakhs Kwnstantinos
*/

-- Auto to ddl sql arxeio fortwnei ta dedomena apo ta .csv arxeia sthn bash dedomenwn

-- load indicators data: Series code, Indicator name, Long definition, Source
LOAD DATA INFILE 'C://users/Dinos/Desktop/indicator_data_import.csv' INTO TABLE indicators
FIELDS TERMINATED BY ','
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

-- load eurozone countries data: Country code, Country name
LOAD DATA INFILE 'C://users/Dinos/Desktop/countries_import.csv' INTO TABLE countries
FIELDS TERMINATED BY ','
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

-- load series data: Series code, Series name
LOAD DATA INFILE 'C://users/Dinos/Desktop/series_import.csv' INTO TABLE series
FIELDS TERMINATED BY ','
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

-- load private sector data: unique ID, Series code, Country code, YR1967...YR2016
LOAD DATA INFILE 'C://users/Dinos/Desktop/main_data_import.csv' INTO TABLE private_sector_data
FIELDS TERMINATED BY ','
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;