package com.credibanco.dependencia.Utils;

import com.credibanco.dependencia.dto.UserDTORequest;
import com.credibanco.dependencia.dto.UserDTOResponse;

public class NumberCard {

	public static  String  convertNumber (UserDTORequest userDTORequest) {
	userDTORequest.getCardNumber();
	int longitud=userDTORequest.getCardNumber().length();
	int numberLong= longitud-4;
	
	String numberCard = userDTORequest.getCardNumber().substring(0, 2) + String.format("*",numberLong)+ userDTORequest.getCardNumber().substring(longitud-2, longitud);
	
	return numberCard;
	}
}