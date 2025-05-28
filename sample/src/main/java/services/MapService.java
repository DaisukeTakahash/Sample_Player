package services;

import java.util.HashMap;

public class MapService {
/**
 * 
 * @return
 */
	public HashMap<String, String>getMap() {
		
		 HashMap<String, String> map = new HashMap<>();
	        map.put("JSP", "JavaServlet Pages");
	        map.put("PHP", "PHP:Hypertext Preprocessor");
	        map.put("ASP.NET", "Active Server Page .NET");
		
		return map;
	}

}
