/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deanx.sparkfinancial;

/**
 *
 * @author alex
 */
public interface Resource {
    
    default String getResourceContext(String context, String version) {
        return "/".concat(context).concat("/").concat(version).concat("/");
    }
    
    
}
