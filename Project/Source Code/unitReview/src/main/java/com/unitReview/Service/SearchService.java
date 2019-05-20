package com.unitReview.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitReview.Domain.Unit;
import com.unitReview.dao.LecturerRepository;
import com.unitReview.dao.UnitRepository;
import com.unitReview.Domain.Lecturer;

@Service
public class SearchService{
	private UnitRepository unitRepository;
	private LecturerRepository lecturerRepository;
	
	@Autowired
	public SearchService(UnitRepository unitRepository, LecturerRepository lecturerRepository) {
		this.unitRepository=unitRepository;
		this.lecturerRepository=lecturerRepository;
	}
	
	public List<Unit> searchByUnitName(String query){
		return this.unitRepository.fuzzyFindByUnitName(query);
	}
	
	public List<Lecturer> searchByLecturerName(String query){
		return this.lecturerRepository.fuzzyFindByLecturerName(query);
	}
	
	public List<Unit> searchByUnitCode(String query){
		return this.unitRepository.fuzzyFindByUnitCode(query);
	}
}