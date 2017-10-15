/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.eyebeacon.model;

import java.io.Serializable;

/**
 * Display client errors as JSON for consistancy
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
public class ClientError implements Serializable {
    
    private String errorMessage;
    
    public ClientError(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
}
