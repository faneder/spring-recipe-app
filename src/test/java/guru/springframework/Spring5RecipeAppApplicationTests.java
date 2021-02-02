package guru.springframework;

import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5RecipeAppApplicationTests {

	@Test
	public void contextLoads() throws JSONException, IOException {
		JSONObject obj = new JSONObject();

		obj.put("query"," query ($arn: String)");
		obj.put("num",new Integer(100));
		obj.put("balance",new Double(1000.21));
		obj.put("is_vip", Boolean.TRUE);

		StringWriter out = new StringWriter();
		obj.writeJSONString(out);

		String jsonText = out.toString();
		System.out.print(jsonText);
	}

	@Test
	public void graphql() {
		String requestBody =
			"{\"query\":\"query { " +
				"vehiclesByArn(arn: \"" + 111 + "\") { " +
				"vehicleId " +
				"} " +
			"}";
		String responseBody = "{\"data\":{\"vehiclesByArn\":{\"vehicleId\":"+1231+"}}}";
		String actual = format("{\"requestBody\": \"%s\", \"responseBody\": \"%s\"}",
			requestBody.replace("\"", "\\\""),
			responseBody.replace("\"", "\\\""));
		assertThat(actual).isEqualTo("dd");
	}

	@Test
	public void query() throws IOException {
		InputStream queryFile = getClass().getClassLoader().getResourceAsStream("test.graphql");
		String query = new String(FileCopyUtils.copyToByteArray(queryFile), StandardCharsets.UTF_8);
		String expected = "{\n" +
			"    vehiclesByArn(arn: \"abc\") {\n" +
			"        mileage {\n" +
			"            latest {\n" +
			"                mileage\n" +
			"            }\n" +
			"        }\n" +
			"    }\n" +
		"}";

		assertThat(new GraphQlBuilder(query).builder("abc")).isEqualTo(expected);
	}
}
