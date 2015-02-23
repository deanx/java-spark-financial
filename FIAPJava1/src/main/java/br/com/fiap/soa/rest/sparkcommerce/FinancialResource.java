/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.soa.rest.sparkcommerce;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import static spark.Spark.post;
import static spark.Spark.get;

/**
 *
 * @author alex
 */
class FinancialResource implements Resource {

    private final String context;
    private final FinancialService service;

    public FinancialResource(FinancialService financialService, String version) {
        this.context = getResourceContext("api", version);
        this.service = financialService;

        router();

    }

    private void router() {
        post(context + "/cart-price", "application/json", (Request request, Response response) -> {
            response.status(201);
            response.type("application/json");
            return new Gson().toJson(FinancialService.item.calculateCart());
        });

        get(context + "/shipping-availability", "application/json", (request, response) -> {
            response.status(201);
            response.type("application/json");
            return new Gson().toJson(FinancialService.item.shippingAvaiability());
        });

        post(context + "/final-shipping-info", "application/json", (request, response) -> {
            response.status(201);
            response.type("application/json");
            return new Gson().toJson(FinancialService.item.closeShippingInfo());
        });

        post(context + "/final-price", "application/json", (request, response) -> {
            response.status(201);
            response.type("application/json");
            return new Gson().toJson(FinancialService.item.calculateFinalShippingCost());
        });

        post(context + "/bill", "application/json", (request, response) -> {
            response.status(201);
            response.type("application/json");
            return new Gson().toJson(FinancialService.item.makeBill());
        });

        post(context + "/request", "application/json", (request, response) -> {
            response.status(201);
            response.type("application/json");
            return new Gson().toJson(FinancialService.item.makeRequest());
        });

    }

}
