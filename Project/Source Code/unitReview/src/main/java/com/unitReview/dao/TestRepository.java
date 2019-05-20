package com.unitReview.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitReview.Domain.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Long>{//<Type,ID>
	
	@Modifying
	@Query(value = "INSERT INTO TEST (test_content) VALUES ( 'test3');", nativeQuery=true) 
	@Transactional
	void insertInto();
}

