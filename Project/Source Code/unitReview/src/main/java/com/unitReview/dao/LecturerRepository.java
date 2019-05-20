package com.unitReview.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitReview.Domain.Lecturer;
import com.unitReview.Domain.Unit;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long>{//<Type,ID>

	@Query(value = "SELECT * FROM LECTURER l where l.lecturer_id = :lecturerId", nativeQuery=true) 
	Lecturer findLecturerById(@Param("lecturerId") Long lecturerId);

	// This added method is for search box by Wayne. Ask if you need to refine it.
	@Query(value="SELECT * from LECTURER WHERE REGEXP_LIKE(lecturer_name,:name,'i')", nativeQuery=true)
	List<Lecturer> fuzzyFindByLecturerName(@Param("name")String name);
}

