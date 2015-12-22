package ua.nure.helperk.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Oleg Dashkevych.
 */

@Entity
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class UserRole implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String name;

	public UserRole() {
	}

	public UserRole(String name) {
		this.name = name;

		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.schedule(() -> {
		}, 24, TimeUnit.HOURS);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
