package com.raya;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by student on 6/20/17.
 */
@Transactional
public interface PersonRepository extends CrudRepository<Person, Integer>{


}
