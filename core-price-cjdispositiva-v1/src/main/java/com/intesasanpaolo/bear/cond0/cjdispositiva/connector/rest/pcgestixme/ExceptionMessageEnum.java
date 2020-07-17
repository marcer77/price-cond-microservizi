package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Getter;

@Getter
public enum ExceptionMessageEnum {

    // CUSTOMER POSITION 01
    E01_ALREADY_UNDER_CONTRACT_HOLDER("0101", "ERROR", "the holder is already in another contract"),
    E01_ALREADY_UNDER_CONTRACT_ADHERENT("0106", "ERROR", "the adherent is already in another contract"),
    W01_WAITING_FOR_SIGNATURE_PROPOSAL_PRESENT_HOLDER("0107", "WARN", "holder there is already an offer waiting to be signed"),
    E01_WAITING_FOR_SIGNATURE_PROPOSAL_PRESENT_ADHERENT("0108", "ERROR", "adherent there is already an offer waiting to be signed"),
    E01_WAITING_FOR_SIGNATURE_PROPOSAL_PRESENT_HOLDER_OTHER_BANK("0109", "ERROR", "holder there is already an offer waiting to be signed in another bank"),
    E01_WAITING_FOR_SIGNATURE_PROPOSAL_PRESENT_ADHERENT_OTHER_BANK("0110", "ERROR", "adherent there is already an offer waiting to be signed in another bank"),
    E01_WAITING_FOR_SIGNATURE_PROPOSAL_PRESENT_HOLDER_WRONG_CHANNEL("0111", "ERROR", "holder there is already an offer waiting to be signed and it can't be discarded from this channel"),
    E01_WRONG_USER_TYPE_FOR_DISPOSITIVA_INVIATA_STATUS("0112", "ERROR", "IB userType is not correct for DISPOSITIVA or INVIATA pratica status"),
    E01_WRONG_IB_USER_TYPE_FOR_VALIDA_STATUS("0113", "ERROR", "IB userType is not correct for VALIDA pratica status"),
    E01_WRONG_USER_TYPE_FOR_VALIDA_STATUS("0114", "ERROR", "FIL or FOL userType are not correct for VALIDA pratica status"),
    W01_ADHERENT_NOT_ACTIVE("0121", "WARN", "adherent not active"),
    W01_ADHERENT_DEACTIVATED("0122", "WARN", "adherent deactivated"),
    W01_ADHERENT_MINOR("0123", "WARN", "adherent minor"),
    W01_ADHERENT_NOT_AUTONOMOUS("0124", "WARN", "adherent not autonomous"),

    // CUSTOMER DATA 02
    E02_OUT_OF_SCOPE_PERSON_NOT_RESIDENT_IN_ITALY("0201", "ERROR", "the person lives abroad"),
    E02_OUT_OF_SCOPE_PERSON_NOT_NATURAL_PERSON("0202", "ERROR", "is not a natural person "),
    E02_OUT_OF_SCOPE_PERSON_MINOR("0203", "ERROR", "the person is minor"),
    E02_OUT_OF_SCOPE_PERSON_NOT_ABLE("0204", "ERROR", "the person is interdict"),
    E02_OUT_OF_SCOPE_PERSO_DISQUALIFIED("0205", "ERROR", "the person is disqualified"),
    E02_BANK_ACCOUNT_NOT_AVAILABLE("0206", "ERROR", "there is not a bank account, it id necessary"),
    W02_PRIVACY_C2_MISSING_WARNING("0212", "WARN", "C2 privacy consent is missing"),
    W02_PRIVACY_C6_MISSING_WARNING("0216", "WARN", "C6 privacy consent is missing"),
    E02_PRIVACY_C6_MISSING_ERROR("0226", "ERROR", "C6 privacy consent is missing"),
    E02_OUT_OF_SCOPE_PERSON_GENERIC("0299", "ERROR", "the person out of scope"),
    W02_MISSING_ACCOUNTS_WARNING("0230", "WARN", "No account found"),
    E02_MISSING_ACCOUNTS_ERROR("0231", "ERROR", "No account found"),
    E02_NO_VALID_ID_DOCUMENT("0232", "ERROR", "No valid document for this customer"),
    E02_NSG_TYPE_NOT_VALID("0233", "ERROR", "NSG type out of scope"),

