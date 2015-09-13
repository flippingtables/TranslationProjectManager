package com.sandagerdi.translationprojectmanager.Repository;

/**
 *
 * @author joannes
 */

import java.util.List;

public interface GenericDao<T, ID> {
    /**
     * Inserts the default data into the database.
     */
    void insertDefaultData();

    /**
     * Find an entity by it identifier.
     * @param id The identifier.
     * @return The entity.
     */
    T findById(ID id);

    /**
     * Check if the database has a record with a specific identifier.
     * @param id The identifier to query on.
     * @return {@link Boolean#TRUE} if the id is found in the table, otherwise {@link Boolean#FALSE}.
     */
    boolean contains(ID id);

    /**
     * Find all entities of one type.
     * @return A list of entities.
     */
    List<T> findAll();

    /**
     * Persists a new entity in the datbase or updates an already existing one.
     * @param entity The entity to store or update.
     * @return The stored entity.
     */
    T save(T entity);

    /**
     * Persists a new entity in the datbase or updates an already existing one.
     * @param entity The entity to store or update.
     * @return The stored entity.
     */
    T update(T entity);

    /**
     * Removes an entity.
     * @param entity The entity to remove.
     */
    void delete(T entity);

    /**
     * Refreshes the content of an object based on it's identifier.
     * @param entity The entity to refresh.
     * @return The number of entities refreshed. If everything is ok this should always be one!
     */
    int refresh(T entity);

    /**
     * Count the total number of records in the database.
     * @return The number of records in the database.
     */
    Long count();

    void deleteAll();
}