package com.reece.addressbook.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.reece.addressbook.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByName(String name);
}