    // CUSTOMER DIGITAL ID 03
    E03_NO_MULTICHANNEL_CONTRACT_FOUND("0301", "ERROR", "no multichannel contract service found"),
    E03_IB_FDR_MANDATORY("0302", "ERROR", "in IB the FDR signature service is mandatory"),
    E03_OIS_FEA_DFR_MANDATORY("0303", "ERROR", "the signature service is not active"),
    E03_MYKEY_CHANNELS_DISABLED("0304", "ERROR", "contract MyKey with channels mandatory"),
    E03_NO_ACCOUNT_AVAILABLE_FOR_OAD("0305", "ERROR", "no account available for OAD"),

    // CONTRACT DETAIL 11
    E11_NOT_HOLDER_ADHERENT("1101", "ERROR", "the customer is not the holder, cannot do this operation"),

    // CONTRACT PAYMENT LIST
    E12_SUBJECT_NOT_MATCH("1201", "ERROR", "The provided Subject is not valid"),

    // CONTRACT PAYMENT REVERSE
    E13_CHARGE_ALREADY_RETRO("1301", "ERROR", "Operation not allowed"),

    // OPERATIONS AVAILABLE 21
    E21_PRODUCT_NOT_FOUND("2101", "ERROR", "The provided Product is not valid"),
    E21_SUBJECT_NOT_FOUND("2102", "ERROR", "The provided Subject is not valid"),
    E21_CONTRACT_NOT_FOUND("2103", "ERROR", "Contract not found for contract number and product provided"),
    E21_ADHERENT_NOT_FOUND("2104", "ERROR", "Adherent not found for subject and contract number provided"),
    E21_OPERATION_NOT_FOUND("2105", "ERROR", "Operation not found for the contract provided"),
    E21_OPERATION_NOT_VALID("2106", "ERROR", "Operation not valid for the contract provided"),

    // OPERATION OFFER TYPES 22
    E22_NO_OFFER_METHOD_FOR_THIS_CHANNEL("2201", "ERROR", "no offer method available for this channel"),
    E22_PRODUCT_CODE_IS_NOT_VALID("2202", "ERROR", "product code not valid"),

    // OPERATION DISCARD 23
    E23_NOT_VALID_OPERATION("2301", "ERROR", "Not valid operation found"),

    // OperationGet 20
    W20_OPERATION_PENDING_SIGN("2001", "WARN", "Operation pending for signature"),
    E20_NOT_VALID_OPERATION("2002", "ERROR", "Operation not valid/not found"),
    W20_OPERATION_OAD_TO_SEND("2003", "WARN", "The OAD is ready to be sent"),

    //OperationConfirm 25
    E25_OPERATION_CANNOT_BE_CONFIRMED("2501", "ERROR", "Operation cannot be confirmed"),
    W25_ERROR_UPDATE_ADDRESS("2502", "WARN", "Error during subjet address update"),

    //OperationSign
    E27_NO_VALID_OPERATION_FOR_THIS_INPUT("2701", "ERROR", "No valid operation found for the given input"),
    E27_SIGN_NOT_COMPATIBLE_FOR_CHANNEL("2702", "ERROR", "OperationSign not compatible with the given channel"),
    E27_OFFER_TYPE_NOT_COMPATIBLE_FOR_CHANNEL("2703", "ERROR", "Offer type not compatible with the given channel"),
    E27_USED_PROPOSAL("2704", "ERROR", "the proposal is already used and confirmed"),

    //OperationLoadISPAD
    E28_OPERATION_NOT_FOUND("2801", "ERROR", "No valid operation found for the given input"),
    E28_OPERATION_STATUS_INCORRECT("2802", "ERROR", "Operation status incorrect"),
    E28_OPERATION_SIGNATURE_TYPE_INCORRECT("2803", "ERROR", "Operation signature type is not FEA"),
    E28_NO_DOCUMENTS_FOUND("2804", "ERROR", "No documents found"),

