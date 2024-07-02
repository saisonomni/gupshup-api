package com.saison.omni.gupshup_api.rename;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendOTPDto {
    String phoneNumber;
    String msg;
}
