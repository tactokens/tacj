package com.tacplatform.tacj.transactions;

import com.tacplatform.tacj.Signable;
import com.tacplatform.tacj.Transaction;
import com.tacplatform.tacj.WithId;

public interface ReissueTransaction extends Transaction, Signable, WithId {
    public static final byte REISSUE = 5;

    String getAssetId();

    long getQuantity();

    boolean isReissuable();
}
