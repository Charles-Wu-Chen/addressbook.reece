package com.reece.addressbook.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.reece.addressbook.model.AddressBook;
import com.reece.addressbook.model.Contact;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findByAddressBookName(String addressBookName);
}
