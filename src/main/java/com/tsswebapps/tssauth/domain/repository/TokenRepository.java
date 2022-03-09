package com.tsswebapps.tssauth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.tssauth.domain.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}
