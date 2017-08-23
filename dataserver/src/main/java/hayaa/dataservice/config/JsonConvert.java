package hayaa.dataservice.config;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

class JsonConvert {
	public static <T> T DeserializeObject(String value,Class<T> valueType) 
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper jsonMapper=new ObjectMapper();
		T r=null;
		try {
		r=jsonMapper.readValue(value,valueType);
		} catch(Exception ex)
        {

        }
		return r;
}
}
