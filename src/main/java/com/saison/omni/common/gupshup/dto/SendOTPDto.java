package com.saison.omni.common.gupshup.dto;

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
