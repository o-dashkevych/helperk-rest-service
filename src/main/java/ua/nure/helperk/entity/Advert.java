package ua.nure.helperk.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Oleg Dashkevych.
 */

@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal"})
@Data
@NoArgsConstructor
@Entity
@Table(name = "advert", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Advert {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String titleName;

	private String description;

	private Timestamp startDate;

	private Timestamp endDate;

	private Double price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "creator_id", nullable = false)
	private User creator;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "executor_id")
	private User executor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "advert_type_id", nullable = false)
	private AdvertType type;

	public Advert(String titleName, String description, Timestamp startDate,
				  Timestamp endDate, Double price, User creator, User executor, AdvertType type, byte[] image) {
		this.titleName = titleName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.creator = creator;
		this.executor = executor;
		this.type = type;

		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.schedule(() -> {
		}, 24, TimeUnit.HOURS);
	}
}
