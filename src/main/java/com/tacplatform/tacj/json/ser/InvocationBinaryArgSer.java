package com.tacplatform.tacj.json.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.tacplatform.tacj.Base64;

import java.io.IOException;

import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;
import static com.tacplatform.tacj.transactions.InvokeScriptTransaction.*;

public class InvocationBinaryArgSer extends StdSerializer<BinaryArg> {

    public InvocationBinaryArgSer() {
        super(BinaryArg.class);
    }

    @Override
    public void serialize(BinaryArg arg, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStringField("type", arg.getType());
        gen.writeStringField("value", Base64.encode(arg.getValue().getBytes()));
    }

    @Override
    public void serializeWithType(BinaryArg value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        WritableTypeId typeId = typeSer.typeId(value, START_OBJECT);
        typeSer.writeTypePrefix(gen, typeId);
        serialize(value, gen, provider);
        typeSer.writeTypeSuffix(gen, typeId);
    }
}
