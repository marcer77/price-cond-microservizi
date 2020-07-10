package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class Base64Serializer extends StdSerializer<String> {

    private static final long serialVersionUID = 1L;

    
    public Base64Serializer() {
    	 super(String.class);
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider arg2) throws IOException {
        String ecnodedOutput = Base64.getEncoder().encodeToString(serialize(value));
        jsonGenerator.writeString(ecnodedOutput);
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }


}
