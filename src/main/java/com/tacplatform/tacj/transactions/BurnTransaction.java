package com.tacplatform.tacj.transactions;

import com.tacplatform.tacj.Signable;
import com.tacplatform.tacj.Transaction;
import com.tacplatform.tacj.WithId;

public interface BurnTransaction extends Transaction, Signable, WithId {
    static final byte BURN = 6;

    String getAssetId();

    long getAmount();
}
