package com.widgetpublica.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.itextpdf.html2pdf.HtmlConverter;
import com.totvs.technology.wcm.sdk.rest.WCMRest;
import com.widgetpublica.util.MergeFiles;


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
	@Path("/appendPdfToHistory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response appendPdfToStory(String params) {

		JSONParser parser = new JSONParser();

		try {

			JSONObject obj = (JSONObject) parser.parse(params);

			String documentBase64 = (String) obj.get("documentBase64");
			String documentHistory = (String) obj.get("documentHistory");

			String fileBasePath = "resources/fileBase.pdf";
			File file = new File(fileBasePath);

			try  {
				FileOutputStream fos = new FileOutputStream(file);
				byte[] decoder = Base64.getDecoder().decode(documentBase64);
				fos.write(decoder);
				System.out.println("PDF File Saved");
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}

			List<InputStream> inputPdfList = new ArrayList<InputStream>();

			inputPdfList.add(new FileInputStream(fileBasePath));
			
			
			String histHtmlPath = "resources/historico.pdf";
			HtmlConverter.convertToPdf(documentHistory, new FileOutputStream(histHtmlPath));
			inputPdfList.add(new FileInputStream(histHtmlPath));

			// Prepare output stream for merged pdf file.
			String docAssinadoPath = "resources/docAssinado.pdf";
			OutputStream outputStream = new FileOutputStream(docAssinadoPath);

			// call method to merge pdf files.
			MergeFiles.mergePdfFiles(inputPdfList, outputStream);

			Integer status = 200;

			Map<String, String> response = new HashMap<String, String>();
			
			
			byte[] fileContent = FileUtils.readFileToByteArray(new File(docAssinadoPath));
			String encodedString = Base64.getEncoder().encodeToString(fileContent);

			response.put("docAssinado", encodedString);

			return Response.status(status).entity(response).type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
}