    //OperationLoadMPAD
    E29_OPERATION_NOT_FOUND("2901", "ERROR", "No valid operation found for the given input"),
    E29_OPERATION_STATUS_INCORRECT("2902", "ERROR", "Operation status incorrect"),
    E29_OPERATION_SIGNATURE_TYPE_INCORRECT("2903", "ERROR", "Operation signature type is not FDR"),

    // PROPOSAL GET 31
    E31_PROPOSAL_NOT_FOUND("3101", "ERROR", "No valid proposal found"),
    E31_PROPOSAL_TO_SIGNUP("3102", "WARN", "The proposal in contract signature status"),
    E31_PROPOSAL_OAD_TO_SEND("3103", "WARN", "The OAD proposal is ready to be sent"),
    E31_PROPOSAL_OAD_CAN_BE_RECALLED("3104", "WARN", "The OAD proposal can be recalled"),
    E31_PROPOSAL_OFFER_NOT_FOUND("3105", "ERROR", "Modalità di offerta non disponibile per questo canale"),

    // PROPOSAL SAVE 32
    //E32_DOCUMENT_NOT_FOUND("3201", "ERROR", "The document information not found"),
    //E32_SERVICE_CONDITION_NOT_FOUND("3202", "ERROR", "Service condition not found"),
//    E32_DOCUMENT_WFM_NOT_FOUND("3203", "ERROR", "Document into Rud not found"),

    // PROPOSAL DELIVER 33
    //E33_PROPOSAL_NOT_FOUND("3301", "ERROR", "No proposal found from Wfm service"),
    E33_PROPOSAL_STATUS_NOT_VALID("3301", "WARN", "The proposal is in a wrong status"),

    // PROPOSAL ISSUE CONTRACT
//    E36_DOCUMENT_NOT_FOUND("3601", "ERROR", "The document information not found"),
//    E36_RUDMETADATA_NOT_FOUND("3604", "ERROR", "Rud metadata not found"),
//    E36_SERVICE_CONDITION_NOT_FOUND("3602", "ERROR", "Service condition not found"),
    E36_PRODUCT_NOT_FOUND("3603", "ERROR", "Product not found"),
    E36_PROPOSAL_NOT_ACTIVE("3600", "ERROR", "Proposal not active"),

