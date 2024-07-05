package com.saison.omni.common.gupshup.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GupshupApiConfig {
    String baseUrl;
    String userId;
    String password;
    String method;
    String version;
    String format;
    String otpCodeLength;
    String otpCodeType;
    String dltTemplateId;

}
