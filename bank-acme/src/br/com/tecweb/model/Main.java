/**
 * 
 */
package br.com.tecweb.model;

/**
 * @author cbgomes
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Client client = new Client();
		client.setId(1L);
		client.setName("João da Silva");
		client.setEmail("joaosilva@gmail.com");
		client.setPhone("83 9 9126-7778");
	
		AccountSaving poupanca = new AccountSaving();
		AccountCurrent corrente = new AccountCurrent();
		
		poupanca.setAgency("01");
		poupanca.setBalance(0.0);
		poupanca.setClient(client);
		poupanca.setId(001L);
		poupanca.setInterest(0.05);
		poupanca.setNumber("0101");

		poupanca.depositar(500.0);
		
		System.out.println(poupanca.toString());
	
		corrente.setAgency("02");
		corrente.setBalance(0.0);
		corrente.setClient(client);
		corrente.setId(002L);
		corrente.setTax(0.05);
		corrente.setNumber("0101");
		
		System.out.println(corrente.toString());
		
		poupanca.transferir(corrente, 250.0);
		
		System.out.println(poupanca.toString());
		System.out.println(corrente.toString());

	}

}
