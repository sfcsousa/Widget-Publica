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
	@Path("layouts/{tenantId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLayouts(@PathParam("tenantId") Long tenantId) {
		String APP_KEY = "9876-5432-1987-6543";
		String UTF_8_ENCODE = StandardCharsets.UTF_8.name();

		try {
			KeyVO key = Keyring.getKeys(tenantId, APP_KEY);
			OAuthConsumer consumer = new DefaultOAuthConsumer(key.getConsumerKey(), key.getConsumerSecret());
			consumer.setTokenWithSecret(key.getToken(), key.getTokenSecret());

			URL url = new URL(key.getDomainUrl() + "/page-management/api/v2/layouts");

			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			consumer.sign(urlConnection);
			urlConnection.connect();

			Reader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), UTF_8_ENCODE));
			String retLayout = "";

			for (int c = input.read(); c != -1; c = input.read()) {
				retLayout += (char) c;
			}

			int code = urlConnection.getResponseCode();
			urlConnection.disconnect();
			return Response.status(code).entity(retLayout).build();

		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path("/appendPdfToHistory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postAppendPdfToHistory(String params) throws ParseException {

		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(params);

		String base64 = (String) obj.get("documentBase64");
		String historico = (String) obj.get("documentHistory");

		try {

			File file = new File("./baseFile.pdf");

			FileOutputStream fos = new FileOutputStream(file);
			// To be short I use a corrupted PDF string, so make sure to use a valid one if
			// you want to preview the PDF file
			byte[] decoder = Base64.getDecoder().decode(base64);
			fos.write(decoder);

			String template = historico;

			HtmlConverter.convertToPdf(template, new FileOutputStream("./historico.pdf"));

			List<InputStream> inputPdfList = new ArrayList<InputStream>();
			inputPdfList.add(new FileInputStream("./baseFile.pdf"));
			inputPdfList.add(new FileInputStream("./historico.pdf"));

			// prepare output stream for merged pdf file.
			OutputStream outputStream = new FileOutputStream("./docAssinado.pdf");

			// call method to merge pdf files.
			MergeFiles.mergePdfFiles(inputPdfList, outputStream);

			System.out.println("PDF File Saved");

			byte[] imageBytes = FileUtils.readFileToByteArray(new File("./docAssinado.pdf"));
			String imageStr = Base64.getEncoder().encodeToString(imageBytes);

			Map<String, String> response = new HashMap<String, String>();
			response.put("docAssinado", imageStr);

			File histFile = new File("./historico.pdf");
			File docAssinado = new File("./docAssinado.pdf");
			File baseFile = new File("./baseFile.pdf");

			if (histFile.delete()) {
				System.out.println("File deleted successfully");
			} else {
				System.out.println("Failed to delete the file");
			}
			if (docAssinado.delete()) {
				System.out.println("File deleted successfully");
			} else {
				System.out.println("Failed to delete the file");
			}

			if (baseFile.delete()) {
				System.out.println("File deleted successfully");
			} else {
				System.out.println("Failed to delete the file");
			}
			return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build();

		} catch (Exception e) {
			System.out.println("Erro ao retornar o arquivo ");
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorStatus(e)).build();
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