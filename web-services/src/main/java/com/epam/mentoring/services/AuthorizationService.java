package com.epam.mentoring.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.epam.mentoring.types.AuthorizationCredential;

@WebService(name = "AuthorizationService", targetNamespace = "http://web-services")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public interface AuthorizationService {

	@WebMethod(operationName = "authorization")
	@RequestWrapper(targetNamespace = "http://web-services/jaxws/types", className = "com.epam.mentoring.types.AuthorizationCredential")
	@ResponseWrapper(targetNamespace = "http://web-services/jaxws/types", className = "java.lang.Boolean")
	public Boolean authorization(
			@WebParam(targetNamespace = "http://web-services/jaxws/types", name = "credential", mode = Mode.IN) AuthorizationCredential credential);
}
