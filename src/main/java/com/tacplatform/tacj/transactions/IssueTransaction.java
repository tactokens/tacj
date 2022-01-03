package com.tacplatform.tacj.transactions;

import com.tacplatform.tacj.Signable;
import com.tacplatform.tacj.Transaction;
import com.tacplatform.tacj.WithId;

public interface IssueTransaction extends Transaction, Signable, WithId {
    byte ISSUE = 3;

    String getName();

    String getDescription();

    long getQuantity();

    byte getDecimals();

    boolean isReissuable();
}
