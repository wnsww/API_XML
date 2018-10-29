package com.tood.data;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Api_XML {
	
	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		    Node nValue = (Node) nlList.item(0);
		    if(nValue == null) 
		        return null;
		    return nValue.getNodeValue();
		}

	public static void main(String[] args) {
		
		int page = 1;	// 페이지 초기값 
		int Endpage = 12;		//마지막 페이지 기본값()
		
		try{
			while(true){
				
				// parsing할 url 지정(API 키, page(페이지 번호) 포함해서)
				String url = "연결할 URL";
				//ex
				//"http://openapi.kepco.co.kr/service/evInfoService/getEvSearchList?"
                //+"&pageNo=(페이지 번호)&numOfRows=10"
                //+"&ServiceKey=(API 키)"
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("파싱할 tag");
				System.out.println("Tag : "+ nList.getLength());
				
					for(int i = 0; i < nList.getLength(); i++){
					
						Node nNode = nList.item(i);
						
						//파싱된 tag 안 Element
						if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
							Element element = (Element) nNode;
								System.out.println(element.getTextContent());
								System.out.println("TagValue  : " + getTagValue("tag 내 가져올 tag명", element));
						}	// if end
					}	// for end
				
				
				//페이지 다음으로 넘기는 부분
				page += 1;
				System.out.println("page  : "+page);
				
				
				if(page > Endpage){	
					break;
				}
			}	// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
	}	// main end
}// class end