package com.saison.omni.common.gupshup.util;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.saison.omni.common.gupshup.config.GupshupApiConfig;
import com.saison.omni.common.gupshup.constants.QueryParamConstants;
import com.saison.omni.common.gupshup.dto.SendOTPDto;
import com.saison.omni.common.gupshup.dto.VerifyOTPDto;
import com.saison.omni.common.gupshup.response.SendOTPResponse;
import com.saison.omni.common.gupshup.response.VerifyOTPResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class GupShupApiCalls {
    GupshupApiConfig gupshupApiConfig;
    Logger logger = LoggerFactory.getLogger(GupShupApiCalls.class);
    String timeStamp ;
    public GupShupApiCalls(GupshupApiConfig gupshupApiConfig){
        this.gupshupApiConfig = gupshupApiConfig;
    }
    public SendOTPResponse sendOtp(SendOTPDto sendOTPDto) throws UnirestException {
        timeStamp = String.valueOf(new Date().getTime());
        String url = gupshupApiConfig.getBaseUrl();
        logger.info("inside sendOtp method with data : {}",sendOTPDto);
        long timeBeforeApiCall = System.currentTimeMillis();
        String response = Unirest.get(url)
                .queryString(QueryParamConstants.userid,gupshupApiConfig.getUserId())
                .queryString(QueryParamConstants.password,gupshupApiConfig.getPassword())
                .queryString(QueryParamConstants.method,gupshupApiConfig.getMethod())
                .queryString(QueryParamConstants.v,gupshupApiConfig.getVersion())
                .queryString(QueryParamConstants.phone_no,sendOTPDto.getPhoneNumber())
                .queryString(QueryParamConstants.msg,sendOTPDto.getMsg())
                .queryString(QueryParamConstants.format,gupshupApiConfig.getFormat())
                .queryString(QueryParamConstants.otpCodeLength,gupshupApiConfig.getOtpCodeLength())
                .queryString(QueryParamConstants.otpCodeType,gupshupApiConfig.getOtpCodeType())
                .queryString(QueryParamConstants.dltTemplateId,gupshupApiConfig.getDltTemplateId())
                .asObject(String.class)
                .getBody();
        long timeAfterApiCall = System.currentTimeMillis();
        logger.info("response : {} , timeforAPI : {} ms",response,timeAfterApiCall-timeBeforeApiCall);
        String[] parts = response.split("\\|");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        if(parts.length>0){
            if(parts[0].compareToIgnoreCase("success")==0){
                return SendOTPResponse.builder()
                        .isSuccess(true)
                        .build();
            }
            else{
                return SendOTPResponse.builder()
                        .errorCode(parts[1])
                        .errorMessage(parts[2])
                        .build();
            }
        }
        return SendOTPResponse.builder()
                .isSuccess(false)
                .build();
    }

    public VerifyOTPResponse verifyOtp(VerifyOTPDto verifyOTPDto) throws UnirestException {
        timeStamp = String.valueOf(new Date().getTime());
        String url = gupshupApiConfig.getBaseUrl();
        logger.info("inside verifyOtp method with data : {}",verifyOTPDto);
        long timeBeforeApiCall = System.currentTimeMillis();
        String response = Unirest.get(url)
                .queryString(QueryParamConstants.userid,gupshupApiConfig.getUserId())
                .queryString(QueryParamConstants.password,gupshupApiConfig.getPassword())
                .queryString(QueryParamConstants.method,gupshupApiConfig.getMethod())
                .queryString(QueryParamConstants.v,gupshupApiConfig.getVersion())
                .queryString(QueryParamConstants.phone_no,verifyOTPDto.getPhoneNumber())
                .queryString(QueryParamConstants.otpCode,verifyOTPDto.getOtpCode())
                .asObject(String.class)
                .getBody();
        long timeAfterApiCall = System.currentTimeMillis();
        logger.info("response : {} , timeforAPI : {} ms",response,timeAfterApiCall-timeBeforeApiCall);
        String[] parts = response.split("\\|");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        if(parts.length>0){
            if(parts[0].compareToIgnoreCase("success")==0){
                return VerifyOTPResponse.builder()
                        .isSuccess(true)
                        .build();
            }
            else{
                return VerifyOTPResponse.builder()
                        .errorCode(parts[1])
                        .errorMessage(parts[2])
                        .build();
            }
        }
        return VerifyOTPResponse.builder()
                .isSuccess(false)
                .build();
    }
}
