package com.Kyselypalvelu.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {

	List<QuestionType> findAll();
}
