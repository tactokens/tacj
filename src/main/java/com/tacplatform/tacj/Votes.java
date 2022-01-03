package com.tacplatform.tacj;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tacplatform.tacj.matcher.OrderV1;

public class Votes {
    private int increase;
    private int decrease;

    @JsonCreator
    private Votes(
            @JsonProperty("increase") int increase,
            @JsonProperty("decrease") int decrease) {

        this.increase = increase;
        this.decrease = decrease;
    }

    public int getIncreaseVotes() {
        return increase;
    }

    public int getDecreaseVotes() {
        return decrease;
    }
}
