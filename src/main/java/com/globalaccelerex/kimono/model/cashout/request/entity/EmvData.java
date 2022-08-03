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
@XmlRootElement(name = "emvData")
public class EmvData {
    @XmlElement(name = "AmountAuthorized")
    private String amountAuthorized;
    @XmlElement(name = "AmountOther")
    private String amountOther;
    @XmlElement(name = "ApplicationInterchangeProfile")
    private Integer applicationInterchangeProfile;
    private String atc;
    @XmlElement(name = "Cryptogram")
    private Long cryptogram;
    @XmlElement(name = "CryptogramInformationData")
    private Integer cryptogramInformationData;
    @XmlElement(name = "CvmResults")
    private Long cvmResults;
    private String iad;
    @XmlElement(name = "TransactionCurrencyCode")
    private int transactionCurrencyCode;
    @XmlElement(name = "TerminalVerificationResult")
    private String terminalVerificationResult;
    @XmlElement(name = "TerminalCountryCode")
    private Long terminalCountryCode;
    @XmlElement(name = "TerminalType")
    private int terminalType;
    @XmlElement(name = "TerminalCapabilities")
    private String terminalCapabilities;
    @XmlElement(name = "TransactionDate")
    private Long transactionDate;
    @XmlElement(name = "TransactionType")
    private int transactionType;
    @XmlElement(name = "UnpredictableNumber")
    private String unpredictableNumber;
    @XmlElement(name = "DedicatedFileName")
    private String dedicatedFileName;
}
