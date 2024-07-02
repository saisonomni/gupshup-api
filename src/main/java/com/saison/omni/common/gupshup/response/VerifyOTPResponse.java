package com.saison.omni.common.gupshup.response;

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
