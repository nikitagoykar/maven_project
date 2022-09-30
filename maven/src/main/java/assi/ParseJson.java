package assi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJson {
	public static void parseObject(JSONObject json, String key) throws JSONException {
		// System.out.println(json.has(key));
		System.out.println(json.get(key));
	}

	public static void main(String[] args) throws JSONException {
		String gender;
		String name;
		String email;
		String status;

		Scanner sc = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<String>();

		HttpConnection conn = new HttpConnection();
		String inputJson = conn.makeConnection();
		// String inputJson = "[{\"id\":3560,\"name\":\"Mandaakin
		// Patil\",\"email\":\"patil_mandaakin@kautzer.net\",\"gender\":\"male\",\"status\":\"active\"},{\"id\":3559,\"name\":\"Mukesh
		// Chattopadhyay\",\"email\":\"chattopadhyay_mukesh@senger-turcotte.co\",\"gender\":\"female\",\"status\":\"active\"},{\"id\":3558,\"name\":\"Rev.
		// Marut
		// Kakkar\",\"email\":\"marut_rev_kakkar@windler.io\",\"gender\":\"female\",\"status\":\"inactive\"},{\"id\":3557,\"name\":\"Lila
		// Mehra
		// PhD\",\"email\":\"mehra_lila_phd@kreiger.com\",\"gender\":\"male\",\"status\":\"active\"},{\"id\":3552,\"name\":\"Kama
		// Varman\",\"email\":\"varman_kama@roob.org\",\"gender\":\"female\",\"status\":\"inactive\"},{\"id\":3551,\"name\":\"Dinesh
		// Panicker
		// Esq.\",\"email\":\"panicker_esq_dinesh@schinner-jerde.biz\",\"gender\":\"male\",\"status\":\"active\"},{\"id\":3550,\"name\":\"Jagadisha
		// Kaul\",\"email\":\"kaul_jagadisha@bergstrom.name\",\"gender\":\"male\",\"status\":\"inactive\"},{\"id\":3549,\"name\":\"Chandi
		// Dutta\",\"email\":\"dutta_chandi@lakin.net\",\"gender\":\"male\",\"status\":\"inactive\"},{\"id\":3548,\"name\":\"Gandharva
		// Chopra\",\"email\":\"chopra_gandharva@friesen.biz\",\"gender\":\"male\",\"status\":\"inactive\"},{\"id\":3547,\"name\":\"Vasudha
		// Pandey
		// Sr.\",\"email\":\"vasudha_pandey_sr@fahey.com\",\"gender\":\"female\",\"status\":\"inactive\"}]";

		do {
			int ch = 0;

			System.out.println("\n*****ENTER YOUR CHOICE *****\n");
			System.out.println("1).GENDER\n" + "2).NAME\n" + "3).EMAIL\n" + "4).STATUS\n");
			System.out.println("Enter Your Choice : ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Gender");
				System.out.println("Please enter gender");
				gender = sc.next();
				int i = 0;
				for (String s : al) {
					if (gender == s.toString()) {
						System.out.println(s + "\n");
						i++;
					}

				}
				if (i == 0) {

					if (inputJson != null) {
						JSONArray inputJsonObject = new JSONArray(inputJson);
						getDetailsByType(inputJsonObject, "gender", gender);
						String userSelect = "gender";
						String userInput = gender;

						System.out.println(getDetailsByType(inputJsonObject, userSelect, userInput));
					}
				}
				break;

			case 2:
				try {

					System.out.println("Name");
					System.out.println("Please enter name");

					name = sc.nextLine();
					name = sc.nextLine();
					int j = 0;
					for (String s : al) {
						if (name == s.toString()) {
							System.out.println(s + "\n");
							j++;
						}

					}
					if (j == 0) {

						if (inputJson != null) {
							JSONArray inputJsonObject = new JSONArray(inputJson);
							getDetailsByType(inputJsonObject, "name", name);
							String userSelect = "name";
							String userInput = name;

							System.out.println(getDetailsByType(inputJsonObject, userSelect, userInput));
						}
					}
				} catch (Exception e) {

				} finally {
					name = sc.next();
////					if (inputJson != null) {
////						JSONArray inputJsonObject = new JSONArray(inputJson);
////						//getDetailsByType(inputJsonObject, "name", name);
////						String userSelect = "name";
//						//String userInput = name;
					System.out.println(name.toString());
//
//						//System.out.println(getDetailsByType(inputJsonObject, userSelect, userInput));
//					}
				}
				break;

			case 3:
				System.out.println("Email");
				System.out.println("Please enter email");

				email = sc.next();
				int k = 0;
				for (String s : al) {
					if (email == s.toString()) {
						System.out.println(s + "\n");
						k++;
					}

				}
				if (k == 0) {

					if (inputJson != null) {
						JSONArray inputJsonObject = new JSONArray(inputJson);
						getDetailsByType(inputJsonObject, "email", email);
						String userSelect = "email";
						String userInput = email;

						System.out.println(getDetailsByType(inputJsonObject, userSelect, userInput));
					}
				}
				break;

			case 4:
				System.out.println("Status");
				System.out.println("Please enter status");

				status = sc.next();
				int m = 0;
				for (String s : al) {
					if (status == s.toString()) {
						System.out.println(s + "\n");
						m++;
					}

				}
				if (m == 0) {

					if (inputJson != null) {
						JSONArray inputJsonObject = new JSONArray(inputJson);
						getDetailsByType(inputJsonObject, "status", status);
						String userSelect = "status";
						String userInput = status;

						System.out.println(getDetailsByType(inputJsonObject, userSelect, userInput));
					}
				}
				break;

			default:
				System.out.println("\n Enter a correct choice from the List : ");
				break;
			}
		} while (true);

	}

	private static List<JSONObject> getDetailsByType(JSONArray inputJsonArray, String userSelect, String userInput) {
		List<JSONObject> resultSet = new ArrayList<JSONObject>();
		try {
			for (int i = 0; i < inputJsonArray.length(); i++) {

				JSONObject eachObj = inputJsonArray.getJSONObject(i);
				if (eachObj.get(userSelect).equals(userInput)) {
					resultSet.add(eachObj);
				}

			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}
