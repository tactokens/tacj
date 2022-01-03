package com.tacplatform.tacj.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tacplatform.tacj.ByteString;
import com.tacplatform.tacj.Transaction;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static com.tacplatform.tacj.ByteUtils.hash;

public abstract class TransactionWithBytesHashId implements Transaction {
    @JsonProperty(value = "height", access = WRITE_ONLY)
    private int height;

    public ByteString getId() {
        return new ByteString(hash(getBodyBytes()));
    }

    public int getHeight() {
        return height;
    }
}
