package com.tacplatform.tacj.json.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tacplatform.tacj.Alias;

import java.io.IOException;

public class AliasSer extends JsonSerializer<Alias> {
    public AliasSer() {
    }

    @Override
    public void serialize(Alias alias, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(alias.toString());
    }

}
