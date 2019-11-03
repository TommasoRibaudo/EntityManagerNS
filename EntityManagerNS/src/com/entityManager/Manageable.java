package com.entityManager;

import java.util.List;
import java.util.Set;

public interface Manageable {

	/**
	 * 
	 * @return the set of the table
	 */
	public List<?> selectAll();
	/**
	 * 
	 * @param id the id of the register
	 * @return the register
	 */
	public Object selectRegister (int id);
	
	/**
	 * UPDATE table_name SET :column = :value WHERE :primaryColumn = :id;
	 * @param primaryColumn the column holding the primary key of the table
	 * @param id the pk of the register to be found and updated
	 * @param column column needed to be updated
	 * @param value new value for the register at the column specified
	 */
	public void update ( Object o );

	/**
	 * 
	 * @param o the object to be deleted
	 */
	public void delete (Object o);
	/**
	 * 
	 * @param o the object to be added
	 */
	public void insert (Object o);
}
