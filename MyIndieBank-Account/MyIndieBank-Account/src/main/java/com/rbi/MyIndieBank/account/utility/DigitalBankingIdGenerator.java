package com.rbi.MyIndieBank.account.utility;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DigitalBankingIdGenerator implements IdentifierGenerator {

	private static int counter=1011;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
			
		int id = counter++;
		String value ="w_";
		return value +id;
	}

}
