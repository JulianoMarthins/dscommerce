package br.com.julianomarthins.dscommerce.dto;

import java.time.Instant;

public class CustomError {

    // Atributos
    private final Instant timestamp;
    private final Integer status;
    private final String error;
    private final String path;


    // Construtor
    public CustomError(Instant timestamp, Integer status, String error, String path){
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    // region Getters
    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
    //endregion
}
