package com.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.EmailsData;

@Repository
public interface EmailsRepository extends CrudRepository<EmailsData, Long> {

}
