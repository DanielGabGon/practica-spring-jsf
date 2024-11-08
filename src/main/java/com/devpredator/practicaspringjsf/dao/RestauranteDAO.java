/**
 * 
 */
package com.devpredator.practicaspringjsf.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.devpredator.practicaspringjsf.entity.Restaurante;

/**
 * @author 4PF28LA_2004
 *
 */
public interface RestauranteDAO {

	List<Restaurante> consultar();

}
