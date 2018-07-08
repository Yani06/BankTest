package fr.bank.interview.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.bank.interview.domain.Address;
import fr.bank.interview.domain.User;

/**
 * 
 * @author yidoughi
 *
 */

public class UserDataUtil {

	public static Map<Integer, User> generateUsers() {

		Map<Integer, User> users = new HashMap<>();
		int i = 0;
		while (i < buildFirstNames().size()) {
			User user = new User(i + 1, buildFirstNames().get(i), buildLastNames().get(i),
					buildAges().get(i), buildPhones().get(i), buildEmails().get(i), buildAdresses().get(i));
			users.put(user.getId(), user);
			i++;
		}

		return users;

	}

	private static Map<Integer, String> buildFirstNames() {
		Map<Integer, String> firstNames = new HashMap<>();
		firstNames.put(0, "Delmon");
		firstNames.put(1, "Courtois");
		firstNames.put(2, "Jouannais");
		firstNames.put(3, "Idoughi");
		firstNames.put(4, "Ait Zer");
		return firstNames;
	}

	private static Map<Integer, String> buildLastNames() {
		Map<Integer, String> firstNames = new HashMap<>();
		firstNames.put(0, "Camille");
		firstNames.put(1, "Romain");
		firstNames.put(2, "Antoine");
		firstNames.put(3, "Yani");
		firstNames.put(4, "Amrane");
		return firstNames;
	}

	private static Map<Integer, String> buildEmails() {
		Map<Integer, String> emails = new HashMap<>();
		emails.put(0, "cdelmon@neolynk.fr");
		emails.put(1, "rcourtois@neolynk.fr");
		emails.put(2, "ajouannais@neolynk.fr");
		emails.put(3, "yidoughi@neolynk.fr");
		emails.put(4, "azer@neolynk.fr");
		return emails;
	}

	private static Map<Integer, Integer> buildAges() {
		Map<Integer, Integer> ages = new HashMap<>();
		ages.put(0, 30);
		ages.put(1, 42);
		ages.put(2, 53);
		ages.put(3, 28);
		ages.put(4, 25);
		return ages;
	}

	private static Map<Integer, String> buildPhones() {
		Map<Integer, String> phones = new HashMap<>();
		phones.put(0, "060934568");
		phones.put(1, "060984588");
		phones.put(2, "060934778");
		phones.put(3, "035658977");
		phones.put(4, "566314411");
		return phones;
	}

	private static Map<Integer, Address> buildAdresses() {
		List<String> lines = Arrays.asList("1 rue emile Zola", "2 rue emile Zola", "3 rue emile Zola",
				"4 rue emile Zola", "5 rue emile Zola");
		List<String> city = Arrays.asList("Paris", "Paris", "Paris", "Paris", "Paris");
		List<String> postalCodes = Arrays.asList("75001", "75002", "75003", "75004", "75005");
		List<String> countries = Arrays.asList("France", "France", "France", "France", "France");
		Map<Integer, Address> addresses = new HashMap<>();
		int i = 0;
		while (i < postalCodes.size()) {
			Address address = new Address(lines.get(i), city.get(i), null, postalCodes.get(i), countries.get(i));
			addresses.put(i, address);
			i++;
		}
		return addresses;
	}

}
