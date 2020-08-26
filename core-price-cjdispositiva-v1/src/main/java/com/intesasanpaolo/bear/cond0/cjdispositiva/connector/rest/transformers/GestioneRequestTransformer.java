package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.transformers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.BankAccountModel;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.ChannelEnum;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.ContractModel;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.ISPUtil;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.InputDatiInputArea;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.InputDatiInputAreaArrayPromo;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.InputDatiInputAreaRapportoAccessorio;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.InputDatiInputAreaRapportoPrincipale;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.InputDatiInputAreaY1CXCHSP;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountDatiInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountXMeSaluteModel;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.PriceModel;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.UserInfoModel;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.UserTypeEnum;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ApplicationConstants;
import com.intesasanpaolo.bear.connector.rest.model.RestConnectorRequest;
import com.intesasanpaolo.bear.connector.rest.transformer.IRestRequestTransformer;



@Component
public class GestioneRequestTransformer implements IRestRequestTransformer<NewAccountInput, NewAccountInput> {

	@Override
	public RestConnectorRequest<NewAccountInput> transform(NewAccountInput request, Object... args) {
		RestConnectorRequest<NewAccountInput> restConnectorRequest = new RestConnectorRequest<>();
		restConnectorRequest.setMethod(HttpMethod.POST);
		_buildHeader(restConnectorRequest, (HashMap<String,String>) args[0]);
		restConnectorRequest.setRequest(buildRequest(request));
		return restConnectorRequest;
	}
	
	private void _buildHeader(RestConnectorRequest<NewAccountInput> restConnectorRequest, HashMap<String,String> headaerParams) {
		restConnectorRequest.addHeader("Content-Type", "application/json");
		restConnectorRequest.addHeader("Accept", "application/json");
		if(headaerParams!=null) {
			for(String key: headaerParams.keySet()) {
				restConnectorRequest.addHeader(key, headaerParams.get(key));
			}
		}
	}
	
