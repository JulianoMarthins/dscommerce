package br.com.julianomarthins.dscommerce.dto;

public class FieldMessage {

    // Atributos
    private final String fieldName;
    private final String message;


    // Construtores
    public FieldMessage(String fieldName, String message){
        this.fieldName = fieldName;
        this.message = message;
    }

    // Getters
    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
