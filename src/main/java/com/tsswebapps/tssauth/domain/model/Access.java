package com.tsswebapps.tssauth.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Access {
	private Long id;
	private Long user_id;
	private Long Token_id;
	private LocalDateTime moment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getToken_id() {
		return Token_id;
	}

	public void setToken_id(Long token_id) {
		Token_id = token_id;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	@Override
	public String toString() {
		return "Access [id=" + id + ", user_id=" + user_id + ", Token_id=" + Token_id + ", moment=" + moment + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Token_id, id, moment, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Access other = (Access) obj;
		return Objects.equals(Token_id, other.Token_id) && Objects.equals(id, other.id)
				&& Objects.equals(moment, other.moment) && Objects.equals(user_id, other.user_id);
	}

}
