package com.hm.hotel.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
public class Hotel {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;

}
