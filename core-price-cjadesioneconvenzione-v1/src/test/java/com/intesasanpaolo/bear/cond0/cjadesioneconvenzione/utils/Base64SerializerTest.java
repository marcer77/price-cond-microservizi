package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

@RunWith(SpringRunner.class)
public class Base64SerializerTest {

	@Test
	public void test() throws IOException {
		byte[] bytes = Base64Serializer.serialize("Hello Word!!!");

		JsonFactory factory = new JsonFactory();

		ByteArrayOutputStream st = new ByteArrayOutputStream();
		JsonGenerator generator = factory.createGenerator(st, JsonEncoding.UTF8);
		Base64Serializer base64Serializer = new Base64Serializer();
		base64Serializer.serialize("hello word", generator, null);

		Assert.assertTrue(bytes != null);
		Assert.assertTrue(st != null);

	}

}
