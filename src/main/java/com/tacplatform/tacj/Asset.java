package com.tacplatform.tacj;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public abstract class Asset {
    /**
     * Constant used to represent TAC token in asset transactions.
     */
    public static final String TAC = "TAC";

    public static final long TOKEN = 100*1000*1000L;

    public static final BigDecimal TACLETS_MULT = new BigDecimal(TOKEN);

    public static final long MILLI = 100*1000L;

    public static final int DEFAULT_SCALE = 12;

    public static long toTaclets(double amount) {
        return (TACLETS_MULT.multiply(new BigDecimal(amount, MathContext.DECIMAL64))).longValue();
    }

    public static long toTaclets(long amount) {
        return amount * TOKEN;
    }

    public static long toTaclets(BigDecimal amount) {
        return amount.multiply(TACLETS_MULT).longValue();
    }

    public static BigDecimal fromTaclets(long tacletsAmt) {
        BigDecimal amountBd = new BigDecimal(tacletsAmt);
        return amountBd.divide(TACLETS_MULT, DEFAULT_SCALE, RoundingMode.HALF_DOWN);
    }

    static public String normalize(String assetId) {
        return assetId == null || assetId.isEmpty() ? Asset.TAC : assetId;
    }

    static public boolean isTac(String assetId) {
        return TAC.equals(normalize(assetId));
    }

    static public String toJsonObject(String assetId) {
        return isTac(assetId) ? null : assetId;
    }
}
