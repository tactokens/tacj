package com.tacplatform.tacj.transactions;

import com.tacplatform.tacj.Signable;
import com.tacplatform.tacj.Transaction;
import com.tacplatform.tacj.WithId;

public interface LeaseTransaction extends Transaction, Signable, WithId, WithRecipient {
    static final byte LEASE = 8;

    String getRecipient();

    long getAmount();

    long getFee();

    long getTimestamp();
}
