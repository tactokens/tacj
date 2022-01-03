package com.tacplatform.tacj.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TacJsonMapper extends ObjectMapper {
    private final byte chainId;

    public byte getChainId() {
        return chainId;
    }

    public TacJsonMapper(byte chainId) {
        this.chainId = chainId;
        registerModule(new TacModule(chainId, this));
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
