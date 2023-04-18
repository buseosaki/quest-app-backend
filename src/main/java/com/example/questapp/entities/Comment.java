package com.example.questapp.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "comment")
@Data

public class Comment {
	
	@Id
	Long id;
	@ManyToOne(fetch = FetchType.LAZY)  //bir sürü postun tek bir userı olabilir 
	@JoinColumn(name="post_id", nullable=false) //post id'yi comment'a bağladık
	@OnDelete(action = OnDeleteAction.CASCADE) //bir post silindiğinde commentları da silinsin
	@JsonIgnore
	Post post;
	
	@ManyToOne(fetch = FetchType.LAZY)  //bir sürü postun tek bir userı olabilir 
	@JoinColumn(name="user_id", nullable=false) //user id'yi comment'a bağladık
	@OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiğinde postları da silinsin
	@JsonIgnore
	User user;

	@Lob
	@Column(columnDefinition = "text")
	String text;

}