    // PROPOSAL CHECK 34
    E34_LIST_ADHERENT_NOT_EQUAL_ADHERENT_NUMBER("3402", "ERROR", "the number of adherents is different from size of adherent list"), //ok
    E34_DEBIT_ACCOUNT_BRANCHIDCC("3403", "ERROR", "the branch of debit account is null"),                                               //ok
    E34_DEBIT_ACCOUNT_CATEGORY("3403", "ERROR", "the category of debit account is null"),//ok
    E34_DEBIT_ACCOUNT_ACCOUNT_NUMBER("3403", "ERROR", "the account number of debit account is null"),//ok
    E34_DEBIT_ACCOUNT_IBAN("3403", "ERROR", "the iban of debit account is null"),//ok
    E34_DEBIT_ACCOUNT("3403", "ERROR", "The debit account is null"),//ok
    E34_ADHERENT_SUBJECT_FISCAL_CODE("3404", "ERROR", "the fiscal code of adherent is null"),//ok
    E34_INCONSISTENT_FISCAL_CODE("3404", "ERROR", "the fiscal code of adherent is inconsistent"),//ok
    E34_ADHERENT_SUBJECT_MUNICIPALITY_NATION_CODE("3404", "ERROR", "the birthMunicipalityCode or birthNationCode of adherent is null"),//ok
    E34_ADHERENT_SUBJECT_BIRTH_NATION_PROVINCE("3404", "ERROR", "the birthNation and both province and municipality of adherent are null"),//ok
    E34_ADHERENT_SUBJECT_BIRTH_DATE("3404", "ERROR", "the birthDate of adherent is null"),//ok
    E34_ADHERENT_SUBJECT_LAST_NAME("3404", "ERROR", "the lastName of adherent is null"),//ok
    E34_ADHERENT_SUBJECT_NAME("3404", "ERROR", "the name of adherent is null"),//ok
    E34_ADHERENT_SUBJECT_SEX("3404", "ERROR", "the sex of adherent is null"),//ok
    E34_NUMBER_ADHERENT_HOLDER("3405", "ERROR", "the adherent holder are more than one"), //ok
    E34_HOLDER_ABI("3406", "ERROR", "the abi of holder is null"), //ok
    E34_HOLDER_INSTITUTE_CODE("3406", "ERROR", "the institute code of holder is null"),//ok
    E34_HOLDER_BIRTH_NATION("3406", "ERROR", "the birth nation of holder is null"),//ok
    E34_HOLDER_NSG("3406", "ERROR", "the nsg of holder is null"),//ok
    E34_HOLDER_RESIDENCE_MUNICIPALITY("3406", "ERROR", "the residence municipality of holder is null"),//ok
    E34_HOLDER_RESIDENCE_PROVINCE("3406", "ERROR", "the residence province of holder is null"),//ok
    E34_HOLDER_RESIDENCE_ADDRESS("3406", "ERROR", "the residence address of holder is null"),//ok
    E34_HOLDER_RESIDENCE_POSTAL_CODE("3406", "ERROR", "the residence postal code of holder is null"),//ok
    E34_HOLDER_RESIDENCE_MUNICIPALITY_CODE("3406", "ERROR", "the residence municipality code of holder is null"),//ok
    E34_HOLDER_MOBILE_EMAIL("3407", "ERROR", "the mobile and email of holder is empty"),//ok
    //E34_HOLDER_EMAIL("3406", "ERROR", "the email of holder is null"),
    E34_HOLDER_SEX("3406", "ERROR", "the sex of holder is null"),//ok
    //E34_ALL_ADHERENT_ALREADY_UNDER_CONTRACT("3407", "ERROR", "all the adherents is already in another contract"),
    E34_PAPER_INVOICE("3408", "ERROR", "the invoice delivery mode is null"), //ok
    E34_HOLDER_DATA_NOT_VALID("3406", "ERROR", "the provided personal data for holder are not valid"), //ok
    E34_ADHERENT_HOLDER("3409", "ERROR", "list of consent of holder is null"), //ok
    E34_HOLDER_MANDATORY_CONSENT("3410", "ERROR", "the holder has a null mandatory consent"), //ok
    E34_PROPOSAL_NOT_VALID("3401", "ERROR", "The proposal status is not valid any more"), //ok
    E34_PERSONAL_DATA_CONSENT("3411", "ERROR", "The consent SCCON must be true"),//ok
    E34_ALREADY_UNDER_CONTRACT("3401", "ERROR", "The proposal is used for a confirmed contract"), //ok
    E34_ALREADY_UNDER_PENDING_CONTRACT("3401", "ERROR", "The proposal is used for a pending contract"), //ok
    E34_EXPIRED_PROPOSAL("3414", "ERROR", "The proposal expired"), //ok
    E34_ECONOMICS_NOT_VALID("3412", "ERROR", "Price economics were changed and are not valid any more"), //ok
    E34_OFFER_TYPE_NOT_FOUND("3413", "ERROR", "Modalità di offerta non disponibile per questo canale"),

    //PROPOSAL DELIVER_OAD
    E37_OPERATION_NOT_FOUND("3801", "ERROR", "Operation not found for given input"),
    E37_SUPER_PRACTICE_STATUS_NOT_COMPATIBLE("3802", "ERROR", "Super pratice status not compatible"),

    //PROPOSAL RECALL
    E38_OPERATION_NOT_FOUND("3801", "ERROR", "Operation not found for given input"),
    E38_SUPER_PRACTICE_STATUS_NOT_COMPATIBLE("3802", "ERROR", "Super pratice status not compatible"),

    //PROPOSAL REFUSE
    E39_OPERATION_NOT_FOUND("3801", "ERROR", "Operation not found for given input"),
    E39_SUPER_PRACTICE_STATUS_NOT_COMPATIBLE("3802", "ERROR", "Super pratice status not compatible"),

    // PRODUCT DOMAINS 41
    E41_PRODUCT_NOT_FOUND("4101", "ERROR", "product not found"),

