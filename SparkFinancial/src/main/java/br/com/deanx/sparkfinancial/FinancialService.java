/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deanx.sparkfinancial;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author alex
 */
class FinancialService {

    private Result result = new Result();

    public String getResult(String request) {

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
