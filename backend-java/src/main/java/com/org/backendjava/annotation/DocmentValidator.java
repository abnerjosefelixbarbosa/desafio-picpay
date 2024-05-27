package com.org.backendjava.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocmentValidator implements ConstraintValidator<Docment, String> {
	
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result = false;
		
		if (isCPF(value) || isCNPJ(value)) {
			result = true;
		}
		
		return result;
	}
	
	
	private boolean isCNPJ(String cnpj) {
		cnpj = cnpj.replaceAll("\\D", "");
		
		if (cnpj.length() != 14)
            return false;
		
		int add = 0;
        int weight = 2;
        for (int i = 11; i >= 0; i--) {
            add += (cnpj.charAt(i) - '0') * weight;
            weight++;
            if (weight == 10)
            	weight = 2;
        }
        int digit1 = 11 - (add % 11);
        if (digit1 > 9)
        	digit1 = 0;
        
        if ((cnpj.charAt(12) - '0') != digit1)
            return false;
        
        add = 0;
        weight = 2;
        for (int i = 12; i >= 0; i--) {
            add += (cnpj.charAt(i) - '0') * weight;
            weight++;
            if (weight == 10)
                weight = 2;
        }
        int digit2 = 11 - (add % 11);
        if (digit2 > 9)
        	digit2 = 0;
        
        if ((cnpj.charAt(13) - '0') != digit2)
            return false;
		
		return true;
	}


	private boolean isCPF(String cpf) {
		cpf = cpf.replaceAll("\\D", "");
		
		if (cpf.length() != 11)
			return false;
		
		int add = 0;
		for (int i = 0; i < 9; i++) {
			add += (cpf.charAt(i) - '0') * (10 - i);
		}
		int digit1 = 11 - (add % 11);
		if (digit1 > 9)
			digit1 = 0;
		
		if ((cpf.charAt(9) - '0') != digit1)
            return false;
		
		add = 0;
        for (int i = 0; i < 10; i++) {
            add += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (add % 11);
        if (digit2 > 9)
        	digit2 = 0;
        
        if ((cpf.charAt(10) - '0') != digit2)
            return false;
	
		return true;
	}
}
