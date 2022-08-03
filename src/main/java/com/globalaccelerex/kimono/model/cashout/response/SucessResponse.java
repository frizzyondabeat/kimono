package com.globalaccelerex.kimono.model.cashout.response;

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
@XmlRootElement(name = "transferResponse")
public class SucessResponse {
    private String description;
    private String field39;
    private String authId;
    @XmlElement
    private HostEmvData hostEmvData;
    private String referenceNumber;
    private String stan;
    private String transactionChannelName;
    private String wasReceive;
    private String wasSend;
}
