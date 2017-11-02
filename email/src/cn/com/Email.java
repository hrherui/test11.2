package cn.com;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.sound.sampled.Line;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Email{// extends JapidMailer
	public static String email(){
		
		String element = null;
		File input = new File("E://www.html");
		try {
			Document document = Jsoup.parse(input, "UTF-8", "http://www.jb51.net/");
			 Elements elements=(Elements) document.select("body");//table[id=mainTable]
			 Elements head=(Elements) document.select("head");
			 /*for (Element element1 : elements) {
					System.out.println(element1.text());
				}*/
			 element=head.html();
			element=element+elements.html();
//			 System.out.println(elements.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(element);
	    return element;
	}
public static List<String> getName(){
		List<String> element = new ArrayList<String>();
		File input = new File("E://www.html");
		try {
			Document document = Jsoup.parse(input, "UTF-8", "http://www.jb51.net/");
			 Elements elements=(Elements) document.select("tbody>tr[height=18]:not(#r59)>td[class=x22]:eq(1)");
			 for (Element element1 : elements) {
					System.out.println(element1.text());
					element.add(element1.text());
				}
			 System.out.println(elements.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(element);
	    return element;
	}
public static List<String> getId(){
	List<String> element = new ArrayList<String>();
	File input = new File("E://www.html");
	try {
		Document document = Jsoup.parse(input, "UTF-8", "http://www.jb51.net/");
		Elements elements=(Elements) document.select("tbody>tr[height=18]:not(#r59)>td[class=x34]:eq(0)");
		for (Element element1 : elements) {
			System.out.println(element1.text());
			element.add(element1.text());
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//		System.out.println(element);
	return element;
}
	public static void createHtml(){
		String srcFile="index.html";
		File file=new File("E://",srcFile);
		if(email()!=null||!email().equals("")){
			System.out.println("-------------------------------------------------------------");
			
			FileReader fr = null;
			BufferedReader br = null;
			FileWriter fw = null;
			try {
				if(file.exists()){
					file.delete();
					file.createNewFile();
				}else{
					file.createNewFile();
				}
				//读取模版HTM代码
				 fr=new FileReader("E://"+srcFile);
				 br=new BufferedReader(fr);//建立BufferedReader对象，并实例化为br
				 fw=new FileWriter("E://"+srcFile);
				 String encoding="<%@ page language="+"\"java\""+
						 "pageEncoding=\"UTF-8\"%>"+"<%@ page " +
						 		"contentType="+"\"text/html;charset=iso8859-1\"%>";
				//fw.write(email());
				System.out.println(email());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();//关闭BufferedReader对象
				fw.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
//		getName();
		email();
//		createHtml();
//		getId();
	}
}