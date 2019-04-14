package org.dzq.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.dzq.entity.Address;
import org.dzq.entity.Person;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONDemo {
	//1.��Map��JavaBean���ַ������ļ�->JSON����      ,����JSON�ļ�
	//a.map->JSON����
	public static void mapDemo() {
		Map<String,String> map=new HashMap<>();
		map.put("s01", "zs");
		map.put("s02", "ls");
		map.put("s03", "ww");
		map.put("s04", "zl");
		map.put("s05", "sq");
		JSONObject json=new JSONObject(map);
		System.out.println(json);
	}
	//b.JavaBean->JSON����
	public static void javaBeanDemo() {
		Person person=new Person();
		person.setName("zs");
		person.setAge(13);
		Address address=new Address("����","�ϲ�");
		person.setAddress(address);
		JSONObject json=new JSONObject(person);
		System.out.println(json);
	}
	//c.�ַ���->JSON����
	public static void stringDemo() {
		String Str="{\"address\":{\"schoolAddress\":\"�ϲ�\",\"homeAddress\":\"����\"},\"name\":\"zs\",\"age\":13}";
		JSONObject json=new JSONObject(Str);
		System.out.println(json);
	}
	//d.�ļ�->JSON����(�ļ�->�ַ���->JSON����)
	public  void fileDemo() throws IOException {
		/*InputStream inputStream = super.getClass().getClassLoader().getResourceAsStream("org/dzq/json/per.json");
		byte[] bs=new byte[10];
		int len=-1;
		StringBuffer sb=new StringBuffer();
		while((len=inputStream.read(bs))!=-1) {
			String str = new String(bs,0,len);
			sb.append(str);
		}
		String result=sb.toString();*/
		String result=FileUtils.readFileToString(new File("C:\\Users\\xxx-d2q\\eclipse-workspace\\JSONProject\\src\\org\\dzq\\json\\per.json"));
		JSONObject json=new JSONObject(result);
		System.out.println(json);
	}
	//e.����JSON�ļ�
	public static void JSONFileDemo() throws JSONException, IOException {
		Map<String,Person> map=new HashMap<>();
		Person one=new Person("zs",5,new Address("����","֥�Ӹ�"));
		Person two=new Person("ls",6,new Address("������","�鶼"));
		Person three=new Person("ww",7,new Address("����","Ƥ����"));
		map.put("zs", one);
		map.put("ls", two);
		map.put("ww", three);
		JSONObject json =new JSONObject(map);
		Writer writer = new FileWriter("e:\\p.txt");
		json.write(writer);
		writer.close();
	}
	//String->JSONArray
	public static void JSONArrayDemo() {
		String jArray="[{\"name\":\"zs\",\"age\":13,\"address\":\"����\"},{\"name\":\"ls\",\"age\":18,\"address\":\"����\"},{\"name\":\"ww\",\"age\":24,\"address\":\"֣��\"}]";
		JSONArray jsonarray=new JSONArray(jArray);
		System.out.println(jsonarray);
	}
	//map->JSONArray    �����С��ȫ����jar��
	public static void JSONArrayDemo2() {
		Map<String,String> map=new HashMap<>();
		map.put("s01", "zs");
		map.put("s02", "ls");
		map.put("s03", "ww");
		map.put("s04", "zl");
		map.put("s05", "sq");
		net.sf.json.JSONArray jArray=new net.sf.json.JSONArray();
		jArray=jArray.fromObject(map);
		System.out.println(jArray);
	}
	//JSONArray->map
	public static void JSONArrayDemo3() {
		String jArraystr="[{\"names\":\"zs\",\"age1\":13,\"address1\":\"����\"},{\"nameb\":\"ls\",\"age2\":18,\"address2\":\"����\"},{\"name\":\"ww\",\"age3\":24,\"address3\":\"֣��\"}]";
		net.sf.json.JSONArray jArray=new net.sf.json.JSONArray();
		jArray=jArray.fromObject(jArraystr);
		System.out.println(jArray);
		Map<String,Object> map=new HashMap<>();
		for(int i=0;i<jArray.size();i++) {
			net.sf.json.JSONObject json = (net.sf.json.JSONObject)jArray.get(i);
			Set<String> keySet = json.keySet();
			for(String key:keySet) {
				 Object value= json.get(key);
				 map.put(key, value);
			}
		}
		System.out.println(map);
	}
	public static void main(String[] args) throws IOException {
		//mapDemo();    				//a
		//javaBeanDemo();				//b
		//stringDemo();					//c
		//JSONDemo jd=new JSONDemo();	//d
		//jd.fileDemo();
		//JSONFileDemo();				//e
		//JSONArrayDemo();   			//arraydemo1
		//JSONArrayDemo2();				//arraydemo2
		JSONArrayDemo3();
	}
}
