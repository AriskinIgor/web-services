
package com.epam.mentoring.client.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b05 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AuthorizationService", targetNamespace = "http://web-services")
public class AuthorizationService_Service
    extends Service
{

    private final static URL AUTHORIZATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException AUTHORIZATIONSERVICE_EXCEPTION;
    private final static QName AUTHORIZATIONSERVICE_QNAME = new QName("http://web-services", "AuthorizationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/web-services/AuthorizationService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AUTHORIZATIONSERVICE_WSDL_LOCATION = url;
        AUTHORIZATIONSERVICE_EXCEPTION = e;
    }

    public AuthorizationService_Service() {
        super(__getWsdlLocation(), AUTHORIZATIONSERVICE_QNAME);
    }

    public AuthorizationService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), AUTHORIZATIONSERVICE_QNAME, features);
    }

    public AuthorizationService_Service(URL wsdlLocation) {
        super(wsdlLocation, AUTHORIZATIONSERVICE_QNAME);
    }

    public AuthorizationService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AUTHORIZATIONSERVICE_QNAME, features);
    }

    public AuthorizationService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthorizationService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AuthorizationService
     */
    @WebEndpoint(name = "AuthorizationServicePort")
    public AuthorizationService getAuthorizationServicePort() {
        return super.getPort(new QName("http://web-services", "AuthorizationServicePort"), AuthorizationService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuthorizationService
     */
    @WebEndpoint(name = "AuthorizationServicePort")
    public AuthorizationService getAuthorizationServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://web-services", "AuthorizationServicePort"), AuthorizationService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AUTHORIZATIONSERVICE_EXCEPTION!= null) {
            throw AUTHORIZATIONSERVICE_EXCEPTION;
        }
        return AUTHORIZATIONSERVICE_WSDL_LOCATION;
    }

}
