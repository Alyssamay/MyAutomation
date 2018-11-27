package AutoTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ProUtil {
	private static Map<String, Properties> propFileMap =new ConcurrentHashMap<String,Properties>();//key是String类型，value是properties类型
	public static Properties getProperties() {
		return getProperties("/config.properties");
	}
	public static Properties getProperties(String fileName) {
		Properties prop = propFileMap.get(fileName);//获得key对应的value值
		if (prop==null) {
			prop =new Properties();
		}
		InputStream is =null;
		try {
			is=ProUtil.class.getResourceAsStream(fileName);
			prop.load(is);//从输入流中读取属性列表
			propFileMap.put(fileName, prop);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}finally {
			if(is !=null) {
				try {
					is.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		}
		return prop;
	}

}
