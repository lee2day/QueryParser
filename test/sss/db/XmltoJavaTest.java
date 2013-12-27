package sss.db;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.junit.Test;

public class XmltoJavaTest {

	@Test
	public void test() throws Exception {

		String path = "C:/Labs/KEB/webapps/ng2g/WEB-INF/xml/query/dp/DP0001_Query.xml";
		File file = new File(path);

		JAXBContext jaxbContext = JAXBContext.newInstance(SqlElement.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		SqlElement sql = (SqlElement) jaxbUnmarshaller.unmarshal(file);
		System.out.println(sql);

	}

}

@XmlRootElement(name = "sql-resource")
@XmlAccessorType (XmlAccessType.FIELD)
class SqlElement {

	@XmlAttribute(name = "name")
	String resourceName;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@XmlElement(name = "query")
	List<Query> list ;

	public void setList(List<Query> query) {
		this.list = query;
	}

	public List<Query> getList() {
		return list;
	}
}

@XmlRootElement(name = "query")
@XmlAccessorType (XmlAccessType.FIELD)
class Query {

	@XmlAttribute(name = "name")
	String name;

	@XmlValue
	String query;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return query;
	}
	public void setContent(String content) {
		this.query = content;
	}

	public String toString() {

		return name + " : " + query;
	}
}