CREATE SEQUENCE SSN_ID_SEQ
START WITH 1000;
--INCREAMENT BY 1;

commit;

CREATE TABLE SSN_MASTER(
SSN_ID Number(20) primary key,
FIRST_NAME VARCHAR(20),
LAST_NAME VARCHAR(20),
GENDER VARCHAR(5),
DOB DATE,
STATE VARCHAR(10)
);

CREATE TABLE STATE_MASTER(
STATE_ID INT (5) primary key,
STATE_NAME VARCHAR(20),
AREA_CODE INT (5)
);

