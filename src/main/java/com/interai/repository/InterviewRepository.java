
package com.interai.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.interai.model.Interview;

public interface InterviewRepository extends MongoRepository<Interview, String> {

}
