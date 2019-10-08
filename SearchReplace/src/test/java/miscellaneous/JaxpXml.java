package miscellaneous;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.stream.IntStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JaxpXml {

	private Document input;

	public static String JaxpXmlModify() throws TransformerException, ParserConfigurationException, SAXException,
			IOException, XPathExpressionException {
		String path = "src/main/resources/test.xml";
		JaxpXml transformer = new JaxpXml(path);
		String attribute = "";
		String oldValue = "1234";
		String newValue = "9632789211";

		return transformer.modifyAttribute(attribute, oldValue, newValue);
	}

	public JaxpXml(String resourcePath) throws SAXException, IOException, ParserConfigurationException {
		// 1- Build the doc from the XML file
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		this.input = factory.newDocumentBuilder().parse(resourcePath);
	}

	public String modifyAttribute(String attribute, String oldValue, String newValue)
			throws XPathExpressionException, TransformerFactoryConfigurationError, TransformerException, IOException {

		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList nodes = (NodeList) xpath.evaluate(String.format("//*[contains(@%s, '%s')]", attribute, oldValue),
				this.input, XPathConstants.NODESET);

		IntStream.range(0, nodes.getLength()).mapToObj(i -> (Element) nodes.item(i))
				.forEach(value -> value.setAttribute(attribute, newValue));

		TransformerFactory factory = TransformerFactory.newInstance();
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		Transformer xformer = factory.newTransformer();
		xformer.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer output = new StringWriter();
		xformer.transform(new DOMSource(this.input), new StreamResult(output));
		FileWriter writer = new FileWriter("src/main/resources/testmodified.xml");
		String newVal = output.toString().replaceAll(oldValue, newValue);
		writer.write(newVal);
		writer.close();
		return output.toString();
	}
}