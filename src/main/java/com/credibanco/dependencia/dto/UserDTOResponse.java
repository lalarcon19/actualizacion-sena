package com.credibanco.dependencia.dto;

	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
	import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonSerialize
	public class UserDTOResponse {

		@JsonProperty("id")
		private Long id;

		@JsonProperty("userName")
		private String userName;

		@JsonProperty("password")
		private String password;
		
		@JsonProperty("cardNumber")
		private String cardNumber;

		public long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		
		public String getPassword() {
			return password;
		}
        
		public void setPassword(String password) {
			this.password = password;
		}

		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
}
