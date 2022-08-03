package com.globalaccelerex.kimono.model.cashout.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
@XmlRootElement(name = "transferResponse")
public class FailedResponse {
    private String description;
    private String field39;
    private String referenceNumber;
    private Long stan;
    private String transactionChannelName;
    private String wasReceive;
    private String wasSend;
}
