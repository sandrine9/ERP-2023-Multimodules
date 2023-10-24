package org.example.infrastruture.messaging.dto;

public class MessageDto {

    private Long idClient;

    private String blocType;

    private String action;

    private String payload;

    public MessageDto(Long idClient, String blocType, String action, String payload) {
        this.idClient = idClient;
        this.blocType = blocType;
        this.action = action;
        this.payload = payload;
    }

    public MessageDto() {
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getBlocType() {
        return blocType;
    }

    public void setBlocType(String blocType) {
        this.blocType = blocType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
