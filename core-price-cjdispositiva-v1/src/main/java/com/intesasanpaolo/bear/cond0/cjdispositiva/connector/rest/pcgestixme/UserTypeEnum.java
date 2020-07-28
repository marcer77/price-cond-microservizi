package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Getter;

public enum UserTypeEnum {

    FIL("FIL", "1", "DM", "ABC", "B", "14", "01"),//filiale
    FOL("FOL", "3", "DM", "CON", "CON", "14", "04"), //filiale online
    IB("IB", "2", "02", "INT", "I", "93", "02"), //internet banking
    APP("APP", "2", "02", "INT", "I", "93", "13"),
    MNT("MNT", "1", "DM", "MNT", "MNT", "14", "01"), // TOFIX minotauro
    GSR("GSR", "23", "DM", "GSR", "GSR", "14", "23"), //gestore remoto
    BATCH("BAT", "", "DM", "SSA", "E", "14", "01"),
    ART("ART", "25", "DM", "CON", "CON", "14", "25");

    @Getter // from the FE, USED TO CALL ALL THE OTHER SERVICE
    private String fe;
    @Getter
    private String wfm;
    @Getter
    private String tvr;
    @Getter
    private String cdmCanaleEvento;
    @Getter
    private String cdmCanaleContratto;
    @Getter
    private String tvrSimulatore;
    @Getter
    private String rud;

    UserTypeEnum(String fe, String wfm, String tvr, String cdmCanaleEvento, String cdmCanaleContratto, String tvrSimulatore, String rud) {
        this.fe = fe;
        this.wfm = wfm;
        this.tvr = tvr;
        this.cdmCanaleEvento = cdmCanaleEvento;
        this.cdmCanaleContratto = cdmCanaleContratto;
        this.tvrSimulatore = tvrSimulatore;
        this.rud = rud;
    }

    public static UserTypeEnum valueOfFe(String value) {
        for (UserTypeEnum channel : UserTypeEnum.values()) {
            if (channel.getFe().equalsIgnoreCase(value)) {
                return channel;
            }
        }
        throw new TechnicalException("UserTypeEnum has not " + value + " fe", "", null);
    }

    public static boolean containsFe(String fe) {
        try {
            UserTypeEnum.valueOfFe(fe);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static UserTypeEnum valueOfWfm(String value) {
        for (UserTypeEnum channel : UserTypeEnum.values()) {
            if (channel.getWfm().equalsIgnoreCase(value)) {
                return channel;
            }
        }
        throw new TechnicalException("UserTypeEnum has not " + value + "wfm", "", null);
    }

    public static UserTypeEnum valueOfTvr(String value) {
        for (UserTypeEnum channel : UserTypeEnum.values()) {
            if (channel.getTvr().equalsIgnoreCase(value)) {
                return channel;
            }
        }
        throw new TechnicalException("UserTypeEnum has not " + value + "tvr", "", null);
    }
}
