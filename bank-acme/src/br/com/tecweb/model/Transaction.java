/**
 * 
 */
package br.com.tecweb.model;

import lombok.Data;

/**
 * @author cbgomes
 *
 */
@Data
public class Transaction {

	private Account account;
	private Double value;
	private String typeTransaction;
	private String dataTimeTransaction;
}
