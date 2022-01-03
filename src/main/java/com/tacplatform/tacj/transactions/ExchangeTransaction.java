package com.tacplatform.tacj.transactions;

import com.tacplatform.tacj.Signable;
import com.tacplatform.tacj.Transaction;
import com.tacplatform.tacj.WithId;
import com.tacplatform.tacj.matcher.Order;

public interface ExchangeTransaction extends Transaction, Signable, WithId  {
    byte EXCHANGE = 7;

    long getAmount();
    long getPrice();
    long getBuyMatcherFee();
    long getSellMatcherFee();
    Order getOrder1();
    Order getOrder2();

}
