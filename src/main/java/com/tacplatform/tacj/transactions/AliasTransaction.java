package com.tacplatform.tacj.transactions;

import com.tacplatform.tacj.Alias;
import com.tacplatform.tacj.Signable;
import com.tacplatform.tacj.Transaction;
import com.tacplatform.tacj.WithId;

public interface AliasTransaction extends Transaction, Signable, WithId {
    static final byte ALIAS = 10;

    Alias getAlias();
}
