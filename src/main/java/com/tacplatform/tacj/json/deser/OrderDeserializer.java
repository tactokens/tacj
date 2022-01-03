package com.tacplatform.tacj.json.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.tacplatform.tacj.json.TacJsonMapper;
import com.tacplatform.tacj.matcher.Order;
import com.tacplatform.tacj.matcher.OrderV1;
import com.tacplatform.tacj.matcher.OrderV2;
import com.tacplatform.tacj.matcher.OrderV3;

import java.io.IOException;

public class OrderDeserializer extends StdDeserializer<Order> {

    private TacJsonMapper objectMapper;

    public OrderDeserializer(TacJsonMapper objectMapper) {
        super(Order.class);
        this.objectMapper = objectMapper;
    }

    @Override
    public Order deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        int version = objectMapper.treeToValue(treeNode.get("version"), Integer.class);

        Class o = null;

        switch (version) {
            case Order.V1:
                o = OrderV1.class;
                break;
            case Order.V2:
                o = OrderV2.class;
                break;
            case Order.V3:
                o = OrderV3.class;
                break;
        }

        return (Order) objectMapper.treeToValue(treeNode, o);
    }
}
