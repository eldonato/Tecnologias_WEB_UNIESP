package br.com.tecweb.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper=true)
public class AccountCurrent extends Account{

	private double tax;
	
	public Double sacar(Double value) {
		if (this.balance >= value) {
			this.balance -= value*(1+tax);
		}
		this.transactions.add(createTransaction(this, value, "Saque", LocalDateTime.now()));
		return this.balance;
	}
	

}
