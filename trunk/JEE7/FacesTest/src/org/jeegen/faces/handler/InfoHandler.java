
/*
 * Generated by Xtext/JEE7 Generator.
 * Copyright (C) 2015  Steffen A. Mork, Dominik Pieper 
 * $Id$
 */

package org.jeegen.faces.handler;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jeegen.faces.entities.EntityEntry;
import org.jeegen.faces.entities.HistoryEntry;
import org.jeegen.faces.entities.Startup;
import org.jeegen.jee7.util.Profiled;

/**
 * This managed bean class implements the action handling for the following entity beans:
 * <ul>
 * <li>{@link EntityEntry}</li>
 * <li>{@link HistoryEntry}</li>
 * <li>{@link Startup}</li>
 * </ul>
 */
@Named
@SessionScoped
@Transactional(value = TxType.REQUIRED)
@Profiled
public class InfoHandler extends AbstractInfoHandler
{
	private static final long serialVersionUID = 1L;

	private static final String NAV_INFO_ENTITYENTRY = "entityentry.xhtml";
	private static final String NAV_INFO_HISTORYENTRY = "historyentry.xhtml";
	private static final String NAV_INFO_STARTUP = "startup.xhtml";

	/*********************************************
	 * Startup startup
	 *********************************************/

	/**
	 * This method returns a {@link List} of all {@link Startup} beans.
	 *
	 * @return {@link List} of all {@link Startup} beans.
	 * @see org.jeegen.faces.dao.AbstractInfoDaoBean#getStartupList()
	 */

	public List<Startup> getStartupList() {
		final List<Startup> list = dao.getStartupList();

		return list;
	}

	/**
	 * This method adds a new {@link Startup} bean.
	 *
	 * @param startup The new {@link Startup} bean to persist.
	 * @return The outcome where to go on success.
	 * @see org.jeegen.faces.dao.AbstractInfoDaoBean#addStartup(Startup)
	 */

	public String addStartup(final Startup startup) {
		dao.addStartup(startup);
		setStartup(new Startup());
		return NAV_INFO_STARTUP;
	}

	/**
	 * This method sets the given {@link Startup} bean for editing.
	 *
	 * @param startup The {@link Startup} bean to edit.
	 * @return The outcome where to go on success.
	 */

	public String changeStartup(final Startup startup) {
		setStartup(startup);
		return NAV_INFO_STARTUP;
	}

	/**
	 * This method removes the given {@link Startup} bean.
	 *
	 * @param startup The {@link Startup} bean to remove.
	 * @return The outcome where to go on success.
	 * @see org.jeegen.faces.dao.AbstractInfoDaoBean#deleteStartup(Startup)
	 */

	public String removeStartup(final Startup startup) {
		if (isStartupEmpty(startup)) {
			dao.deleteStartup(startup);
		} else {
			error(null, "info.startup.not-empty");
		}
		return NAV_INFO_STARTUP;
	}

	/**
	 * This method sets the given {@link Startup} bean for editing.
	 *
	 * @return The outcome where to go on success.
	 * @see org.jeegen.faces.dao.AbstractInfoDaoBean#updateStartup(Startup)
	 */

	public String saveStartup() {
		dao.updateStartup(getStartup());
		setStartup(new Startup());
		return NAV_INFO_STARTUP;
	}

	/**
	 * This method simply returns an outcome to return to the processes main menu.
	 *
	 * @return The outcome to go to the main menu.
	 */

	public String backFromStartup() {
		return NAV_INDEX;
	}

	/*********************************************
	 * Editing of bean Startup
	 *********************************************/

	/**
	 * This method prepares the 1:n entities of the Startup bean for editing.
	 * 
	 * @param startup The Startup bean for EntityEntry editing.
	 * @return The outcome for EntityEntry bean editing
	 */

	public String editEntityEntry(final Startup startup) {
		setStartup(startup);
		setEntityEntry(new EntityEntry());
		return NAV_INFO_ENTITYENTRY;
	}

	/**
	 * Thie action method sets the specified {@link EntityEntry} entity bean for editing.
	 *
	 * @param entityEntry The {@link EntityEntry} entity bean to edit.
	 * @return The outcome to return to the 1:n relation editing.
	 */

	public String changeEntityEntry(final EntityEntry entityEntry) {
		setEntityEntry(entityEntry);
		return NAV_INFO_ENTITYENTRY;
	}

	/**
	 * This action method removes an {@link EntityEntry} entity bean from the
	 * 1:n relation entities of the {@link Startup} entity bean.
	 *
	 * @param entityEntry The {@link EntityEntry} entity bean to remove.
	 * @return The outcome to return to the 1:n relation editing.
	 * @see org.jeegen.faces.dao.AbstractInfoDaoBean#deleteFromStartup(EntityEntry)
	 */

	public String removeEntityEntry(final EntityEntry entityEntry) {
		if (isEntityEntryEmpty(entityEntry)) {
			dao.deleteFromStartup(entityEntry);
		} else {
			error(null, "info.entityentry.not-empty");
		}
		return NAV_INFO_ENTITYENTRY;
	}

	/**
	 * This action method saves or creates an {@link EntityEntry} entity bean inside
	 * an 1:n relation of the {@link Startup} entity bean.
	 *
	 * @return The outcome to return to the 1:n relation editing.
	 * @see org.jeegen.faces.dao.AbstractInfoDaoBean#updateEntityEntry(EntityEntry)
	 * @see org.jeegen.faces.dao.AbstractInfoDaoBean#addToStartup(Startup, EntityEntry)
	 */

	public String saveEntityEntry() {
		final EntityEntry entityEntry = getEntityEntry();

		if (entityEntry.getId() != 0)

		{
			dao.updateEntityEntry(entityEntry);
		} else {
			dao.addToStartup(getStartup(), entityEntry);
		}
		setEntityEntry(new EntityEntry());
		return NAV_INFO_ENTITYENTRY;
	}

	/**
	 * This action method returns to the editing of the {@link Startup} bean.
	 *
	 * @return The outcome for editing the {@link Startup} bean.
	 */

	public String backFromEntityEntry() {
		return NAV_INFO_STARTUP;
	}

	/**
	 * This method sets the given {@link Startup} bean for history editing. The
	 * history contains a {@link List} of {@link HistoryEntry} beans.
	 *
	 * @param startup The {@link Startup} bean to edit.
	 * @return The outcome where to go on success.
	 */

	public String editHistoryEntry(final Startup startup) {

		final HistoryEntry newHistoryEntity = new HistoryEntry();

		setStartup(startup);
		setHistoryEntry(newHistoryEntity);
		return NAV_INFO_HISTORYENTRY;
	}

	/**
	 * This action method adds a {@link HistoryEntry} history bean to the
	 * given {@link Startup} bean for editing.
	 *
	 * @return The outcome where to go on success.
	 * @see org.jeegen.faces.dao.AbstractInfoDaoBean#addToStartup(Startup, HistoryEntry)
	 */

	public String saveHistoryEntry() {

		dao.addToStartup(getStartup(), getHistoryEntry());
		setHistoryEntry(new HistoryEntry());

		return NAV_INFO_HISTORYENTRY;
	}

	/**
	 * This action method returns to the editing of the {@link Startup} bean.
	 *
	 * @return The outcome for editing the {@link Startup} bean.
	 */

	public String backFromHistoryEntry() {
		return NAV_INFO_STARTUP;
	}

}