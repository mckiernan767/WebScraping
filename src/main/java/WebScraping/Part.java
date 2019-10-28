/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraping;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

/**
 *
 * @author Eoin
 */
public class Part {
    @JsonProperty("field_5")
    final String partNumber;
    
    @JsonProperty("field_4")
    final String name;
    
    @JsonProperty("field_6")
    final String withdrawalDate;
    
    @JsonProperty("field_7")
    String subProgramId; 

    public Part(String partNumber, String name, String withdrawalDate, String subProgramId) {
        this.partNumber = partNumber;
        this.name = name;
        this.withdrawalDate = withdrawalDate;
        this.subProgramId = subProgramId;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getName() {
        return name;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public String getSubProgramId() {
        return subProgramId;
    }

    
}
