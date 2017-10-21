
package com.igeek.ws_client.pojo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWorld", targetNamespace = "http://webservice.ws_server.igeek.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWorld {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.igeek.ws_server.webservice.Response
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://webservice.ws_server.igeek.com/", className = "com.igeek.ws_client.pojo.SayHi")
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://webservice.ws_server.igeek.com/", className = "com.igeek.ws_client.pojo.SayHiResponse")
    public Response sayHi(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

}
