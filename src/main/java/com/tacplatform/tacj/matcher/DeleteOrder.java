package com.tacplatform.tacj.matcher;

import com.tacplatform.tacj.AssetPair;
import com.tacplatform.tacj.ByteString;
import com.tacplatform.tacj.PrivateKeyAccount;
import com.tacplatform.tacj.PublicKeyAccount;

@Deprecated
public class DeleteOrder extends CancelOrder {
    public DeleteOrder(PrivateKeyAccount sender, AssetPair assetPair, String orderId) {
        super(sender, assetPair, orderId);
    }

    public DeleteOrder(PrivateKeyAccount sender, AssetPair assetPair, long timestamp) {
        super(sender, assetPair, timestamp);
    }

    public DeleteOrder(PublicKeyAccount sender, AssetPair assetPair, String orderId, ByteString signature) {
        super(sender, assetPair, orderId, signature);
    }

    public DeleteOrder(PublicKeyAccount sender, AssetPair assetPair, long timestamp, ByteString signature) {
        super(sender, assetPair, timestamp, signature);
    }
}
