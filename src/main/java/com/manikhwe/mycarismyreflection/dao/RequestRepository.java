package com.manikhwe.mycarismyreflection.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manikhwe.mycarismyreflection.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long>{

}
