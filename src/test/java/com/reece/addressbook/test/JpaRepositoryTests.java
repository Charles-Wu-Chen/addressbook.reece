/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.reece.addressbook.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.reece.addressbook.dao.AddressBookRepository;
import com.reece.addressbook.dao.ContactRepository;
import com.reece.addressbook.model.AddressBook;
import com.reece.addressbook.model.Contact;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ContactRepository customers;
	
	@Autowired
	private AddressBookRepository adRepo;

	@Test
	public void testContactFindByName() {
		Contact c = new Contact("Four", "4444");
		entityManager.persist(c);

		List<Contact> findByName = customers.findByName(c.getName());
		assertNotNull(findByName);

	}
	
	@Test
	public void testAddressBookFindByName() {
		AddressBook ab = new AddressBook("addressbook1");
		Contact c = new Contact("Five", "55555");
		ab.addContact(c);
		entityManager.persist(ab);

		List<AddressBook> findByName = adRepo.findByAddressBookName(ab.getAddressBookName());
		assertNotNull(findByName);
		findByName.get(0).getContactList().forEach(contact->System.out.println(contact));
		

	}
}