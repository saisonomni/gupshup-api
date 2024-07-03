package com.saison.omni.common.gupshup.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendOTPResponse {
    public boolean isSuccess;
    public String errorCode;
    public String errorMessage;
}
