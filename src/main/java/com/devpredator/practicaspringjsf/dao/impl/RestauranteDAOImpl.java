/**
 * 
 */
package com.devpredator.practicaspringjsf.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.devpredator.practicaspringjsf.dao.RestauranteDAO;
import com.devpredator.practicaspringjsf.entity.Restaurante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * @author DevPredator
 *
 */
@Repository
public class RestauranteDAOImpl implements RestauranteDAO {

	// AGREGAR AQUI EL ENTITY MANAGER FACTORY.

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDangabito");


	@Override
	public List<Restaurante> consultar() {
		EntityManager entityManager = null;
		List<Restaurante> restaurantes = null;

		try {
			// Create the EntityManager
			entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

			// Create the query to fetch Restaurante entities
			TypedQuery<Restaurante> query = entityManager.createQuery("FROM Restaurante", Restaurante.class);

			// Execute the query and get the result list
			restaurantes = query.getResultList();

		} catch (Exception e) {
			// Handle exceptions here (or propagate them based on your needs)
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				// Close the EntityManager to release the connection
				entityManager.close();
			}
		}

		return restaurantes;
	}

}
