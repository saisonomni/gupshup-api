package com.saison.omni.gupshup_api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerifyOTPResponse {
    private boolean isSuccess;
    private String errorCode;
    private String errorMessage;
}
