package fr.bank.interview.service;

import fr.bank.interview.util.Repository;

/**
 * 
 * @author yidoughi
 *
 */

public abstract class Service {

	protected Repository internalDB = Repository.getInstance();

	public Repository getInternalDB() {
		return internalDB;
	}

}
