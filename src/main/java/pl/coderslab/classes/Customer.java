package pl.coderslab.classes;

import org.springframework.stereotype.Component;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;

	// brak atrybutu pseudonim w specyfikacji klasy
	public Customer(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
// #### Zadanie 1
//
// 1. Stwórz klasę `Customer`, która ma spełniać następujące wymogi:
//
// Klasa ma mieć prywatne atrybuty:
// * `id` - atrybut ten powinien trzymać numer identyfikacyjny,
// * `firstName` - atrybut określający imię klienta,
// * `lastName` - atrybut określający nazwisko klienta,
//
// 2. Ma posiadać konstruktor przyjmujący id, imię, nazwisko, pseudonim. Getery
// i settery dla pól, oraz bezparametrowy konstruktor.
//