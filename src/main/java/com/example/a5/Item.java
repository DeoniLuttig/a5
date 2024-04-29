package com.example.a5;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Item {
    private BigDecimal size;

    public static Item newInstance(BigDecimal size) {
        Item item = new Item();
        item.setSize(size);
        return item;
    }
}
