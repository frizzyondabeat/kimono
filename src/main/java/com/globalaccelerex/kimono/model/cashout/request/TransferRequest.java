package com.globalaccelerex.kimono.model.cashout.request;

import com.globalaccelerex.kimono.model.cashout.request.entity.CardData;
import com.globalaccelerex.kimono.model.cashout.request.entity.PinData;
import com.globalaccelerex.kimono.model.cashout.request.entity.TransferTerminalInformation;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@XmlRootElement(name = "transferRequest")
public class TransferRequest {
   @XmlElement(name = "terminalInformation")
   private TransferTerminalInformation terminalInfo;
   @XmlElement(name = "cardData")
   private CardData cardData;
   private String originalTransmissionDateTime;
   private String stan;
   private String fromAccount;
   private String toAccount;
   private Long minorAmount;
   private Long receivingInstitutionId;
   private Long surcharge;
   @XmlElement(name = "pinData")
   private PinData pinData;
   private String keyLabel;
   private Long destinationAccountNumber;
   private Long extendedTransactionType;
   private String retrievalReferenceNumber;
}