    // PRODUCT PRICE 42
    E42_PRODUCT_NOT_VALID("4201", "ERROR", "product info not valid"),

    // SALEABLE PRODUCT 43
    E43_PRODUCT_NOT_SALEABLE("4301", "ERROR", "product is not saleable"),

    // CONTRACT CANCEL TYPES 61
    E61_OPERATION_NOT_ALLOWED("6101", "ERROR", "operation not allowed"),
    E61_NOT_PRODUCT_OPERATION_FOR_CANCEL_CONTRACT("6102", "ERROR", "no cancel type available"),
    E61_PENDING_CANCEL_OPERATION_FOUND("6103", "ERROR", "cancel operation found"),

    // CONTRACT CANCEL DO 62
//    E62_CONTRACT_NOT_FOUND("6201", "ERROR", "Contract not found"),
//    E62_SUBJECT_NOT_MATCH("6202", "ERROR", "Contract holder does not match with the input subject"),
    E62_SUBJECT_IS_NOT_HOLDER("6201", "ERROR", "Subject is not the holder"),
    E62_PRODUCT_OPERATION_NOT_FOUND("6202", "ERROR", "Product operation not found"),
    E62_CONTRACT_OPERATION_NOT_VALID("6203", "ERROR", "Operation type not valid"),

    // CONTRACT UPDATE GET 65
    W65_OPERATION_READY_TO_SIGN("6501", "WARN", "Operation ready to sign"),
    E65_OPERATION_NOT_AVAILABLE("6502", "ERROR", "Operation not available before first fee payment"),
    W65_OPERATION_READY_TO_SIGN_FEA_IB("6503", "WARN", "Operation ready to sign FEA on IB"),

    // CONTRACT UPDATE CHECK 66
    E66_TITOL_MISSING_MAIL_MOBILE("6601", "ERROR", "Titol missing mail and mobile"),
    E66_PRICE_CONDITION_MISMATCH("6602", "ERROR", "Adherent data not match with selected price condition"),
    E66_NOT_VALID_ADHERENT_TYPE("6603", "ERROR", "Adherent type does not match birth data"),
    E66_ADHERENT_NUMBER_MISMATCH("6604", "ERROR", "Adherent number not match"),
    E66_ADHERENT_ALREADY_IN_OTHER_CONTRACT("6605", "ERROR", "Adherent is already in another contract"),
    W66_ADHERENT_RENUMBER("6621", "WARN", "Redistribution index adherents"),

    // CONTRACT REACTIVATION GET 67
    E68_CONTRACT_WRONG_STATUS("6801", "ERROR", "Contract wrong status"),
    E68_SUBJECT_NOT_MATCH("6802", "ERROR", "The provided Subject is not valid"),
    W68_OPERATION_READY_TO_SIGN("6803", "ERROR", "Operation ready to sign"),

    // CONTRACT REACTIVATION CHECK 68
    E69_BANK_ACCOUNT_SIMULATION_FAIL("6901", "ERROR", "Simulation payment fails"),

    E71_ACTIVATION_TO_SIGNUP("7101", "WARN", "The Activation is in signature status"),

    // ADHERENT ACTIVATION CHECK 72
    E72_ADHERENT_MANDATORY_CONSENTS_MISSING("7201", "ERROR", "Adherent mandatory consents not accorded"),
    E72_HOLDER_DELEGATION_NOT_ACCORDED("7202", "ERROR", "Holder delegation not accorded"),
    W72_HOLDER_DELEGATION_NOT_ACCORDED("7222", "WARN", "Holder delegation not accorded"),
    W72_ADHERENT_BANK_ACCOUNT_DISCLOSURE("7223", "WARN", "Bank account disclosure needed for service discount"),

    // ADHERENT CANCEL DO 86
    E86_ADHERENT_NOT_FOUND("8601", "ERROR", "Adherent not found"),
    E86_ADHERENT_ROLE_NOT_MATCH("8602", "ERROR", "Adherent role doesn't match"),
    E86_ADHERENT_NOT_ACTIVE("8603", "ERROR", "Adherent state is not active"),
    E86_CONTRACT_OPERATION_NOT_VALID("8604", "ERROR", "Operation type not valid"),

