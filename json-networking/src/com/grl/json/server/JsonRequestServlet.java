		package com.grl.json.server;


import java.io.IOException;

import javax.servlet.http.*;

import org.codehaus.jackson.map.ObjectMapper;

import com.grl.json.messages.ErrorResponse;
import com.grl.json.messages.Request;
import com.grl.json.messages.Response;


@SuppressWarnings("serial")
public class JsonRequestServlet extends HttpServlet{
	private boolean debugActive;
	
	
	public void setDebugMode(boolean debug){
		this.debugActive = debug;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		setDebugMode(true);
		
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession(true);
		session.getId();
		
		session.setAttribute("request_path", req.getServletPath());
		
		try {
			Response responseMessage;
			try{
				Request requestMessage = mapper.readValue(req.getInputStream(), Request.class);
				
				responseMessage = requestMessage.performService(session);
			} 
			catch (Throwable e){
				if(debugActive){
					responseMessage = new ErrorResponse(e);
					e.printStackTrace();
				}
				else{
					responseMessage = new ErrorResponse(e.getMessage());
				}
			}
			resp.setContentType("application/json");
			mapper.writeValue(resp.getOutputStream(), responseMessage);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
