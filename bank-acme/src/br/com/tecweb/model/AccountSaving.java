package br.com.tecweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)

public class AccountSaving extends Account {

	private double interest;
	
	public void interestReceive() {
		this.balance = this.balance*(interest+1);
	}
	
}