    E92_CONSENT_MANDATORY_MISSING("9210", "ERROR", "Missing some consent mandatory"),
    E92_CONSENT_C1_MANDATORY("9201", "ERROR", "Consent C1 mandatory"),
    E92_CONSENT_C6_MANDATORY("9202", "ERROR", "Consent C6 mandatory"),
    E92_CONSENT_C2_MANDATORY("9203", "ERROR", "Consent C2 mandatory if offer type is OAD"),
    // GENERIC ERROR 99
    E99_NOT_VALID_OPERATION("9902", "ERROR", "Not valid operation"),

    // ADHERENT PRIVACY GET
    E81_ADHERENT_NOT_FOUND("8101", "ERROR", "Adherent not found for the given input"),

    // ADHERENT PRIVACY CHECK
    E82_ADHERENT_MANDATORY_CONSENTS_MISSING("8201", "ERROR", "Adherent mandatory consents not accorded"),
    E82_HOLDER_DELEGATION_NOT_ACCORDED("8202", "ERROR", "Holder delegation not accorded"),
    W82_HOLDER_DELEGATION_NOT_ACCORDED("8222", "WARN", "Holder delegation not accorded"),
    W82_ADHERENT_BANK_ACCOUNT_DISCLOSURE("8223", "WARN", "Bank account disclosure needed for service discount"),

    // ADHERENT ACCOUNT CHANGE
    E88_ADHERENT_NOT_FOUND("8801", "ERROR", "Adherent not found on the contract"),
    E88_ADHERENT_ROLE_NOT_MATCH("8802", "ERROR", "Adherent role not match"),
    E88_ADHERENT_STATE_NOT_ACTIVE("8803", "ERROR", " Adherent state is not active"),
    E88_OPERATION_NOT_AVAILABLE("8804", "ERROR", "Operation not available"),

    //CONTRACT BRANCH GET
    E18_BRANCH_NOT_FOUND("1801", "ERROR", "Branch not found"),
    E18_NOT_VALID_BRANCH_CODE("1802", "ERROR", "Branch code not valid"),

    //CONTRACT BRANCH UPDATE
    E19_SUBJECT_NOT_MATCH("1901", "ERROR", "The provided Subject is not valid"),
    E19_BRANCH_COLLISION("1902", "ERROR", "Not valid branch"),

//    ADHERENT_ALREADY_UNDER_CONTRACT("210", "ERROR", "the adherent is already in another contract"),
//    NOT_ACTIVABLE("211", "ERROR", "adherent or holder is already active"),

    //activation
    //ALREADY_ACTIVE_ADHERENT("301", "ERROR", "the adherent is already active"),

    //HOLDER_DELEGATION("C01", "ERROR", "the adherent has to delegate the holder"),// db id: 5 not mandatory
    //DATA_TO_ISSC("C02", "ERROR", "the holder has to give ISSC the consent to use the data"),// db id: 6
    //CC_INFO_CONSENT("C03", "ERROR", "The adherent has to give the holder the right to see current account open or close into the group operations"),// db id: 7 not mandatory
    //PRIVACY_ISSC("C04", "ERROR", "The privacy consent is to be given to ISSC"),// db id: 8 not mandatory

    //WARNING_NO_MULTICHANNEL_CONTRACT_FOUND("504", "WARNING", "no multichannel or without channels contract found"),

    E900_VALIDATION_ERROR_REQUEST("900", "ERROR", "Error in request validation fields"),
    E900_VALIDATION_ERROR_RESPONSE("901", "ERROR", "Error in response validation fields"),

    T999_TECHNICAL_GENERIC_PROBLEM("999", "ERROR", "Generic technical problem");

    private final String errorCode;
    private final String level;
    private final String text;

    ExceptionMessageEnum(String errorCode, String level, String text) {
        this.errorCode = errorCode;
        this.level = level;
        this.text = text;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name())
                .append("(").append(errorCode)
                .append("-").append(level)
                .append("-").append(text)
                .append(")").toString();
    }
}
