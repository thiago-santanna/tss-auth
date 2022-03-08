package com.tsswebapps.tssauth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.tssauth.domain.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
