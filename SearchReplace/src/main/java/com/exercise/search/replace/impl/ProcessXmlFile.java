package com.exercise.search.replace.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.exercise.search.replace.model.Model;

public class ProcessXmlFile {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessXmlFile.class);

	public void xmlReadWrite(Model model)
			throws IOException, ParserConfigurationException, SAXException, TransformerException {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(new File(model.getSourceFile()));

		String str = convertDocumentToString(xmlDocument);

		Document doc = convertStringToDocument(str.replaceAll(model.getSearchWord(), model.getReplaceWord()));
		DOMSource source = new DOMSource(doc);
		FileWriter writer = new FileWriter(new File(model.getDestinationFile()));

		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	}

	/**
	 * @Description: Method to Convert Xml File to String without Losing Xml
	 *               Characteristics
	 * @param doc
	 * @return
	 */
	private String convertDocumentToString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString();
			return output;
		} catch (TransformerException e) {
			LOGGER.error("Error while transforming Xml to String "+e.getMessage());
		}

		return null;
	}

	/**
	 * @Description: Method to Convert Xml File to String without Losing Xml
	 *               Characteristics
	 * @param doc
	 * @return
	 */
	private Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			
			return builder.parse(new InputSource(new StringReader(xmlStr)));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

}