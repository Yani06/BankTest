package fr.bank.interview.domain;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author yidoughi
 *
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
	private Address address;
    private String phoneNumber;
    private String email;
    private Set<Integer> accounts = new TreeSet<>();

    public User() {}

	public User(int id, String firstName, String lastName,
			int age, String phone, String email, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;		
		this.phoneNumber = phone;
		this.email = email;
		this.address = address;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Integer> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Integer> accounts) {
        this.accounts = accounts;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", accounts=" + accounts + "]";
	}
    
}
