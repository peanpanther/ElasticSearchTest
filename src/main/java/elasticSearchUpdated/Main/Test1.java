package elasticSearchUpdated.Main;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import elasticSearchUpdated.Model.Employee;
import elasticSearchUpdated.Utils.CURD;

public class Test1 {

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException, SigarException {
		Sigar sigar = new Sigar();
		sigar.getCpu();
		Node node = nodeBuilder().clusterName("peansData").node();
		Client client = node.client();
		CURD.insertDocument(client, "mimos", "Programmer", "1");
		CURD.getDocument(client, "mimos", "Programmer", "1");
		Employee emp1 = new Employee("pean", "18562", "21");
		Employee emp2 = new Employee("zubir", "2334534", "11");
		Employee emp3 = new Employee("koko", "00099", "08");

		ObjectMapper mapper = new ObjectMapper();
		String emp4 = mapper.writeValueAsString(emp1);
		String emp5 = mapper.writeValueAsString(emp2);
		String emp6 = mapper.writeValueAsString(emp3);

		// CURD.insertDocument2(client, "Programmer", "1", "mimos", emp4); //
		CURD.insertDocument2(client, "Programmer", "2", "mimos", emp5); //
		CURD.insertDocument2(client, "Programmer", "3", "mimos", emp6);

		// CURD.getDocument(client, "mimos", "Programmer", "1");

		client.prepareIndex("mimos", "programmer", "1").setSource(emp4).get();
		client.prepareIndex("mimos", "programmer", "2").setSource(emp5).get();
		client.prepareIndex("mimos", "programmer", "3").setSource(emp6).get();

		List<Map<String, Object>> esData = CURD.getAllDocs(client, "mimos",
				"programmer");
		System.out.println(esData);
		Node connection = nodeBuilder().node(); // closing node
												// connection.close();

	}
}
