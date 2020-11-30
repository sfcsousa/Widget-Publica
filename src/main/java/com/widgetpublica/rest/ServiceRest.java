package com.widgetpublica.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;

import com.fluig.customappkey.Keyring;
import com.fluig.sdk.api.FluigAPI;
import com.fluig.sdk.api.common.SDKException;
import com.fluig.sdk.api.customappkey.KeyVO;
import com.fluig.sdk.api.document.DocumentVO;
import com.fluig.sdk.service.DocumentService;
import com.itextpdf.html2pdf.HtmlConverter;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.totvs.technology.wcm.sdk.rest.WCMRest;
import com.widgetpublica.util.ErrorStatus;
import com.widgetpublica.util.MergeFiles;
import com.widgetpublica.util.RestConstant;

@Path("/service")
public class ServiceRest extends WCMRest {

	@GET
	@Path("helloWorld")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHelloWorld() {
		String hello = "Hello World API!";
		Integer status = 200;

		Map<String, String> response = new HashMap<String, String>();
		response.put("chave_1", hello);

		return Response.status(status).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/publicHello")
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloPublic() {
		String hello = "Hello World API!";
		Integer status = 200;

		Map<String, String> response = new HashMap<String, String>();
		response.put("chave_1", hello);

		return Response.status(status).entity(response).type(MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/dataset")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLayouts(String params) {
		String APP_KEY = "415998177261c83957d08b85b49a98a6";//"9876-5432-1987-6543";

		JSONParser parser = new JSONParser();	

		try {

			KeyVO key = Keyring.getKeys((long) 1, APP_KEY);

			JSONObject obj = (JSONObject) parser.parse(params);

			String datasetId = (String) obj.get("datasetId");
			
			OAuthConsumer config = config(key);
			URL url = new URL(key.getDomainUrl() + "/api/public/ecm/dataset/datasets");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(RestConstant.REQUEST_METHOD_POST);
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			config.sign(conn);

			String json = "{" + "\"name\": \""+datasetId+"\"," + "\"fields\": null," + "\"constraints\": null }";

			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json);
			wr.flush();
			wr.close();

			conn.connect();

			Reader inputCreateUser = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), RestConstant.UTF_8_ENCODE));
			String result = "";
			for (int c = inputCreateUser.read(); c != -1; c = inputCreateUser.read()) {
				result += (char) c;
			}
			int code = conn.getResponseCode();
			System.out.println(String.format("RESPONSE: %d - %s: data: %s", code, conn.getResponseMessage(), result));

			conn.disconnect();
			return Response.status(code).entity(result).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	
	@POST
	@Path("/iniciarProcessoSeletivo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postIniciarProcessoSeletivo(String params) throws Exception {

		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(params);

		String nome = (String) obj.get("nome");
		String email = (String) obj.get("email");
		String telefone = (String) obj.get("telefone");
		String vaga = (String) obj.get("vaga");
		String atividadeDestino = (String) obj.get("atividade");
		String usuarioDestino = (String) obj.get("matricula");
		String comentarios = "Iniciado via pagina publica";

		int cod_empresa = 1;
		Long empresa = new Long((long) cod_empresa);

		String cod_processo = "vagas_internas";

		KeyVO key = Keyring.getKeys(empresa, RestConstant.APP_KEY);

		try {
			OAuthConsumer config = config(key);

			URL url = new URL(key.getDomainUrl() + "/process-management/api/v2/processes/" + cod_processo + "/start");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(RestConstant.REQUEST_METHOD_POST);
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			config.sign(conn);

			String json = "{" + "\"targetState\": " + atividadeDestino + "," + "\"targetAssignee\": \"" + usuarioDestino
					+ "\"," + "\"comment\": \"" + comentarios + "\"," + "\"formFields\": " + "{  " + "\"txt_nome\": \""
					+ nome + "\",  " + "\"txt_email\": \"" + email + "\",  " + "\"txt_telefone\": \"" + telefone
					+ "\",  " + "\"txt_vaga\": \"" + vaga + "\"" + "}" + "}";

			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json);
			wr.flush();
			wr.close();

			conn.connect();

			Reader inputCreateUser = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), RestConstant.UTF_8_ENCODE));
			String result = "";
			for (int c = inputCreateUser.read(); c != -1; c = inputCreateUser.read()) {
				result += (char) c;
			}
			int code = conn.getResponseCode();
			System.out.println(String.format("RESPONSE: %d - %s: data: %s", code, conn.getResponseMessage(), result));

			conn.disconnect();
			return Response.status(code).entity(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorStatus(e)).build();
		}
	}

	private OAuthConsumer config(KeyVO key) {
		OAuthConsumer consumer = new DefaultOAuthConsumer(key.getConsumerKey(), key.getConsumerSecret());
		consumer.setTokenWithSecret(key.getToken(), key.getTokenSecret());
		return consumer;
	}
}