CREATE SCHEMA if not exists FIATT;

SET MODE DB2;

create table if not exists FIATT.TB59R009 (
	NR_SUPERPRATICA CHAR(10) NOT NULL,
	NR_PRATICA CHAR(10) NOT NULL,
	ID_ENTITA CHAR(5) NOT NULL,
	STATO CHAR(1) NOT NULL,
	PROGR_ENTITA DECIMAL(5,0) NOT NULL,
	PROGR_DATI DECIMAL(5,0) NOT NULL,
	COD_ENTITA CHAR(50) NOT NULL,
	DATI_ENTITA VARCHAR(500) NOT NULL,
	TIPO_AGGIORNAMENTO CHAR(1) NOT NULL,
	COD_OPE_ULT_MODIF CHAR(10) NOT NULL,
	DATA_INSER TIMESTAMP NOT NULL,
	DT_ULT_MODIFICA TIMESTAMP NOT NULL
);

INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','00002','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-29 09:41:55.284','2020-07-29 09:41:55.284');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'SUPER 1234','PRA 123456','00006','D',1,2,'0070010000000547910002001                         ','31.07.202031.12.9999 EUR00000000123875{     USU202007208801025NN','I','PCUSUCJ   ','2020-07-20 14:52:59.007','2020-07-20 14:52:59.576');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'SUPER 1234','PRA 123456','00006','C',2,1,'0070010000000547910002001                         ','19.07.202031.07.2020 EUR00000000123875{     USU202007208801025NN','I','PCUSUCJ   ','2020-07-20 14:52:59.576','2020-07-20 14:52:59.576');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'SUPER 1234','PRA 123456','00006','C',2,2,'0070010000000547910002001                         ','31.07.202031.12.9999 EUR00000000123875{     USU202007208801025NN','I','PCUSUCJ   ','2020-07-20 14:52:59.576','2020-07-20 14:52:59.576');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'SUPER 1234','PRA 123456','00026','C',1,1,'0070010000012777810002001                         ','31RC       CVSCO30.06.201723.07.2020','I','PCUSC4J   ','2020-07-24 14:21:42.950','2020-07-24 14:21:42.950');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','DTADE','N',1,1,'0031683                                           ','1234567890123Biasiolo Daniele                                                      PF   BSLDNL69E04F241I000000000000070010001234567819700101123456789012345678901234567890','I','u0h7129   ','2020-08-17 15:55:09.000','2020-08-17 15:55:09.000');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','00003','A',1,1,'00700100000005749CC1000S0                         ','0950002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 15:04:03.977','2020-07-28 15:04:03.977');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','00003','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:58:11.286','2020-07-28 14:58:11.286');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','00003','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:56:45.915','2020-07-28 14:56:45.915');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','00030','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:56:45.915','2020-07-28 14:56:45.915');

-- KO Nessuna adesione trovata
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655704','00003','A',1,1,'00700100000005749CC1000S0                         ','0960002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 15:04:03.977','2020-07-28 15:04:03.977');

-- OK con NESSUNA covenant da attivare o cessare
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655705','DTADE','A',1,1,'00700100000005749CC1000S0                         ','0970002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 15:04:03.977','2020-07-28 15:04:03.977');

INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655706','DTADE','N',1,1,'0031683                                           ','1234567890123Biasiolo Daniele                                                      PF   BSLDNL69E04F241I000000000000070010001234567819700101123456789012345678901234567890','I','u0h7129   ','2020-08-17 15:55:09.000','2020-08-17 15:55:09.000');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655706','00003','A',1,1,'00700100000005749CC1000S0                         ','1950002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 15:04:03.977','2020-07-28 15:04:03.977');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655706','00003','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:58:11.286','2020-07-28 14:58:11.286');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655706','00003','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:56:45.915','2020-07-28 14:56:45.915');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655706','00030','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:56:45.915','2020-07-28 14:56:45.915');

--Record da cancellare se CJAFF
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','PRUSU' , 'N' , 1 ,1, 111, '', 'I', 'user', CURRENT TIMESTAMP,CURRENT TIMESTAMP);
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','PRUSU' , 'N' , 1 ,1, 171, '', 'I', 'user', CURRENT TIMESTAMP,CURRENT TIMESTAMP);

--Rapporti con tassi Abbattuti
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','00012','C',12,4,'00700100000005479                                 ','0002F000010400000000EUR2020062120221231022100020012020073199991231N0000000012387500                                                         CC1000S','I','PCUSUCJ   ','2020-08-01 01:24:11.707','2020-08-01 01:24:11.707');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','00012','C',12,5,'00700100000005479                                 ','0247F000020400000000EUR2020062120221231022102470012020073199991231P000000000570000206077000%+010000000        ++000604300                   CC1000S','I','PCUSUCJ   ','2020-08-01 01:24:11.708','2020-08-01 01:24:11.708');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655703','00012','C',18,4,'00700100000127778                                 ','0002F000010400000000EUR2020062120221231022100020012020083199991231N0000000012387500                                                         CC1000S','I','PCUSUCJ   ','2020-08-03 14:46:24.449','2020-08-03 14:46:24.449');

--Per annullo
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','00002','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-29 09:41:55.284','2020-07-29 09:41:55.284');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','DTADE','N',1,1,'0031683                                           ','1234567890123Biasiolo Daniele                                                      PF   BSLDNL69E04F241I000000000000070010001234567819700101123456789012345678901234567890','I','u0h7129   ','2020-08-17 15:55:09.000','2020-08-17 15:55:09.000');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','00003','A',1,1,'00700100000005749CC1000S0                         ','0950002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 15:04:03.977','2020-07-28 15:04:03.977');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','00003','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:58:11.286','2020-07-28 14:58:11.286');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','00003','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:56:45.915','2020-07-28 14:56:45.915');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','00030','A',1,1,'00700100000005749CC1000S0                         ','APC0002FN000001000000000000000000000000EUR2020072720201231999','I','PCK1X00D  ','2020-07-28 14:56:45.915','2020-07-28 14:56:45.915');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','PRUSU' , 'N' , 1 ,1, 111, '', 'I', 'user', CURRENT TIMESTAMP,CURRENT TIMESTAMP);
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','PRUSU' , 'N' , 1 ,1, 171, '', 'I', 'user', CURRENT TIMESTAMP,CURRENT TIMESTAMP);
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','00012','C',12,4,'00700100000005479                                 ','0002F000010400000000EUR2020062120221231022100020012020073199991231N0000000012387500                                                         CC1000S','I','PCUSUCJ   ','2020-08-01 01:24:11.707','2020-08-01 01:24:11.707');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','00012','C',12,5,'00700100000005479                                 ','0247F000020400000000EUR2020062120221231022102470012020073199991231P000000000570000206077000%+010000000        ++000604300                   CC1000S','I','PCUSUCJ   ','2020-08-01 01:24:11.708','2020-08-01 01:24:11.708');
INSERT INTO FIATT.TB59R009 (NR_SUPERPRATICA,NR_PRATICA,ID_ENTITA,STATO,PROGR_ENTITA,PROGR_DATI,COD_ENTITA,DATI_ENTITA,TIPO_AGGIORNAMENTO,COD_OPE_ULT_MODIF,DATA_INSER,DT_ULT_MODIFICA) VALUES (
'0001161961','0000655713','00012','C',18,4,'00700100000127778                                 ','0002F000010400000000EUR2020062120221231022100020012020083199991231N0000000012387500                                                         CC1000S','I','PCUSUCJ   ','2020-08-03 14:46:24.449','2020-08-03 14:46:24.449');

