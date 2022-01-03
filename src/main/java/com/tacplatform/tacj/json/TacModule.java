package com.tacplatform.tacj.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.tacplatform.tacj.*;
import com.tacplatform.tacj.json.deser.*;
import com.tacplatform.tacj.json.ser.*;
import com.tacplatform.tacj.matcher.Order;
import com.tacplatform.tacj.transactions.InvokeScriptTransaction;

public class TacModule extends SimpleModule {
    public TacModule(byte chainId, TacJsonMapper objectMapper) {
        addDeserializer(PublicKeyAccount.class, new PublicKeyAccountDeser(chainId));
        addDeserializer(ByteString.class, new ByteStringDeser());
        addDeserializer(Alias.class, new AliasDeser(chainId));
        addDeserializer(Order.Status.class, new OrderStatusDeser());
        addDeserializer(Transaction.class, new TransactionDeserializer(objectMapper));
        addDeserializer(Order.class, new OrderDeserializer(objectMapper));

        addSerializer(PublicKeyAccount.class, new PublicKeyAccountSer());
        addSerializer(ByteString.class, new ByteStringSer());
        addSerializer(Alias.class, new AliasSer());
        addSerializer(AssetPair.class, new AssetPairSer());
        addSerializer(Order.Type.class, new OrderTypeSer());
        addSerializer(InvokeScriptTransaction.BinaryArg.class, new InvocationBinaryArgSer());
    }
}
