package com.tacplatform.tacj;

import com.tacplatform.tacj.transactions.TransactionWithBytesHashId;
import org.whispersystems.curve25519.Curve25519;

import java.nio.ByteBuffer;

import static com.tacplatform.tacj.ByteUtils.KBYTE;

public abstract class TransactionWithSignature extends TransactionWithBytesHashId {
    protected ByteString signature;

    public ByteString getSignature() {
        return signature;
    }

    public boolean verifySignature() {
        return Curve25519.getInstance(Curve25519.BEST).verifySignature(getSenderPublicKey().getPublicKey(), getBodyBytes(), signature.getBytes());
    }

    public String getIdStr(){
       return  getId().toString();
    }

    @Override
    public byte[] getBytes() {
        ByteBuffer buf = ByteBuffer.allocate(KBYTE);
        buf.put(getBodyBytes())
                .put(signature.getBytes());
        return ByteArraysUtils.getOnlyUsed(buf);
    }
}
