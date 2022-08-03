package com.globalaccelerex.kimono.model.cashout.request.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cardData")
public class CardData {
    private int cardSequenceNumber;
    @XmlElement(name = "emvData")
    private EmvData emvData;
    @XmlElement(name = "track2")
    private Track2 track2;
}
