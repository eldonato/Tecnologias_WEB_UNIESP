/**
 * 
 */
package br.com.tecweb.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * @author cbgomes
 *
 */
@Data
public abstract class Account {

	protected Long id;
	protected String number;
	protected String agency;
	protected Double balance;
	protected Client client;
	@ToString.Exclude protected List<Transaction> transactions = new ArrayList<Transaction>();

	public Double sacar(Double value) {
		if (this.balance >= value) {
			this.balance -= value;
		}
		this.transactions.add(createTransaction(this, value, "Saque", LocalDateTime.now()));
		return this.balance;
	}

	public Double depositar(Double value) {
		this.transactions.add(createTransaction(this, value, "Deposito", LocalDateTime.now()));
		return this.balance += value;
	}

	public Double transferir(Account account, Double value) {
		if (this.balance >= value) {
			this.sacar(value);
			account.depositar(value);
		}
		this.transactions.add(createTransaction(this, value, "Transferência", LocalDateTime.now()));
		return this.balance;
	}
	
	public List<Transaction> transacoes(){
		return this.transactions;
	}

	protected Transaction createTransaction(Account account, Double value, String typeTransaction,
			LocalDateTime localDateTime) {
		
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setValue(value);
		transaction.setTypeTransaction(typeTransaction);
		transaction.setDataTimeTransaction(formatDate(LocalDateTime.now()));
		
		return transaction;
	}
	
	
	private String formatDate(LocalDateTime date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateNow = date.format(formatter);

		return dateNow;
	}

}








