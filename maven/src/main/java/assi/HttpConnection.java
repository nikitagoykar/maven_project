package assi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
	private static HttpURLConnection urlConnection;

	public String makeConnection() {
		//System.out.println("Hello world!");
		BufferedReader reader;
		String line;
		String response =null;
		StringBuffer responseContent = new StringBuffer();
		try {
			URL url = new URL("https://gorest.co.in/public/v2/users");

			urlConnection = (HttpURLConnection) url.openConnection();

			urlConnection.setRequestMethod("GET");
			urlConnection.setConnectTimeout(5000);
			urlConnection.setReadTimeout(5000);

			int status = urlConnection.getResponseCode();

			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}

			else {
				reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();

			}

			response = responseContent.toString();

		} catch (IOException e) {
			e.printStackTrace();

		}

		finally {
			urlConnection.disconnect();
		}
		return response;

	}
}