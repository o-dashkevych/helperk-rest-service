package ua.nure.helperk.entity;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Oleg Dashkevych.
 */
@Entity
@Table(name = "message", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Message implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String titleName;

	private Boolean isRead;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sender_id",  nullable = false)
	private User sender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "getter_id", nullable = false)
	private User getter;

	public Message() {
	}

	public Message(String titleName, Boolean isRead, User sender, User getter) {
		this.titleName = titleName;
		this.isRead = isRead;
		this.sender = sender;
		this.getter = getter;
	}


}
