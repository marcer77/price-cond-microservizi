package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.jdbc.oracle;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GenericJdbcConnector<OUTPUT, DTO, RESOURCE>
        extends NamedParameterJdbcConnector<List<OUTPUT>, DTO, RESOURCE> {

}