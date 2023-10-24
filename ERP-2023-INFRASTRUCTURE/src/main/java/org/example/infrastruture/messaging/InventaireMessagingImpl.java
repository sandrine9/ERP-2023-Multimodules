package org.example.infrastruture.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.infrastruture.messaging.dto.MessageInventaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InventaireMessagingImpl implements IInventaireMessaging{

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void send(MessageInventaireDto payload) {
        try {
            final String produitToJson=mapper.writeValueAsString(payload);

            jmsTemplate.send("QUEUE_INV_ERP",
                    session -> session.createTextMessage(produitToJson)); // J'envoie un produit dans une file d'attente

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
