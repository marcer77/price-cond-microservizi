package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;

import java.util.Objects;

@Data
public class PeriodModel {
    private Integer year;
    private Integer month;
    private Integer day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PeriodModel)) return false;
        PeriodModel that = (PeriodModel) o;
        return Objects.equals(getYear(), that.getYear()) &&
                Objects.equals(getMonth(), that.getMonth()) &&
                Objects.equals(getDay(), that.getDay());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getYear(), getMonth(), getDay());
    }
}
