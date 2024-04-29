package com.example.a5;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Bin {
    private BigDecimal capacity;
    private BigDecimal load;
    private List<Item> items;

    public static Bin newInstance() {
        Bin bin = new Bin();
        bin.setCapacity(BigDecimal.valueOf(1)); // capacity is set to 1
        bin.setLoad(BigDecimal.valueOf(0));
        bin.items = new ArrayList<>();
        return bin;
    }
}
