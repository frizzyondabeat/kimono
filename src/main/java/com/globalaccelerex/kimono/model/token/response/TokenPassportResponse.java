package com.globalaccelerex.kimono.model.token.response;

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
@XmlRootElement(name = "tokenPassportResponse")
public class TokenPassportResponse {
    private int responseCode;
    private String responseMessage;
    private String token;
}
