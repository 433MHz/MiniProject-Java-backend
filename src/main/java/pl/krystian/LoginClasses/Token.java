package pl.krystian.LoginClasses;

import org.springframework.stereotype.Component;

@Component
class Token {
	private String generatorResource = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
	
	public String generate() {
		String generatedToken = "";

		for(int i = 0; i<= 128; i++) {
			int temp = (int) (Math.random()*generatorResource.length());
			char randomDigit = generatorResource.charAt(temp);
			generatedToken = generatedToken + randomDigit;
		}
		
		return generatedToken;
	}
}
