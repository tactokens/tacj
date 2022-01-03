package com.tacplatform.tacj.transactions;

import com.tacplatform.tacj.Signable;
import com.tacplatform.tacj.Transaction;
import com.tacplatform.tacj.WithId;

public interface LeaseCancelTransaction extends Transaction, Signable, WithId {
    public static final byte LEASE_CANCEL = 9;

    public String getLeaseId();
}
