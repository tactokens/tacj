package com.tacplatform.tacj.json.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tacplatform.tacj.matcher.Order;

import java.io.IOException;

public class OrderTypeSer extends JsonSerializer<Order.Type> {
    @Override
    public void serialize(Order.Type type, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(type.toJson());
    }
}
