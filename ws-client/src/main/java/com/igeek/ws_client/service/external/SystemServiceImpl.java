package com.igeek.ws_client.service.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Gyges on 2017/10/20
 */

@Service
public class SystemServiceImpl {

    public static final String URL = "http://192.168.1.104:7080/unistack/soap/userService?wsdl";

    public static final Logger LOGGER = LoggerFactory.getLogger(SystemServiceImpl.class);

    /**
     * acquire the token
     * @return
     */

    public  String getCertification() {
//        String result = "";
//        OkHttpResponse response = null;
//        try {
//            StringBuilder stringBuilder = new StringBuilder(URL);

//            String url = stringBuilder.append("appType=123123&")
//                    .append("loginName=mazean&")
//                    .append("passwordMD5=123456&")
//                    .append("imei=dsdfds&")
//                    .append("phoneNumber=1231214124").toString();
//            LOGGER.info(url);
//            response = OkhttpUtils.get(URL);
//        } catch (IOException e) {
//            LOGGER.error("no message response",e);
//        }
//        if (response != null) {
//            return response.getBody();
//        }
//        return null;
        return null;

    }







}
