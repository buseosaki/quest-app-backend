package com.example.questapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //bu class database'e maplenecek anlamına gelir.
@Table(name="user")
@Data //lomboktan geliyor. user'ın getter ve setterlarını generate eder.
public class User {

	@Id //Tablolarda her zaman id olur.
	Long id;
	
	String userName;
	String password;
}
