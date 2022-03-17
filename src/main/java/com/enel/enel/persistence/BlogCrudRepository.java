package com.enel.enel.persistence;

import com.enel.enel.persistence.BlogEntity;
import org.springframework.data.repository.CrudRepository;

public interface BlogCrudRepository extends CrudRepository<BlogEntity, Integer> {

}
