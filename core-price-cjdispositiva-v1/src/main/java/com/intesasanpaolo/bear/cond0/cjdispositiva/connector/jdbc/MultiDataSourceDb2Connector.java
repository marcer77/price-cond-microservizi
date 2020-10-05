package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MultiDataSourceDb2Connector<OUTPUT, DTO, RESOURCE> 
	extends NamedParameterDb2Connector<List<OUTPUT>, DTO, RESOURCE> {

}