/*
 * Generated by Xtext/JEE7 Generator.
 * Copyright (C) 2013  itemis AG 
 * $Id$
 */

package de.itemis.jee7.dbauth.entities;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import de.itemis.jee7.util.SHA512;

/**
 * This class implements the AuthInfo entity bean,
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "AuthInfo")
public class AuthInfo extends AbstractAuthInfo {
	private static final long serialVersionUID = 1L;
	private static final SHA512 sha512 = new SHA512();

	/**
	 * This method is a transient getter of the virtual property passwordUncoded.
	 *
	 * @return The computed value for property passwordUncoded.
	 */
	@Transient
	@Override
	public String getPasswordUncoded()
	{
		return getPassword();
	}
	
	public void setPasswordUncoded(final String password) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		setPassword(sha512.encode(password));
	}
}
