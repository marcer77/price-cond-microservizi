package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ContractModel {
    private Integer id;
    private String branchCode;
    private String branchProvince;
    private LocalDate endValidityDate;
    private LocalDate startValidityDate;
    private InstituteModel institute = new InstituteModel();
    private SubjectModel holder = new SubjectModel();
    private ContractStatusEnum contractStateCode;
    private String contractNumber;
    private String registryAccountId;
    private ProductModel product = new ProductModel();
    private List<AdherentModel> adherents = new ArrayList<>();
    private String priceId;
    private BankAccountModel paymentAccount;
    private List<PriceModel> priceCondition;
    private PaymentTypeEnum paymentType;
    private BillingModeEnum billingMode;
    private List<OwnedProductsModel> ownedProducts;

    private InvoiceDeliveryModel invoiceDelivery;

    private String blockKey;

    public PriceModel getSelectedPrice() {
        for (PriceModel priceModel : priceCondition) {
            if (priceModel.getSelected() != null && priceModel.getSelected()) {
                return priceModel;
            }
        }
        return null;
    }
}
