/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.eyebeacon.model;

import java.io.Serializable;

/**
 * Save client errors in an object to make sure they are displayed as JSON
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
public class ClientError implements Serializable {

    private String errorMessage; // The message to show

    /**
     * Create the message
     *
     * @param errorMessage
     */
    public ClientError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
