CREATE SCHEMA IF NOT EXISTS COND_OWN;

CREATE TABLE COND_OWN.T_PR_PROPOSTA (
	CD_PROPOSTA_ABI CHAR(5) NOT NULL,
	CD_PROPOSTA_ANNO CHAR(4) NOT NULL,
	CD_PROPOSTA CHAR(7) NOT NULL,
	TS_ULTIMA_MODIFICA TIMESTAMP,
	CD_TABELLA CHAR(10),
	DT_ACCETTAZIONE DATE,
	CD_ACCETTAZIONE_MTR CHAR(26),
	CD_ACCETTAZIONE_UO CHAR(5),
	NI_ALLEGATI TINYINT,
	DT_ATTIVAZIONE DATE,
	CD_ATTIVAZIONE_MTR CHAR(7),
	CD_ATTIVAZIONE_UO CHAR(5),
	DT_AUTORIZZAZIONE DATE,
	CD_AUTORIZZAZIONE_MTR CHAR(7),
	CD_AUTORIZZAZIONE_UO CHAR(5),
	CD_CARICO_UO CHAR(5),
	CD_CONCORDATA CHAR(1),
	DT_CONFERMA DATE,
	CD_CONFERMA_MTR CHAR(7),
	CD_CONFERMA_UO CHAR(5),
	CD_COV_STATO CHAR(1),
	DT_DELIBERA DATE,
	CD_DELIBERA_MTR CHAR(26),
	CD_DELIBERA_MTR_1 CHAR(7),
	CD_DELIBERA_MTR_2 CHAR(7),
	CD_DELIBERA_MTR_3 CHAR(7),
	DS_DELIBERA_NOTE_1 CHAR(760),
	DS_DELIBERA_NOTE_2 CHAR(760),
	DS_DELIBERA_NOTE_3 CHAR(760),
	CD_DELIBERA_UO CHAR(5),
	CD_DESTINAZIONE_UO CHAR(5),
	FL_DIREZIONE_COMMERCIALE CHAR(1),
	DS_EMISSIONE_NOTE CHAR(760),
	CD_EX_AREA CHAR(5),
	FL_ITER_AGGRAVATO CHAR(1),
	CD_ITER_ESITO CHAR(1),
	CD_ITER_FASE CHAR(1),
	DT_ITER_FINE DATE,
	TS_ITER_INIZIO TIMESTAMP,
	CD_ITER_STATO CHAR(1),
	CD_OGGETTO CHAR(2),
	DT_PARERE_1 DATE,
	DS_PARERE_1 CHAR(40),
	DT_PARERE_2 DATE,
	DS_PARERE_2 CHAR(40),
	DT_PARERE_3 DATE,
	DS_PARERE_3 CHAR(40),
	CD_PARERE_MTR_1 CHAR(7),
	CD_PARERE_MTR_2 CHAR(7),
	CD_PARERE_MTR_3 CHAR(7),
	DS_PARERE_NOTE_1 CHAR(760),
	DS_PARERE_NOTE_2 CHAR(760),
	DS_PARERE_NOTE_3 CHAR(760),
	CD_PARERE_UO_1 CHAR(5),
	CD_PARERE_UO_2 CHAR(5),
	CD_PARERE_UO_3 CHAR(5),
	CD_PROFILO_DELIBERANTE CHAR(6),
	CD_PROPONENTE_MTR CHAR(7),
	CD_PROPONENTE_UO CHAR(5),
	FL_PROPOSTA_ACCETTAZIONE CHAR(1),
	FL_PROPOSTA_CLIENTE CHAR(1),
	FL_PROPOSTA_CND CHAR(1),
	FL_PROPOSTA_DBT_CEDUTO CHAR(1),
	CD_PROVENIENZA CHAR(2),
	FL_REALE CHAR(1),
	CD_TIPO CHAR(1),
	NI_VALIDITA_GG TINYINT,
	FL_PROPOSTA_CND_ACCESSORIA CHAR(1),
	FL_PROPOSTA_TESTO CHAR(1),
	NR_EVA_RELAZIONE TINYINT,
	DS_MSG_CLIENTE CHAR(100),
	CD_NDG_CLUSTER CHAR(2),
	FL_PROPOSTA_EARNIX CHAR(1),
	TS_MODIFICA_BATCH TIMESTAMP,
	CD_COV_PRESENZA CHAR(1),
	FL_PROPOSTA_CORPORATE CHAR(1),
	FL_DIPARTIMENTALE CHAR(1),
	CD_GRM_CARICO_MTR CHAR(7),
	CD_GRM_DESTINAZIONE_MTR CHAR(7),
	CD_PRATICA_PRESENZA CHAR(1),
	DT_ELIMINA DATE,
	CD_ELIMINA_MTR CHAR(7),
	CD_ELIMINA_UO CHAR(5),
	FL_PROPOSTA_VI_PERIMETRO CHAR(1),
	FL_PROPOSTA_FCT_MCS CHAR(1),
	CONSTRAINT CONSTRAINT_D PRIMARY KEY (CD_PROPOSTA_ABI,CD_PROPOSTA_ANNO,CD_PROPOSTA)
);
CREATE UNIQUE INDEX PRIMARY_KEY_D ON T_PR_PROPOSTA (CD_PROPOSTA_ABI,CD_PROPOSTA_ANNO,CD_PROPOSTA);