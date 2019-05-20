package com.unitReview.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitReview.Domain.Identity;

@Repository
public interface IdentityRepository extends CrudRepository<Identity, Long>{
	@Query(value="INSERT INTO IDENTITY ("
			+ "email, "
			+ "avator, "
			+ "last_name, "
			+ "first_name, "
			+ "nationality) "
			+ "VALUES "
			+ "("
			+ ":email, "
			+ ":avator,"
			+ ":last_name,"
			+ ":first_name,"
			+ ":nationality"
			+ ")",nativeQuery=true)
	@Modifying
	@Transactional
	void saveIdentity(
			@Param("email")String email, 
			@Param("avator") String avator,
			@Param("last_name")String last_name,
			@Param("first_name")String first_name,
			@Param("nationality") String nationality);
	
	@Query(value="SELECT count(*) FROM IDENTITY WHERE email=:email",nativeQuery=true)
	int isEmailExist(@Param("email") String email);
	
	@Query(value="SELECT id FROM IDENTITY WHERE email=:email",nativeQuery=true)
	long retrieveIdByEmail(@Param("email") String email);
}
