package com.spring.test.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PayConfirmController {

   @PostMapping("/pay/confirm")
   public void confirm(@RequestBody Map<String,Object> param) {
      log.info("iamport callback param=>{}",param);
   }
   
   public static void main(String[] args) {
	   
	   
	   IamportClient client = new IamportClient("2807716025317744", "de7bd1901dca0eb283d3e359f482906a5c33a843f904c05bedf3e4aa16bb147d8c6051c224b98203");
	   
	   try {
			IamportResponse<Payment> response = client.paymentByImpUid("imp_608413808447");
			Payment payment = response.getResponse();
			
		    log.info("payment =>{}", payment.getAmount());
		    //취소
		    if(!payment.getAmount().equals(new BigDecimal(100))) {
		    	CancelData cd = new CancelData("imp_608413808447", true);
		    	IamportResponse<Payment> cPayment = client.cancelPaymentByImpUid(cd);
		    	log.info("cancel=> {}", cPayment.getResponse().getCancelAmount());
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IamportResponseException e) {
			e.printStackTrace();
		}
	   
   }
}