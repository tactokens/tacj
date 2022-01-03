package com.tacplatform.tacj.transactions;

import com.tacplatform.tacj.ByteString;
import com.tacplatform.tacj.Signable;
import com.tacplatform.tacj.Transaction;
import com.tacplatform.tacj.WithId;

public interface TransferTransaction extends Transaction, Signable, WithId, WithRecipient {
    static final byte TRANSFER = 4;

    String getRecipient();

    long getAmount();

    String getAssetId();

    String getFeeAssetId();

    ByteString getAttachment();
}
