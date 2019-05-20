package com.unitReview.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unitReview.Domain.Unit;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long>{//<Type,ID>

//	@Query("SELECT * FROM UNIT u where u.unit_code = :unitCode AND u.unit_year = :unitYear AND u.unit_semester = :unitSemester") 
//	Unit findUnitByCodeAndYearAndSemester(@Param("unitCode") String unitCode, @Param("unitYear") int unitYear, @Param("unitSemester") String unit_semester);
	@Query(value = "SELECT * FROM UNIT u where u.unit_code = :unitCode", nativeQuery=true) 
	Unit findUnitByCodeAndYearAndSemester(@Param("unitCode") String unitCode);
	
	// This added method is for search box by Wayne. Ask if you need to refine it.
	@Query(value="SELECT * from UNIT u WHERE REGEXP_LIKE(unit_name,:name,'i')", nativeQuery=true)
	List<Unit> fuzzyFindByUnitName(@Param("name")String name);
	
	// This added method is for search box by Wayne. Ask if you need to refine it.
	@Query(value="SELECT * from UNIT u WHERE REGEXP_LIKE(unit_code,:code,'i')", nativeQuery=true)
	List<Unit> fuzzyFindByUnitCode(@Param("code")String code);
	
}

