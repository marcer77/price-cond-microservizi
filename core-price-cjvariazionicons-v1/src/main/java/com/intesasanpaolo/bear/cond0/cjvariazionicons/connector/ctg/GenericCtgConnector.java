package com.intesasanpaolo.bear.cond0.cjvariazionicons.connector.ctg;

import com.intesasanpaolo.bear.connector.ctg.BaseCtgConnector;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgRequestTransformer;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

import connector.ConnectorClient;

public class GenericCtgConnector<I, O, C extends ConnectorClient>
		extends BaseCtgConnector<I, O, C> {

	public O perform(I input, ICtgRequestTransformer<I, C> requestTransformer,
			ICtgResponseTransformer<C, O> responseTransformer, Object... args) {
		return super.call(input, requestTransformer, responseTransformer, args);
	}
}
