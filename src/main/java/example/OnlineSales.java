package example;

import static example.OnlineSales.Status.*;

public class OnlineSales {

	public static enum Status { FULLPRICE, DISCOUNT, ERROR };

	/**
	 * Determine whether to give a discount for online sales.
	 * Gold customers get a discount above 80 bonus points.
	 * Other customers get a discount above 120 bonus points.
	 *
	 * @param bonusPoints How many bonus points the customer has accumulated
	 * @param goldCustomer Whether the customer is a Gold Customer
	 *
	 * @return
	 * DISCOUNT - give a discount<br>
	 * FULLPRICE - charge the full price<br>
	 * ERROR - invalid inputs
	 */
	public static Status giveDiscount(long bonusPoints, boolean goldCustomer)
	{
		Status rv = FULLPRICE;
		long threshold=120;

		if (bonusPoints<=0)
			rv = ERROR;

		else {
			if (goldCustomer)
				threshold = 80;
			if (bonusPoints>threshold)
				rv=DISCOUNT;
		}

		return rv;
	}

}

// Copyright 2021, Stephen Brown
// MIT License - see license.txt
