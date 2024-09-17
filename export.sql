--------------------------------------------------------
--  File created - pi¹tek-listopada-24-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AAAWYNIKI
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."AAAWYNIKI" 
   (	"IMIE_DB" VARCHAR2(64 BYTE), 
	"HAS£O_DB" VARCHAR2(64 BYTE), 
	"LICZNIK_DB" VARCHAR2(64 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.AAAWYNIKI
SET DEFINE OFF;
Insert into SYSTEM.AAAWYNIKI (IMIE_DB,"HAS£O_DB",LICZNIK_DB) values ('dsadas','a','0');
Insert into SYSTEM.AAAWYNIKI (IMIE_DB,"HAS£O_DB",LICZNIK_DB) values ('dsa','abc','2');
Insert into SYSTEM.AAAWYNIKI (IMIE_DB,"HAS£O_DB",LICZNIK_DB) values ('kamil','zielona cebulka','4');
