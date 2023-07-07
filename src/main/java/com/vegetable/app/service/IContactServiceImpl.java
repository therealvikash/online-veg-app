package com.vegetable.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.IContactRepository;
import com.vegetable.app.vo.Contact;

@Service
public class IContactServiceImpl implements IContactService {
	@Autowired
	private IContactRepository conrepo;

	@Override
	public Contact saveContact(Contact contact) {
		Contact addCon = conrepo.save(contact);
		return addCon;

	}
}
