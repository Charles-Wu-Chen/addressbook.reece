package com.reece.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long contactId;
	
	private String name;
	private String phoneNumber;

	protected Contact(){}
	
	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * method that provides the algorithm to compare 2 contact object.
	 * 
	 * @return boolean for comparison result.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Contact other = (Contact) obj;
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			return false;
		}
		if ((this.phoneNumber == null) ? (other.phoneNumber != null) : !this.phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		return true;
	}

	/**
	 * method that provides hash code of this contact instance.
	 * 
	 * @return My hash code.
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 19 * hash + (this.name != null ? this.name.hashCode() : 0);
		hash = 19 * hash + (this.phoneNumber != null ? this.phoneNumber.hashCode() : 0);
		return hash;
	}

	/**
	 * method that provides String representation of contact instance.
	 * 
	 * @return My String representation.
	 */
	@Override
	public String toString() {
		return "Contact{" + "id=" + contactId +", Name=" + name + ", Phone Number=" + phoneNumber + "}";
	}

}
