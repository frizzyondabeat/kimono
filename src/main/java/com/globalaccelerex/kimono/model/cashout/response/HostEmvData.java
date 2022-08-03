package com.globalaccelerex.kimono.model.cashout.response;

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
@XmlRootElement(name = "hostEmvData")
public class HostEmvData {
    @XmlElement(name = "AmountAuthorized")
    private String amountAuthorized;
    @XmlElement(name = "AmountOther")
    private String amountOther;
    private String atc;
    private String iad;
    private Integer rc;
}
