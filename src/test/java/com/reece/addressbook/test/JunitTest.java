package com.reece.addressbook.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.reece.addressbook.model.AddressBook;
import com.reece.addressbook.model.AddressBookApplication;
import com.reece.addressbook.model.Contact;


public class JunitTest {

	final static Logger logger = Logger.getLogger(JunitTest.class);
	
	@Before
	public void init() {

	}

	@Test
	public void testAddContact() {
		logger.info("start testAddContact... ");
		AddressBook book1 = new AddressBook("book1");
		Contact contact1 = new Contact("name1", "+611234567");
		book1.addContact(contact1);

		assertEquals("there shall be 1 contact in the address book", 1, book1.getContactList().size());
		assertTrue("The addressbook shall have the added contact ", book1.getContactList().contains(contact1));
	}
	
	@Test
	public void testRemoveContact() {
		logger.info("start testRemoveContact... ");
		AddressBook book1 = new AddressBook("book1");
		Contact contact1 = new Contact("name1", "+611234567");
		book1.addContact(contact1);
		assertEquals("there shall be 1 contact in the address book", 1, book1.getContactList().size());
		
		book1.removeContact(contact1);
		assertEquals("there shall be 0 contact in the address book", 0, book1.getContactList().size());
		
	}
	
	@Test
	public void testPrintContactsFromAddressBook() {
		logger.info("start testPrintContactsFromAddressBook... ");
		AddressBook book1 = new AddressBook("book1");
		Contact contact1 = new Contact("name1", "+611234567");
		Contact contact2 = new Contact("name2", "+611333333");
		book1.addContact(contact1);
		book1.addContact(contact2);
		
		book1.printAllContact();
	}
	
	@Test
	public void testMultipleAddressBook(){
		logger.info("start testMultipleAddressBook... ");
		AddressBook book1 = new AddressBook("book1");
		Contact contact1 = new Contact("name1", "+611234567");
		book1.addContact(contact1);
		assertEquals("there shall be 1 contact in the address book", 1, book1.getContactList().size());
		
		
		AddressBook book2 = new AddressBook("book2");
		Contact contact2 = new Contact("name2", "+611234567");
		book2.addContact(contact2);
		assertEquals("there shall be 1 contact in the address book", 1, book2.getContactList().size());
		
		AddressBookApplication app = new AddressBookApplication("application1");
		app.addAddressBook(book1);
		app.addAddressBook(book2);
		
		assertEquals("there shall be 2 address book in the app", 2, app.getAddressBookList().size());
		
	}
	
	@Test
	public void testPrintUniqueContacts(){
		logger.info("start testPrintUniqueContacts... ");
		
		
		Contact contact1 = new Contact("name1", "+611111111");
		Contact contact2 = new Contact("name2", "+612222222");
		
		AddressBook book1 = new AddressBook("book1");
		book1.addContact(contact1);
		book1.addContact(contact2);
		
		AddressBook book2 = new AddressBook("book2");
		book2.addContact(contact1);
		book2.addContact(contact2);
		
		AddressBookApplication app = new AddressBookApplication("application1");
		app.addAddressBook(book1);
		app.addAddressBook(book2);
		
		Set<Contact> distinctSet = app.getDistinctContactsFromAllBook();
		assertEquals("there shall be 2 distinct contacts in all the app's addressbook", 2, distinctSet.size());
		
		distinctSet.forEach(contact->logger.info(contact));
		
	}

}
