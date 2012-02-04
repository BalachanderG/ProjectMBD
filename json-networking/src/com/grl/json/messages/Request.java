package com.grl.json.messages;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class Request{
	abstract public Response performService(HttpSession clientSessionScope);
}
