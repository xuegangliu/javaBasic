import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

public class PropertyUtils {
	protected static ResourceBundle systempropertys =ResourceBundle.getBundle("system");
	
	/**
	 * 
	 * @Description:根据key，获取配置文件值   配置信息入：“CARD-TYPE-01:16,CARD-TYPE-02:19”，返回map
	 * @param    key  propertyp配置key
	 * @param  separator   配置的分隔符，可以为null，默认以“,”分隔
	 * @return     返回Map<String,String>
	 * @throws
	 */
	public static Map<String,String> getPropertyForKey(String key,String separator){
		Map<String,String> result = new HashMap<String,String>();
		if(StringUtils.isBlank(separator)){
			separator=",";
		}
		String propertyValue = systempropertys.getString(key);
		if(StringUtils.isNotBlank(propertyValue)){
			String[] properArray = propertyValue.split(separator);
			if(properArray !=null && properArray.length>0){
				for(int i=0;i<properArray.length;i++){
					String[] temp = properArray[i].split(":");
					result.put(temp[0],temp[1]);
				}
			}
		}
		return result;
	}
}
