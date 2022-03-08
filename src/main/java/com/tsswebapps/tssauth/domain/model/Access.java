package com.tsswebapps.tssauth.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "access")
public class Access {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User userId;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Token TokenId;
	
	private LocalDateTime moment;

}
