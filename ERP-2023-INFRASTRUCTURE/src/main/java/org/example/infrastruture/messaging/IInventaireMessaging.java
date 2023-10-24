package org.example.infrastruture.messaging;

import org.example.infrastruture.messaging.dto.MessageInventaireDto;

public interface IInventaireMessaging {

    void send(MessageInventaireDto payload);
}
