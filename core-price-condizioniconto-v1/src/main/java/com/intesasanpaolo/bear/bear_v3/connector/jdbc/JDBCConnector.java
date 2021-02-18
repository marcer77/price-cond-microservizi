package com.intesasanpaolo.bear.bear_v3.connector.jdbc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.bear_v3.dto.CondizioneDeroga;
import com.intesasanpaolo.bear.connector.jdbc.JdbcConnector;


@Service
public class JDBCConnector extends JdbcConnector<String, CondizioneDeroga, Void, CondizioneDeroga> { }
