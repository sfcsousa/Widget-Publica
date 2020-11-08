package com.widgetpublica.services;

import com.widgetpublica.wsdl.client.ECMDocumentService.Attachment;
import com.widgetpublica.wsdl.client.ECMDocumentService.AttachmentArray;
import com.widgetpublica.wsdl.client.ECMDocumentService.DocumentService;
import com.widgetpublica.wsdl.client.ECMDocumentService.ECMDocumentServiceService;
import com.widgetpublica.wsdl.client.ECMDocumentService.Exception_Exception;

public class DocumentServiceClient {
	private DocumentService docService = null;
	
	public DocumentServiceClient(){		
		ECMDocumentServiceService dsService = new ECMDocumentServiceService();
		this.docService = dsService.getDocumentServicePort();
	}
	public void updateDocument(int documentId, String documentDescription) throws Exception_Exception {
		
		AttachmentArray attachments = new AttachmentArray();
		Attachment updated = new Attachment();
		
		updated.setFileName(documentDescription);
		updated.setAttach(false);
		updated.setEditing(false);
		
		byte [] value = null; 
		
		updated.setFilecontent(value);
		updated.setPrincipal(true);
		
		
		attachments.getItem().add(updated);
		docService.updateSimpleDocument("admin", "P@ssw0rd", 1, documentId, "admin", documentDescription, attachments);
		
	}

}
