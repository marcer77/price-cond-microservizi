CREATE SCHEMA if not exists COND_OWN;

CREATE TABLE "COND_OWN"."T_PC2_ANAG_ISTITUTI" 
   (	"COD_ISTITUTO" CHAR(2) NOT NULL , 
	"COD_ABI" CHAR(5) NOT NULL , 
	"COD_SOCIETA" CHAR(2) NOT NULL , 
	"DES_ISTITUTO" VARCHAR2(40) NOT NULL , 
	"DES_LOGO" VARCHAR2(40), 
	"DES_ISTITUTO_RID" VARCHAR2(10), 
	"DES_RAGIONESOCIALE" VARCHAR2(4000), 
	"IND_CORPORATE" VARCHAR2(1), 
	"URL_TARIFFARIO" VARCHAR2(200), 
	"IND_SERVIZIO_PRICING" VARCHAR2(1), 
	"IND_BDT" VARCHAR2(1), 
	"DES_RAGIONESOCIALE_DE" VARCHAR2(4000), 
	"IND_FACOLTA_PARAM" VARCHAR2(1), 
	 CONSTRAINT "PK_T_PC2_ANAG_ISTITUTI" PRIMARY KEY ("COD_ISTITUTO")
  );
  
INSERT INTO COND_OWN.T_PC2_ANAG_ISTITUTI (COD_ISTITUTO,COD_ABI,COD_SOCIETA,DES_ISTITUTO,DES_LOGO,DES_ISTITUTO_RID,DES_RAGIONESOCIALE,IND_CORPORATE,URL_TARIFFARIO,IND_SERVIZIO_PRICING,IND_BDT,DES_RAGIONESOCIALE_DE,IND_FACOLTA_PARAM) VALUES ('01','01025','01','INTESA SANPAOLO','LogoA_01025.gif','SANPAOLO','Intesa Sanpaolo S.p.A. Sede Legale: Piazza San Carlo, 156 10121 Torino Sede Secondaria: Via Monte di Pietà, 8 20121 Milano Capitale Sociale Euro 9.084.056.582,12 Registro delle Imprese di Torino e Codice Fiscale 00799960158 Partita IVA 10810700152 N. Iscr. Albo Banche 5361 Codice ABI 3069.2 Aderente al Fondo Interbancario di Tutela dei Depositi e al Fondo Nazionale di Garanzia Capogruppo del gruppo bancario "Intesa Sanpaolo" iscritto all''Albo dei Gruppi Bancari','S','http://redo0.sede.corp.sanpaoloimi.com:8585/script2Redo0/redo/redogetcontent?chronicleId=090184c6801dacd3=PUBBLICATO','S','S','prova','S');
