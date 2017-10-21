package com.igeek.ws_client.service.external;


import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Service;
import com.igeek.ws_client.pojo.HelloWorld;
import com.igeek.ws_client.pojo.Response;

/**
 * Created by Gyges on 2017/10/21
 */

@Service
public class WsClientService {

    private JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    private static final String HELLO_URL = "http://localhost:8080/ws-server-1.0/api/hello";

    /**
     * helloService method
     * @param args parm
     * @return
     */
    public Response getHelloResult(String args) {
        factory.setAddress(HELLO_URL);
        factory.setServiceClass(HelloWorld.class);
         HelloWorld client = (HelloWorld) factory.create();
        return client.sayHi(args);
    }

}
