/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraping;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Eoin
 */
public class Program {
    
    String id;
    
    @JsonProperty("field_1")
    private final String number;

    public Program(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }
    
    
    
}
