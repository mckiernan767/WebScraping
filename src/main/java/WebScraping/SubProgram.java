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
public class SubProgram {

    @JsonProperty("field_3")
    String id;
    
    @JsonProperty("field_8")
    private final String ProgramId;
    
    @JsonProperty("field_2")
    private final String name;

    public SubProgram(String ProgramId, String name, String id) {
        this.ProgramId = ProgramId;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgramId() {
        return ProgramId;
    }

    public String getName() {
        return name;
    }
    
    
    
}
