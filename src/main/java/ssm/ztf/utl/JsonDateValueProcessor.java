package ssm.ztf.utl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/*
 * jsonshi时间格式转换
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
	private String format = "yyyy-MM-dd HH:mm:ss";

	public Object processArrayValue(Object value, JsonConfig config) {
		return process(value);
	}

	public Object processObjectValue(String arg0, Object value, JsonConfig config) {
		return process(value);
	}

	private Object process(Object value) {
		// 遇到类型为日期的，就自动转换成“yyyy-MM-dd HH:mm:ss”格式的字符串
		if (value instanceof Timestamp) {
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.UK);
			return sdf.format(value);
		}
		return value == null ? "" : value.toString();
	}

}
