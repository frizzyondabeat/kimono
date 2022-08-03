package com.globalaccelerex.kimono.model.cashout.request.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "pinData")
public class PinData {
    private Integer ksnd;
    private String ksn;
    private String pinType;
    private String pinBlock;
}
