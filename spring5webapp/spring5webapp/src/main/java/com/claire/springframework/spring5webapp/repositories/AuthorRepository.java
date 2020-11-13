package com.claire.springframework.spring5webapp.repositories;

import com.claire.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Claire on 11/11/20
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
