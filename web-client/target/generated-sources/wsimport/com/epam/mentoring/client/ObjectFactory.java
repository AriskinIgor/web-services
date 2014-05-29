
package com.epam.mentoring.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.mentoring.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AuthorizationCredential_QNAME = new QName("http://web-services", "authorizationCredential");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.mentoring.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthorizationCredential }
     * 
     */
    public AuthorizationCredential createAuthorizationCredential() {
        return new AuthorizationCredential();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizationCredential }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web-services", name = "authorizationCredential")
    public JAXBElement<AuthorizationCredential> createAuthorizationCredential(AuthorizationCredential value) {
        return new JAXBElement<AuthorizationCredential>(_AuthorizationCredential_QNAME, AuthorizationCredential.class, null, value);
    }

}
