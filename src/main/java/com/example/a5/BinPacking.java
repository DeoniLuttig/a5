package com.example.a5;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;

public class BinPacking {

    public boolean isValidList(List<Double> sizes) {
        return sizes.stream().noneMatch(size -> size <= 0 || size >= 1);
    }

    public Integer minimumBinsRequired(List<Double> sizes) {
        List<Item> itemsList = new ArrayList<>();
        List<Bin> bins = new ArrayList<>();

        // create list of class Items and first bin
        sizes.forEach(size -> itemsList.add(Item.newInstance(BigDecimal.valueOf(size)))); // set to BigDecimal to fix adding issue being off justa tiny bit
        bins.add(Bin.newInstance());

        for (Item item: itemsList) {
            addToBin(item, bins);
        }
        printBins(bins);
        return bins.size();
    }

    public void run(List<Double> items) {
        System.out.println();
        System.out.println("35-1 Bin packing: first-fit heuristic");
        System.out.print("With a list of items: ");

        System.out.println(items);
        System.out.println();

        //first, check if items list is valid,  0 < si <1
        if (isValidList(items)) {
            System.out.println("Total number of bins used: " + minimumBinsRequired(items));
        } else {
            System.out.println("All items in list are not valid, or 0 < si < 1");
        }
    }

    private void addToBin(Item item, List<Bin> bins) {
        for (Bin bin: bins) {
            if (canAddItemToBin(item, bin)) {
                BigDecimal oldLoad = bin.getLoad();
                bin.getItems().add(item);
                bin.setLoad(oldLoad.add(item.getSize()));
                return; // end when added to bin
            }
        } // else create and set new bin with item
        Bin newBin = Bin.newInstance();
        newBin.getItems().add(item);
        newBin.setLoad(item.getSize());
        bins.add(newBin);
    }

    private boolean canAddItemToBin(Item item, Bin bin) {
        // check item size isn't bigger than remaining room
        return item.getSize().compareTo(bin.getCapacity().subtract(bin.getLoad())) <= 0;
    }

    private void printBins(List<Bin> bins) {
        for (int i = 0; i < bins.size(); i++) {
            System.out.printf("Bin %d contains items with sizes", i + 1);
            bins.get(i).getItems().forEach(item ->  System.out.printf(" '%s',", item.getSize()));
            System.out.println();
        }
    }
}
