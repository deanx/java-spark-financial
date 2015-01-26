/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deanx.sparkfinancial;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import spark.ResponseTransformer;

/**
 *
 * @author alex
 */
public class JsonTransformer implements ResponseTransformer {
    private final Gson gson = new Gson();
    
    @Override
    public String render(Object model) throws Exception {
        System.out.println(model);
        return gson.toJson(model);
    }
}
