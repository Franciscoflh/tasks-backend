package br.com.francisco.taskbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String task;
	
	@Column(nullable = false)
	private LocalDate dueDate;

	public Task() {

	}
}
