package ua.nure.helperk.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Oleg Dashkevych.
 */


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
	@JoinColumn(name = "executor_id", nullable = false)
	private User executor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "advert_type_id", nullable = false)
	private AdvertType type;

	public Advert() {
	}

	public Advert(String titleName, String description, Timestamp startDate,
				  Timestamp endDate, Double price, User creator, User executor, AdvertType type) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public AdvertType getType() {
		return type;
	}

	public void setType(AdvertType type) {
		this.type = type;
	}

	public User getExecutor() {
		return executor;
	}

	public void setExecutor(User executor) {
		this.executor = executor;
	}
}
