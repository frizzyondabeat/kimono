/**
 * Token API and CashOut API
 * @author Efeoghene Isaiah Omonigho
 * **/
package com.globalaccelerex.kimono;

import com.globalaccelerex.kimono.model.cashout.request.TransferRequest;
import com.globalaccelerex.kimono.model.cashout.response.FailedResponse;
import com.globalaccelerex.kimono.model.cashout.response.SucessResponse;
import com.globalaccelerex.kimono.model.token.request.TerminalInformation;
import com.globalaccelerex.kimono.model.token.request.TokenPassportRequest;
import com.globalaccelerex.kimono.model.token.response.TokenPassportResponse;
import com.sun.istack.logging.Logger;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Objects;


public class KimonoApplication {

    public static void main(String[] args) throws IOException, JAXBException {
        Logger logger = Logger.getLogger(KimonoApplication.class);
        OkHttpClient client = new OkHttpClient();
        TokenPassportRequest tokenPassportRequest = TokenPassportRequest.builder()
                .terminalInformation(TerminalInformation.builder()
                        .terminalId(20390007)
                        .merchantId(203900000000007L)
                        .build())
                .build();
        String requestXML = (
                """
                <transferRequest>
                    <terminalInformation>
                        <batteryInformation>100</batteryInformation>
                        <currencyCode>566</currencyCode>
                        <languageInfo>EN</languageInfo>
                        <merchantId>203900000000007</merchantId>
                        <merhcantLocation>ABCD STATE GOVERNMENT ON LANG</merhcantLocation>
                        <posConditionCode>00</posConditionCode>
                        <posDataCode>510101511344101</posDataCode>
                        <posEntryMode>051</posEntryMode>
                        <posGeoCode>00234000000000566</posGeoCode>
                        <printerStatus>1</printerStatus>
                        <terminalId>20390007</terminalId>
                        <terminalType>22</terminalType>
                        <transmissionDate>2020-09-18T10:52:26</transmissionDate>
                        <uniqueId>3H661643</uniqueId>
                    </terminalInformation>
                    <cardData>
                        <cardSequenceNumber>01</cardSequenceNumber>
                        <emvData>
                            <AmountAuthorized>000000000001</AmountAuthorized>
                            <AmountOther>000000000000</AmountOther>
                            <ApplicationInterchangeProfile>3900</ApplicationInterchangeProfile>
                            <atc>04A0</atc>
                            <Cryptogram>12345678909876</Cryptogram>
                            <CryptogramInformationData>80</CryptogramInformationData>
                            <CvmResults>440302</CvmResults>
                            <iad>0110A7C003020000E87C00000000000000FF</iad>
                            <TransactionCurrencyCode>566</TransactionCurrencyCode>
                            <TerminalVerificationResult>0000008000</TerminalVerificationResult>
                            <TerminalCountryCode>566</TerminalCountryCode>
                            <TerminalType>22</TerminalType>
                            <TerminalCapabilities>E0F8C8</TerminalCapabilities>
                            <TransactionDate>200806</TransactionDate>
                            <TransactionType>00</TransactionType>
                            <UnpredictableNumber>2E170407</UnpredictableNumber>
                            <DedicatedFileName>A0000000041010</DedicatedFileName>
                        </emvData>
                        <track2>
                            <pan>1234567890123456</pan>
                            <expiryMonth>05</expiryMonth>
                            <expiryYear>19</expiryYear>
                            <track2>1234567890123456D1905201000000000</track2>
                        </track2>
                    </cardData>
                    <originalTransmissionDateTime>2020-09-
                18T10:52:26</originalTransmissionDateTime>
                    <stan>000018</stan>
                    <fromAccount>Savings</fromAccount>
                    <toAccount></toAccount>
                    <minorAmount>1</minorAmount>
                    <receivingInstitutionId>627821</receivingInstitutionId>
                    <surcharge>1075</surcharge>
                    <pinData>
                        <ksnd>605</ksnd>
                        <ksn></ksn>
                        <pinType>Dukpt</pinType>
                        <pinBlock></pinBlock>
                    </pinData>
                    <keyLabel>000006</keyLabel>
                    <destinationAccountNumber>2000000001</destinationAccountNumber>
                    <extendedTransactionType>6103</extendedTransactionType>
                    <retrievalReferenceNumber>000000001234</retrievalReferenceNumber>
                </transferRequest>
                """);
        TransferRequest transferRequestObject = getTransferRequestObject(requestXML);
        logger.info("transferRequestObject: " + transferRequestObject);
        try {
            String xml = marshal(tokenPassportRequest);
            RequestBody requestBody = RequestBody.create(
                    xml,
                    MediaType.parse("application/xml; charset=utf-8")
            );
            Request request = new Request.Builder()
                    .url("https://saturn.interswitchng.com/kimonotms/requesttoken/perform-process")
                    .post(requestBody)
                    .build();
            String responseXML = Objects.requireNonNull(client.newCall(request).execute().body()).string();
            String token = getTokenPassportObjectResponse(responseXML).getToken();
            RequestBody actualRequest = RequestBody.create(requestXML, MediaType.parse("application/xml; charset=utf-8"));
            Request secondRequest = new Request.Builder()
                    .url("https://qa.interswitchng.com/kmw/kimonoservice/amex")
                    .addHeader("Authorization", "Bearer " + token)
                    .addHeader("Accept", "application/xml")
                    .addHeader("Content-Type", "Application/xml")
                    .post(actualRequest)
                    .build();
            String actualResponse = Objects.requireNonNull(client.newCall(secondRequest).execute().body()).string();
            logger.info(actualResponse);
            if (actualResponse.contains("<hostEmvData>"))
                logger.info("Successful Response: \n" + getSuccessfulResponseObject(actualResponse));
            else
                logger.info("Failed Response: \n" + getFailedResponseObject(actualResponse));
        } catch (JAXBException e) {
            logger.info(e.getMessage());
        }
    }

    public static TokenPassportResponse getTokenPassportObjectResponse(String responseXML) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TokenPassportResponse.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (TokenPassportResponse) unmarshaller.unmarshal(new StringReader(responseXML));
    }

    public static TransferRequest getTransferRequestObject(String requestXML) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TransferRequest.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (TransferRequest) unmarshaller.unmarshal(new StringReader(requestXML));
    }

    public static SucessResponse getSuccessfulResponseObject(String responseXML2) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(SucessResponse.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (SucessResponse) unmarshaller.unmarshal(new StringReader(responseXML2));
    }

    public static FailedResponse getFailedResponseObject(String responseXML) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(FailedResponse.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (FailedResponse) unmarshaller.unmarshal(new StringReader(responseXML));
    }

    public static String marshal(TokenPassportRequest tokenPassportRequest)
            throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(TokenPassportRequest.class);
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(tokenPassportRequest, writer);
        writer.flush();
        writer.close();
        return stringWriter.toString();
    }
}
