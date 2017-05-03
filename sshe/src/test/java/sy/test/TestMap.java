package sy.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class TestMap {

	@Test
	public void T15() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("name", "孙宇");
		m.put("pwd", "132456");
		for (Object o : m.keySet()) {
			System.out.println(o);
			System.out.println(m.get(o));
		}
	}

	public void T14() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Object,Object> entry = it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key+":"+value);
		}
	}

}
