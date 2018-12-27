package com.bit.pro;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.java.StockSvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;;

@Controller
public class ApiExplorer{
	
	private static String ServiceKey ="JxtMZygjNXGZXV0NjqtD1Lpx56R%2F39ryIh2Akp998cATtP8coB6FDp0%2BtaAKKslq2EL1CWjWIDSJJZ4ZkRKbjw%3D%3D";
	
	@Autowired
	private StockSvc svc;

	public void setSvc(StockSvc svc) {
		this.svc = svc;
	}

	@RequestMapping(value="/getStkIsinByNmN1.js",produces="text/plain;charset=utf-8")
	@ResponseBody
	public  String getStkIsinByNmN1(String secnNm,@RequestParam(value="pageNo", defaultValue="1") int pageNo) throws IOException {
		
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(svc.getStkIsinByNmN1(pageNo, secnNm));
        
        URL url = new URL(urlBuilder.toString());
       
        InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream(),"UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        String str ="";
        
    	try {
			str = mapper.writeValueAsString(isr.toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
        
       return str;
    }
}