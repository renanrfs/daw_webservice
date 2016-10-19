package pt.iscte.moss;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private static final String USER_URL_ADDRESS = "http://localhost:8080/moss-ws/rest/user";
	private static final String DELETE_METHOD = "DELETE";
	private static final String POST_METHOD = "POST";
	private static final String PUT_METHOD = "PUT";
	private static final int ACTUAL_ID = 13;

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Create data base {@link User}.
	 * 
	 * @throws Exception
	 */
	public void testCreateUser() throws Exception {
		System.out.println("## testCreateUser ##");
		sendHttpRequest(POST_METHOD, getRenanParameters(ACTUAL_ID));
		assertTrue(true);
	}

	/**
	 * Update data base {@link User}.
	 * 
	 * @throws Exception
	 */
	public void testUpdateUser() throws Exception {
		System.out.println("## testUpdateUser ##");
		sendHttpRequest(PUT_METHOD, getLucasParameters(ACTUAL_ID));
		assertTrue(true);
	}

	/**
	 * Delete data base {@link User}.
	 * 
	 * @throws Exception
	 */
	public void testDeleteUser() throws Exception {
		System.out.println("## testDeleteUser ##");
		sendDeleteRequest(ACTUAL_ID);
		assertTrue(true);
	}

	/**
	 * Produce Renan's URL parameter.
	 * 
	 * @param id
	 *            Dynamic identify
	 * @return The Renan's URL parameter.
	 */
	public String getRenanParameters(int id) {
		return "id="
				+ id
				+ "&name=Renan Fernandes&username=renan.fernandes&password=asd123&email=renan@gmail.com&site=www.renanfernandes.com&cityId=1";
	}

	/**
	 * Produce Lucas's URL parameter.
	 * 
	 * @param id
	 *            Dynamic identify
	 * @return The Lucas's URL parameter.
	 */
	public String getLucasParameters(int id) {
		return "id="
				+ id
				+ "&name=Lucas Vasconcellos&username=l.vasconcellos&password=aaabbbccc&email=l.vasconcellos@gmail.com&site=www.l_vasconcellos.com&cityId=2";
	}

	/**
	 * Send HTTP request.
	 * 
	 * @param requestMethod
	 *            POST [create user] or PUT [update user]
	 * @param urlParameters
	 *            The user URL parameters
	 * @throws Exception
	 */
	public void sendHttpRequest(String requestMethod, String urlParameters)
			throws Exception {

		HttpURLConnection connection = (HttpURLConnection) new URL(
				USER_URL_ADDRESS).openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod(requestMethod);
		connection.setConnectTimeout(1000);

		DataOutputStream dataOutputStream = new DataOutputStream(
				connection.getOutputStream());
		dataOutputStream.writeBytes(urlParameters);
		dataOutputStream.flush();
		dataOutputStream.close();

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code: " + responseCode);

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = bufferedReader.readLine()) != null) {
			response.append(inputLine);
		}
		bufferedReader.close();

		System.out.println(response.toString());
	}

	/**
	 * Send DELETE HTTP request
	 * 
	 * @param userId
	 *            The {@link User} identify
	 * @throws Exception
	 */
	public void sendDeleteRequest(int userId) throws Exception {

		String urlAddress = USER_URL_ADDRESS + "/" + userId;

		HttpURLConnection connection = (HttpURLConnection) new URL(urlAddress)
				.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod(DELETE_METHOD);
		connection.setConnectTimeout(1000);

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code: " + responseCode);

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = bufferedReader.readLine()) != null) {
			response.append(inputLine);
		}
		bufferedReader.close();

		System.out.println(response.toString());
	}
}
