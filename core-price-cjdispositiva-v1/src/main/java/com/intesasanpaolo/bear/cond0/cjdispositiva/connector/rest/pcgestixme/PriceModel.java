package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
public class PriceModel {
    private String priceConditionId;
    private String priceConditionLabel;
    private Integer contractId;
    private BigDecimal grossPremium;
    private BigDecimal noSalePremium;
    private String promotionCode;
    private String subPromotionCode;
    private LocalDate promotionStartDate;
    private LocalDate promotionEndDate;
    private PeriodModel promotionPeriod;
    private String promotionDisclaimer;
    private String promotionContractDisclaimer;
    private String frequency;
    private Boolean selected;
    private ServiceConditionModel serviceCondition;

    // id conditionContract
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PriceModel)) {
            return false;
        }
        PriceModel that = (PriceModel) o;
        return Objects.equals(getPriceConditionId(), that.getPriceConditionId()) &&
                Objects.equals(getPriceConditionLabel(), that.getPriceConditionLabel()) &&
                getGrossPremium().setScale(2, BigDecimal.ROUND_HALF_EVEN).compareTo(
                        that.getGrossPremium().setScale(2, BigDecimal.ROUND_HALF_EVEN)) == 0 &&
                getNoSalePremium().setScale(2, BigDecimal.ROUND_HALF_EVEN).compareTo(
                        that.getNoSalePremium().setScale(2, BigDecimal.ROUND_HALF_EVEN)) == 0 &&
                Objects.equals(getPromotionCode(), that.getPromotionCode()) &&
                Objects.equals(getSubPromotionCode(), that.getSubPromotionCode()) &&
                Objects.equals(getPromotionStartDate(), that.getPromotionStartDate()) &&
                Objects.equals(getPromotionEndDate(), that.getPromotionEndDate()) &&
                Objects.equals(getPromotionPeriod(), that.getPromotionPeriod()) &&
                Objects.equals(getFrequency(), that.getFrequency()) &&
                getSelected() == that.getSelected();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPriceConditionId(), getPriceConditionLabel(), getGrossPremium(), getNoSalePremium(), getPromotionCode(), getSubPromotionCode(), getPromotionStartDate(), getPromotionEndDate(), getPromotionPeriod(), getFrequency(), getSelected());
    }
}
