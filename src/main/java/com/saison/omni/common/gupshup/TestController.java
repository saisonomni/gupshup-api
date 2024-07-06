//package com.saison.omni.common.gupshup;
//
//import com.mashape.unirest.http.exceptions.UnirestException;
//import com.saison.omni.common.gupshup.config.GupshupApiConfig;
//import com.saison.omni.common.gupshup.dto.SendOTPDto;
//import com.saison.omni.common.gupshup.dto.VerifyOTPDto;
//import com.saison.omni.common.gupshup.util.GupShupApiCalls;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TestController {
//    @Value("${service.gupshup.url}")
//    String url;
//    @Value("${service.gupshup.userId}")
//    String userId;
//    @Value("${service.gupshup.password}")
//    String password;
//    @Value("${service.gupshup.method}")
//    String method;
//    @Value("${service.gupshup.version}")
//    String version;
//    @Value("${service.gupshup.format}")
//    String format;
//    @Value("${service.gupshup.otpCodeLength}")
//    String otpCodeLength;
//    @Value("${service.gupshup.otpCodeType}")
//    String otpCodeType;
//    @Value("${service.gupshup.dltTemplateId}")
//    String dltTemplateId;
//    @GetMapping("/test")
//    public String test() throws UnirestException {
//        /*
//          gupshup:
//        * */
//        GupshupApiConfig gupshupApiConfig = GupshupApiConfig.builder()
//                .baseUrl(url)
//                .format(format)
//                .method(method)
//                .otpCodeLength(otpCodeLength)
//                .otpCodeType(otpCodeType)
//                .userId(userId)
//                .password(password)
//                .version(version)
//                .dltTemplateId(dltTemplateId)
//                .build();
//        GupShupApiCalls gupShupApiCalls = new GupShupApiCalls(gupshupApiConfig);
//        SendOTPDto sendOTPDto = SendOTPDto.builder()
//                .phoneNumber("9717362744")
//                .msg("Your OTP for contact number validation is %code% -Flipkart Internet Pvt. Ltd.")
//                .build();
//        gupShupApiCalls.sendOtp(sendOTPDto);
////        VerifyOTPDto verifyOTPDto = VerifyOTPDto.builder()
////                .otpCode("1365")
////                .phoneNumber("9717362744")
////                .build();
////        gupShupApiCalls.verifyOtp(verifyOTPDto);
//        return "hola";
//    }
//}
