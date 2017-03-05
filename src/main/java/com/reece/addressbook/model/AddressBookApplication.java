package com.reece.addressbook.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AddressBookApplication {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long applicationId;
	
	private String applicationName;
	
	@OneToMany(targetEntity=AddressBook.class, fetch=FetchType.LAZY)
	private List<AddressBook> addressBookList = new ArrayList<AddressBook>();
	
	protected AddressBookApplication(){}
	
	public AddressBookApplication(String appName){
		this.applicationName = appName;
	}
	
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public List<AddressBook> getAddressBookList() {
		return addressBookList;
	}
	public void setAddressBookList(List<AddressBook> addressBookList) {
		this.addressBookList = addressBookList;
	}
	
	public void addAddressBook(AddressBook addressBook){
		addressBookList.add(addressBook);
	}

	public void removeContact(AddressBook addressBook){
		addressBookList.remove(addressBook);
	}
	

	/**
	 * method that combine all the contacts from all the address books and return only unique set of contacts.
	 * 
	 * @return set of unique contact
	 */
	
	public Set<Contact> getDistinctContactsFromAllBook(){
		Set<Contact> distinctContactSet = new HashSet<Contact>();
		addressBookList.forEach(
				addressBook->addressBook.getContactList().forEach(
						contact->distinctContactSet.add(contact)));
		return distinctContactSet;
	}
}
