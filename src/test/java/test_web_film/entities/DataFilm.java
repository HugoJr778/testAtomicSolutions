package test_web_film.entities;

import java.time.LocalDate;

public class DataFilm {
	
	private String nameDirector;
	private LocalDate birthDirector;
	private String film;
	private LocalDate launch;
	
	public DataFilm() {
	}

	public DataFilm(String nameDirector, LocalDate birthDirector, String film, LocalDate launch) {
		this.nameDirector = nameDirector;
		this.birthDirector = birthDirector;
		this.film = film;
		this.launch = launch;
	}

	public String getnameDirector() {
		return nameDirector;
	}

	public void setnameDirector(String nameDirector) {
		this.nameDirector = nameDirector;
	}

	public LocalDate getbirthDirector() {
		return birthDirector;
	}

	public void setbirthDirector(LocalDate birthDirector) {
		this.birthDirector = birthDirector;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public LocalDate getLaunch() {
		return launch;
	}

	public void setLaunch(LocalDate launch) {
		this.launch = launch;
	}
}