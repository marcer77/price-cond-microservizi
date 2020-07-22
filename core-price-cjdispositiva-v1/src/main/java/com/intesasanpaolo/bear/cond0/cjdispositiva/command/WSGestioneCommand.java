package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.GestioneService;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo.Param;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class WSGestioneCommand extends BaseCommand<NewAccountOutput> {
	private Logger log = Logger.getLogger(WSGestioneCommand.class);

	private HashMap<String, String> headerParams;
	private NewAccountInput newAccountInput;
	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	
	@Autowired
	private GestioneService gestioneService;

	@Override
	public NewAccountOutput execute() throws Exception {
		log.info("- execute START");
		if (canExecute()) {
			log.info("- execute OK");
			
			headerParams = new HashMap<String, String>();
			headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceID", ispWebservicesHeaderType.getRequestInfo().getServiceID());
			headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode", ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
			headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode", ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
			List<Param> listParams = ispWebservicesHeaderType.getAdditionalBusinessInfo().getParam();
			if(listParams!=null && listParams.size()>0) {
				for(Param param : listParams) {
					if(ParamList.COD_ABI.equals(param.getName().COD_ABI)) {
						headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", param.getValue());
					}
					if(ParamList.COD_UNITA_OPERATIVA.equals(param.getName().COD_UNITA_OPERATIVA)) {
						headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa", param.getValue());
					}
				}
			}
			headerParams.put("ISPWebservicesHeader.BusinessInfo.CustomerID", ispWebservicesHeaderType.getBusinessInfo().getCustomerID());
			headerParams.put("ISPWebservicesHeader.OperatorInfo.UserID", ispWebservicesHeaderType.getOperatorInfo().getUserID());
			headerParams.put("ISPWebservicesHeader.RequestInfo.Language", ispWebservicesHeaderType.getRequestInfo().getLanguage());
			headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceVersion", ispWebservicesHeaderType.getRequestInfo().getServiceVersion());
			headerParams.put("ISPWebservicesHeader.RequestInfo.Timestamp", ispWebservicesHeaderType.getRequestInfo().getTimestamp()+"");
			headerParams.put("ISPWebservicesHeader.RequestInfo.TransactionId", ispWebservicesHeaderType.getRequestInfo().getTransactionId());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.ApplicationID", ispWebservicesHeaderType.getTechnicalInfo().getApplicationID());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.CallerProgramName", ispWebservicesHeaderType.getTechnicalInfo().getCallerProgramName());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode", ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());
			
			return gestioneService.gestione(newAccountInput, headerParams);
		} else {
			log.info("- execute ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	@Override
	public boolean canExecute() {
		log.info("- canExecute START");
		boolean esitoControlli = false;

		esitoControlli = (newAccountInput != null) && (ispWebservicesHeaderType != null);
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	public void setHeaderParams(HashMap<String, String> headerParams) {
		this.headerParams = headerParams;
	}

	public void setNewAccountInput(NewAccountInput newAccountInput) {
		this.newAccountInput = newAccountInput;
	}

	public void setIspWebservicesHeaderType(ISPWebservicesHeaderType ispWebservicesHeaderType) {
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

}
