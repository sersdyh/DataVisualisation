/*
	2355 Sehai Fation
	2343 Rentas Nikolas
	2359 Spyrakhs Kwnstantinos
*/

-- Auto to ddl sql arxeio dhmiourgei tous pinakes kai ta antistoixa kleidia

--
-- Database: `private_sector_schema`
--

-- --------------------------------------------------------

--
-- Table structure for table `series`
--

CREATE TABLE `series` (
  `SeriesCode` varchar(45) NOT NULL,
  `SeriesName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `countries`
--
CREATE TABLE `countries` (
  `CountryCode` varchar(3) NOT NULL,
  `CountryName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `private_sector_data`
--

CREATE TABLE `private_sector_data` (
  `ID` int NOT NULL,
  `SeriesCode` varchar(45) NOT NULL,
  `CountryCode` varchar(3) NOT NULL,
  `YR1967` decimal(16,13) DEFAULT NULL,
  `YR1968` decimal(16,13) DEFAULT NULL,
  `YR1969` decimal(16,13) DEFAULT NULL,
  `YR1970` decimal(16,13) DEFAULT NULL,
  `YR1971` decimal(16,13) DEFAULT NULL,
  `YR1972` decimal(16,13) DEFAULT NULL,
  `YR1973` decimal(16,13) DEFAULT NULL,
  `YR1974` decimal(16,13) DEFAULT NULL,
  `YR1975` decimal(16,13) DEFAULT NULL,
  `YR1976` decimal(16,13) DEFAULT NULL,
  `YR1977` decimal(16,13) DEFAULT NULL,
  `YR1978` decimal(16,13) DEFAULT NULL,
  `YR1979` decimal(16,13) DEFAULT NULL,
  `YR1980` decimal(16,13) DEFAULT NULL,
  `YR1981` decimal(16,13) DEFAULT NULL,
  `YR1982` decimal(16,13) DEFAULT NULL,
  `YR1983` decimal(16,13) DEFAULT NULL,
  `YR1984` decimal(16,13) DEFAULT NULL,
  `YR1985` decimal(16,13) DEFAULT NULL,
  `YR1986` decimal(16,13) DEFAULT NULL,
  `YR1987` decimal(16,13) DEFAULT NULL,
  `YR1988` decimal(16,13) DEFAULT NULL,
  `YR1989` decimal(16,13) DEFAULT NULL,
  `YR1990` decimal(16,13) DEFAULT NULL,
  `YR1991` decimal(16,13) DEFAULT NULL,
  `YR1992` decimal(16,13) DEFAULT NULL,
  `YR1993` decimal(16,13) DEFAULT NULL,
  `YR1994` decimal(16,13) DEFAULT NULL,
  `YR1995` decimal(16,13) DEFAULT NULL,
  `YR1996` decimal(16,13) DEFAULT NULL,
  `YR1997` decimal(16,13) DEFAULT NULL,
  `YR1998` decimal(16,13) DEFAULT NULL,
  `YR1999` decimal(16,13) DEFAULT NULL,
  `YR2000` decimal(16,13) DEFAULT NULL,
  `YR2001` decimal(16,13) DEFAULT NULL,
  `YR2002` decimal(16,13) DEFAULT NULL,
  `YR2003` decimal(16,13) DEFAULT NULL,
  `YR2004` decimal(16,13) DEFAULT NULL,
  `YR2005` decimal(16,13) DEFAULT NULL,
  `YR2006` decimal(16,13) DEFAULT NULL,
  `YR2007` decimal(16,13) DEFAULT NULL,
  `YR2008` decimal(16,13) DEFAULT NULL,
  `YR2009` decimal(16,13) DEFAULT NULL,
  `YR2010` decimal(16,13) DEFAULT NULL,
  `YR2011` decimal(16,13) DEFAULT NULL,
  `YR2012` decimal(16,13) DEFAULT NULL,
  `YR2013` decimal(16,13) DEFAULT NULL,
  `YR2014` decimal(16,13) DEFAULT NULL,
  `YR2015` decimal(16,13) DEFAULT NULL,
  `YR2016` decimal(16,13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Indexes for table `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`CountryCode`);

--
-- Indexes for table `private_sector_data`
--
ALTER TABLE `private_sector_data`
  ADD PRIMARY KEY (`SeriesCode`),
  ADD KEY `CountryCodeFK` (`CountryCode`);

--
-- Indexes for table `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`SeriesCode`);

--
-- Constraints for table `private_sector_data`
--
ALTER TABLE `private_sector_data`
  ADD CONSTRAINT `CountryCodeFK` FOREIGN KEY (`CountryCode`) REFERENCES `countries` (`CountryCode`) ON UPDATE CASCADE,
  ADD CONSTRAINT `SeriesCodeFK` FOREIGN KEY (`SeriesCode`) REFERENCES `series` (`SeriesCode`) ON UPDATE CASCADE;
