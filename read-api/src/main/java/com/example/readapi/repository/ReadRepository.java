package com.example.readapi.repository;

import com.example.readapi.entity.Read;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadRepository extends MongoRepository<Read,Long> {
}
