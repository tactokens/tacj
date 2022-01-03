package com.tacplatform.tacj.json.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tacplatform.tacj.Base58;
import com.tacplatform.tacj.PublicKeyAccount;

import java.io.IOException;

public class PublicKeyAccountSer extends JsonSerializer<PublicKeyAccount> {
    public PublicKeyAccountSer() {
    }

    @Override
    public void serialize(PublicKeyAccount publicKeyAccount, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(Base58.encode(publicKeyAccount.getPublicKey()));
    }
}
