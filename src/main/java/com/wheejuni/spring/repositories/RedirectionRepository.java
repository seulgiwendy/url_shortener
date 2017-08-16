package com.wheejuni.spring.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.wheejuni.spring.domain.Redirection;

@EnableScan
public interface RedirectionRepository extends CrudRepository <Redirection, String>{

	Redirection findByMappedUrl(String mappedUrl);
}
