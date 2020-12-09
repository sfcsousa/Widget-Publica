package com.widgetpublica.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSmartCopy;

public class MergeFiles {

	public static void mergePdfFiles(List<InputStream> inputPdfList,
	        OutputStream outputStream) throws Exception{
	    //Create document and pdfReader objects.
	    List<PdfReader> readers = 
	            new ArrayList<PdfReader>();
	    int totalPages = 0;

	    //Create pdf Iterator object using inputPdfList.
	    Iterator<InputStream> pdfIterator = 
	            inputPdfList.iterator();

	    // Create reader list for the input pdf files.
	    while (pdfIterator.hasNext()) {
	            InputStream pdf = pdfIterator.next();
	            PdfReader pdfReader = new PdfReader(pdf);
	            readers.add(pdfReader);
	            totalPages = totalPages + pdfReader.getNumberOfPages();
	    }

	    Document document = new Document();

	    PdfCopy copy = new PdfSmartCopy(document, outputStream);
	    //Open document.
	    document.open();

	    Iterator<PdfReader> iteratorPDFReader = readers.iterator();

	    // Iterate and process the reader list.
	    while (iteratorPDFReader.hasNext()) {
	            PdfReader pdfReader = iteratorPDFReader.next();
	            copy.addDocument(pdfReader);
	            pdfReader.close();
	    }

	    //Close document and outputStream.
	    outputStream.flush();
	    document.close();
	    outputStream.close();

	    System.out.println("Pdf files merged successfully.");
	}
}
