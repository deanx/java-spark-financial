/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deanx.sparkfinancial;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alex
 */
class FinancialService {

    private Result result = new Result();

    public String getResult(String request) {
//        List<Item> myItems = new ArrayList<>();
//        Item item1 = new Item("Book 1", new BigDecimal(12.49), 1, true, "book");
//        Item item2 = new Item("Music cd 1", new BigDecimal(14.99), 1, true, "music");
//        Item item3 = new Item("Chocolate bar", new BigDecimal(0.85), 1, true, "food");
//        
//        myItems = Arrays.asList(item1, item2, item3);
//        System.out.println(new Gson().toJson(myItems, List.class));

        result = new Result();
        List<Item> items = new Gson().fromJson(request, new TypeToken<List<Item>>() {
        }.getType());

        items.forEach(i -> processResult(i));
        return new Gson().toJson(result);
    }

    private void processResult(Item item) {
        item.calculatePrice();
        addItemTaxesToTotal(item.getTaxes());
        addItemValueToTotal(item);
        result.getItems().add(item);
    }

    private void addItemTaxesToTotal(BigDecimal itemTaxes) {
        BigDecimal taxes = result.getTaxes();
        result.setTaxes(taxes.add(itemTaxes));
    }

    private void addItemValueToTotal(Item item) {
        BigDecimal total = result.getTotal();
        result.setTotal(total.add(item.getPrice()));
    }
}
