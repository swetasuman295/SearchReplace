package com.exercise.search.replace.impl.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ProcessXmlFileTest {

	@Test
	public void test() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		String inLineXml = "<?xmlversion=\"1.0\"encoding=\"UTF-8\"standalone=\"no\"?><Docs><Doc><Id>12</Id><Phone>1234</Phone></Doc><Doc><Id>147</Id><Phone>12345</Phone><Locked>false</Locked><BID>2</BID><DocId>8</DocId><Date>2014-02-04T12:18:50.063-07:00</Date><Urgent>false</Urgent></Doc></Docs>";
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		InputStream iStream = new FileInputStream(new File("src/test/resources/SmallXmlFile.xml"));
		Document doc = documentBuilderFactory.newDocumentBuilder().parse(iStream);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;

		transformer = tf.newTransformer();
		// below code to remove XML declaration
		// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));
		String output = writer.getBuffer().toString().replaceAll("\n|\r|\\s+", "");
		System.out.println(output);
		assertEquals(inLineXml, output);
	}
	
	

}
