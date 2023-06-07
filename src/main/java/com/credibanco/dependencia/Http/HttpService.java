package com.credibanco.dependencia.Http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import com.credibanco.dependencia.dto.UserDTORequest;



public class HttpService {
	public static HttpEntity getHttpEntity(UserDTORequest userDTORequest) {
		return new HttpEntity(userDTORequest, getHttpHeadersJson());
	}

	public static HttpHeaders getHttpHeadersJson() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/json");

		return headers;
	}

}
