package com.chings.core.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class User {
	public long id;
	@NotNull
	public String name;
	public String mobile;
	@NotNull
	public String email;
	public Date lock_time;
	public Date lock_continue_times;
	public int lock_state;
	public int status;
	@NotNull
	public String password;
	public Date create_time;
	public int country;
	public int city;
	public int province	;
	public String photo;
	public int score;
	public int rank;
	public int share_type;

	public User() {
	}

	public User(long id, String name, String mobile,
				String email, Date lock_time,
				Date lock_continue_times, int lock_state,
				int status, String password, Date create_time,
				int country, int city, int province, String photo,
				int score, int rank, int share_type) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.lock_time = lock_time;
		this.lock_continue_times = lock_continue_times;
		this.lock_state = lock_state;
		this.status = status;
		this.password = password;
		this.create_time = create_time;
		this.country = country;
		this.city = city;
		this.province = province;
		this.photo = photo;
		this.score = score;
		this.rank = rank;
		this.share_type = share_type;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLock_time(Date lock_time) {
		this.lock_time = lock_time;
	}

	public void setLock_continue_times(Date lock_continue_times) {
		this.lock_continue_times = lock_continue_times;
	}

	public void setLock_state(int lock_state) {
		this.lock_state = lock_state;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setShare_type(int share_type) {
		this.share_type = share_type;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public Date getLock_time() {
		return lock_time;
	}

	public Date getLock_continue_times() {
		return lock_continue_times;
	}

	public int getLock_state() {
		return lock_state;
	}

	public int getStatus() {
		return status;
	}

	public String getPassword() {
		return password;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public int getCountry() {
		return country;
	}

	public int getCity() {
		return city;
	}

	public int getProvince() {
		return province;
	}

	public String getPhoto() {
		return photo;
	}

	public double getScore() {
		return score;
	}

	public int getRank() {
		return rank;
	}

	public int getShare_type() {
		return share_type;
	}
}
