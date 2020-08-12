package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

public class JUnitUtils {

	private Validator validator;

	public JUnitUtils() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	private Logger log = Logger.getLogger(JUnitUtils.class);

	protected <T> Set<ConstraintViolation<T>> validaCampi(T dto) {

		//log.info("Inizio validazione: " + dto.toString());

		Set<ConstraintViolation<T>> violations = validator.validate(dto);

		if (violations != null && violations.size() > 0) {

			for (ConstraintViolation<T> v : violations) {

				//log.error("Input non valido {" + v.getInvalidValue() + "} motivo: " + v.getMessage());

			}

		}

		
		return violations;
	}

}
