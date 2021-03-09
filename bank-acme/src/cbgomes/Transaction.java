/**
 * 
 */
package cbgomes;

import lombok.Getter;
import lombok.Setter;

/**
 * @author cbgomes
 *
 */
@Getter
@Setter
public class Transaction {

	private Account account;
	private Double value;
	private String dateTimeTrasaction;
	private String typeTransaction;
}
