package com.igeek.ws_client.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.igeek.ws_client.pojo.Response;
import com.igeek.ws_client.service.external.WsClientService;

import javax.annotation.Resource;

/**
 * Created by Gyges on 2017/10/21
 * @author mazean
 */
@Controller
@RequestMapping("/api")
public class WsClientController {

    @Resource
    private WsClientService wsClientService;


    @ApiOperation(value = "获取问候信息",notes = "获取json")
    @ApiImplicitParams({@ApiImplicitParam(name = "name",value = "名字", required = true, dataType = "String",paramType = "query")})
    @RequestMapping(value = "/getResult",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response getResult(String name) {
        return wsClientService.getHelloResult(name);
    }
}
