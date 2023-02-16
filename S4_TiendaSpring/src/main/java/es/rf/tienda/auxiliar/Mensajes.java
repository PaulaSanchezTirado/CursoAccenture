package es.rf.tienda.auxiliar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Mensajes {
	
	public static Map<String, Object> Mensaje (String code, String mensaje, Object c){
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.clear();
		map.put("status", code);
		map.put("message", mensaje);
		map.put("data", c);
		return map;
	}
}
