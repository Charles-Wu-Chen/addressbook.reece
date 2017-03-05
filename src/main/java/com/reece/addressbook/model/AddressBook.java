package com.reece.addressbook.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.log4j.Logger;


/*
 * The Address book model. Can be used as Table mapping with hiberate if need to.
 * The necessary function will be in AddressBookService class
 */
@Entity
public class AddressBook {
	
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(AddressBook.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressBookId;
	
	private String addressBookName;
	
	//Initialize an empty contact set
	//Assume no duplicate in contact.  using set to avoid duplicate contact based on the contact object hash value. 
	
	@OneToMany(targetEntity=Contact.class,  fetch=FetchType.LAZY)
	private Set<Contact> contactList = new HashSet<Contact>();
	
	protected AddressBook (){}
	
	public AddressBook (String name){
		this.addressBookName = name;	
	}
	
	public String getAddressBookName() {
		return addressBookName;
	}
	public void setAddressBookName(String name) {
		addressBookName = name;
	}
	public Set<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(Set<Contact> contactList) {
		this.contactList = contactList;
	}
	
	public void addContact(Contact contact){
		contactList.add(contact);
	}

	public void removeContact(Contact contact){
		contactList.remove(contact);
	}
	

	/**
	 * method that print all contact in this address book.
	 * 
	 * 
	 */
	public void printAllContact(){
		contactList.forEach(contact->logger.info(contact));
	}
	
	
}