    private static NewAccountInput _createNewAccountInput(NewAccountXMeSaluteModel model) {
        ContractModel co = model.getContract();

        NewAccountInput request = new NewAccountInput();
        NewAccountInput.Input input = new NewAccountInput.Input();
        request.setInput(input);
        input.setNumPratica(StringUtils.leftPad(model.getPratica(), 10, "0")!=null ? StringUtils.leftPad(model.getPratica(), 10, "0") : "");
        input.setNumSuperPratica(StringUtils.leftPad(model.getSuperPratica(), 10, "0")!=null ? StringUtils.leftPad(model.getSuperPratica(), 10, "0") : "");

        NewAccountDatiInput datiInput = new NewAccountDatiInput();
        input.setDatiInput(datiInput);
        datiInput.setFunzione("CJX");

        InputDatiInputArea area = new InputDatiInputArea();
        datiInput.setArea(area);
        area.setCodAttributo(co.getProduct().getTechnicalForm());
        area.setTipoServizio("XS");
        area.setCodProdotto(co.getProduct().getProductPriceCode()!=null ? co.getProduct().getProductPriceCode() : "");
        area.setCodFilDipendente(model.getUserInfo().getBranch()!=null ? model.getUserInfo().getBranch() :"");
        area.setDataRiferimento(DateUtils.localDateToString(model.getReferenceDate(), DateUtils.DatePattern.PRICE_GESTIONE)!=null ? DateUtils.localDateToString(model.getReferenceDate(), DateUtils.DatePattern.PRICE_GESTIONE) : "");
        area.setOrigineChiamante("A");
        area.setFlagEntrata("A");
        area.setCodCanale(model.getChannel().getCode());
        int promotion = 0;
        for (PriceModel price : co.getPriceCondition()) {
            if (BooleanUtils.isTrue(price.getSelected()) && StringUtils.isNotBlank(price.getPromotionCode())) {
                InputDatiInputAreaArrayPromo promo = new InputDatiInputAreaArrayPromo();
                promo.setCodPromozione(price.getSubPromotionCode());
                promo.setDataDecoPromR(DateUtils.localDateToString(price.getPromotionStartDate(), DateUtils.DatePattern.PRICE_GESTIONE));
                promo.setDataDecaPromR(DateUtils.localDateToString(price.getPromotionEndDate(), DateUtils.DatePattern.PRICE_GESTIONE));
                area.addArrayPromoItem(promo);
                promotion++;
            }
        }
        area.setNumPromozioni(Integer.toString(promotion));

        // da valorizzare con la chiave del rapporto anagrafico
        InputDatiInputAreaRapportoPrincipale rapportoPrincipale = new InputDatiInputAreaRapportoPrincipale();
        area.setRapportoPrincipale(rapportoPrincipale);
        // dati conto di addebito
        BankAccountModel paymentAccount = co.getPaymentAccount();
        rapportoPrincipale.setNumProgRapp(paymentAccount.getAccountNumber()!=null?paymentAccount.getAccountNumber():"");
        rapportoPrincipale.setFiLRapp(paymentAccount.getBranch()!=null?paymentAccount.getBranch():"");
        rapportoPrincipale.setCaTRapp(paymentAccount.getCategory()!=null?paymentAccount.getCategory():"");

        // da valorizzare con la chiave del conto corrente
        InputDatiInputAreaRapportoAccessorio rapportoAccessorio = new InputDatiInputAreaRapportoAccessorio();

        area.setRapportoAccessorio(rapportoAccessorio);
        co.setRegistryAccountId("0007210001"); //TODO DA VALORIZZARE DINAMICAMENTE
        String[] splitRapporto = ISPUtil.splitRapportoAnagrafe(co.getRegistryAccountId());

        rapportoAccessorio.setFiLRappAcc(splitRapporto[0]);
        rapportoAccessorio.setCaTRappAcc(splitRapporto[1]);
        rapportoAccessorio.setNumProgRappAcc(splitRapporto[2]);
        

        InputDatiInputAreaY1CXCHSP y1 = new InputDatiInputAreaY1CXCHSP();
        area.setY1CXCHSP(y1);
        String userID = model.getUserInfo().getUserID();
        y1.setAbi(model.getAbi() != null ? model.getAbi() : "");
        y1.setSportello(model.getBranchCode() != null ? model.getBranchCode() : "");
        y1.setCanale(model.getUserInfo().getUserType().getTvr());
        y1.setCodIstituto(model.getInstituteCode() != null ? model.getInstituteCode() : "");
        y1.setCodUO(model.getBranchCode() != null ? model.getBranchCode() : "");
        y1.setDataREQ(DateUtils.localDateToString(DateUtils.localDateNow(), DateUtils.DatePattern.PRICE));
        y1.setCodUtente(userID);
        y1.setDatacontabile(DateUtils.localDateToString(model.getContract().getStartValidityDate(), DateUtils.DatePattern.PRICE) != null ? DateUtils.localDateToString(model.getContract().getStartValidityDate(), DateUtils.DatePattern.PRICE) : "");
        
        String branchCode = model.getBranchCode() != null ? model.getBranchCode() : "";
        
        y1.setIdCliente(branchCode + userID.replace("U", "W"));
        y1.setAziendaDest(model.getInstituteCode() != null ? model.getInstituteCode() : "");
        //y1.setTerminale("");
        //y1.setCodRisRich("");
        //y1.setIdServizio(model.getMQQualificator());
        y1.setVersioneServizio("00");
        y1.setTipoLingua("I");
        //y1.setFlagPaperless("");

        y1.setTSID("Prm00" + userID);
        y1.setSSA(ApplicationConstants.APP_SSA);

        return request;
    }
    
    public static NewAccountInput buildRequest(NewAccountInput request) {
    	NewAccountXMeSaluteModel model = new NewAccountXMeSaluteModel();

    	ContractModel contract = new ContractModel();
    	contract.getProduct().setTechnicalForm("");
    	model.setContract(contract);
		model.setChannel(ChannelEnum.SPORTELLO);
    	
		List<PriceModel> priceCondition = new ArrayList<PriceModel>();
		contract.setPriceCondition(priceCondition);
		BankAccountModel paymentAccount = new BankAccountModel();
		contract.setPaymentAccount(paymentAccount);
		
		UserInfoModel userInfoModel = new UserInfoModel();
		userInfoModel.setUserID("");
		userInfoModel.setUserType(UserTypeEnum.FIL);
		model.setUserInfo(userInfoModel);
		
    	NewAccountInput result  = _createNewAccountInput(model);
    	
    	return result;
    }

}
