package com.loanwalle.loanwallecollection.data.model.sendOtp

data class ResponseOtp(
    val message: String,
    val otp_code: Int,
    val status: String,
    val user_id: String
)