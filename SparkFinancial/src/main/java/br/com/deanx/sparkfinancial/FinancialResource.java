/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deanx.sparkfinancial;

import static spark.Spark.post;
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
        post(context + "/result", "application/json", (request, response) -> {
            response.status(201);
            response.type("application/json");
            return service.getResult(request.body());
        });
        
        
    }
    
    
    
}
