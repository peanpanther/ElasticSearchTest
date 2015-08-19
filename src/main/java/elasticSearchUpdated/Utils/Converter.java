package elasticSearchUpdated.Utils;

import java.util.Map;

import org.elasticsearch.action.get.GetResponse;

public class Converter {
	public static <K, V> void toMap(GetResponse response) {
		Map<K, V> map = (Map<K, V>) response.getSourceAsMap();
		System.out.println("Map inserted : " + map);
	}
}
