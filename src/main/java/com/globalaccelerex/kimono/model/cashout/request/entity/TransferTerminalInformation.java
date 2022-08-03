package com.globalaccelerex.kimono.model.cashout.request.entity;

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
@XmlRootElement(name = "terminalInformation")
public class TransferTerminalInformation {
    private Integer terminalId;
    private Long merchantId;
    private int batteryInformation;
    private int currencyCode;
    private String languageInfo;
    private String merchantLocation;
    private int posConditionCode;
    private Long posDataCode;
    private int posEntryMode;
    private Long posGeoCode;
    private int printerStatus;
    private int terminalType;
    private String transmissionDate;
    private String uniqueId;
}
