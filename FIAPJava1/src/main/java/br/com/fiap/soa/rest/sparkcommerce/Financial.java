/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.soa.rest.sparkcommerce;
/**
 *
 * @author Alex Costa <alex@deanx.com.br>
 */

import static spark.Spark.setIpAddress;
import static spark.Spark.setPort;

public class Financial {
    private static final String IP_ADDRESS = System.getenv("OPENSHIFT_DIY_IP") != null ? System.getenv("OPENSHIFT_DIY_IP") : "localhost";
    private static final int PORT = System.getenv("OPENSHIFT_DIY_PORT") != null ? Integer.parseInt(System.getenv("OPENSHIFT_DIY_PORT")) : 8080;
    
    public static void main(String[] args) {
        
        setIpAddress(IP_ADDRESS);
        setPort(PORT);
    }
}
