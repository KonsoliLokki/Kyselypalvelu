package com.Kyselypalvelu.domain;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ChoiceRepository extends CrudRepository<Choice, Long> {
	
	@Modifying
	@Query(value = "delete from Choice c where c.question.questionId=:id")
	int deleteById(@Param("id") long id);
}
