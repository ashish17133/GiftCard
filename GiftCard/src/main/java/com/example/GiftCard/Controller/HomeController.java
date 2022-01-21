package com.example.GiftCard.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	@RequestMapping(value="/mockGift",method=RequestMethod.GET)
	public String getPage(HttpServletRequest request,HttpServletResponse response, Model model) {
		String query=request.getQueryString();
		String[] queryData=query.split("=");
		
		switch ((Integer.parseInt(queryData[1]))) {
			case 1:
				return "amazon";
			case 2:
				return "DSW";
			case 3:
				return "ABCD";
			default:
				return "Error";
		}
	}
	
	@RequestMapping(value="/restApi",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpServletResponse getRestData(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String query=request.getQueryString();
		
		String[] queryData=query.split("=");
		int dataIndex=Integer.parseInt(queryData[1]);
		ObjectMapper objectMapper= new ObjectMapper();
		
		if(ConstantList.data.length<dataIndex) {
			
				String jsonString = objectMapper.writeValueAsString("'data':'No data found for in given Value'");
				PrintWriter send;
				send = response.getWriter();
				response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        response.setStatus(400);
		        send.print(jsonString);
		        send.flush();
			
		}else {
		String jsonString = objectMapper.writeValueAsString(ConstantList.data[dataIndex-1]);
			PrintWriter send;
			send = response.getWriter();
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.setStatus(200);
	        send.print(jsonString);
	        send.flush();
		}
	        
	        return response;
		
        
	}

}
