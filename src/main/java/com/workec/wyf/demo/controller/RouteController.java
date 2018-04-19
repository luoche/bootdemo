package com.workec.wyf.demo.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 路由参数demo
 *
 * @author : wangyafei@ecqun.com
 * @date :  2018-04-18 18:08
 **/

@RestController
public class RouteController {

    // parhVariable
    @RequestMapping(value = "/demo/{ownerId}")
    public Map<String, Object> demo1(@PathVariable String ownerId) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("ownerId", ownerId);

        return map;
    }

    @RequestMapping(value = "/demo/{ownerId}/get/{petId}", method = RequestMethod.GET)
    public Map<String, Object> demo2(@PathVariable String ownerId, @PathVariable String petId) {
        // 多个请求参数，使用，分割
        Map<String, Object> map = new HashMap<>(2);
        map.put("ownerId", ownerId);
        map.put("proId", petId);

        return map;
    }

    // RequestParam

    @RequestMapping(value = {"param", "param3"}, method = RequestMethod.GET)
    public Map<String, Object> demo3(@RequestParam("ownerId") int ownerId) {
        Map<String, Object> map = new HashMap<>();
        map.put("ownerId", ownerId);
        return map;
    }

    //      /request/requestParam2?ownerId=223&a=4&c=5
    @RequestMapping(value = "param2", method = RequestMethod.GET)
    public Map<String, Object> demo4(@RequestParam Map<String, Object> map) {
        return map;
    }

    // method = get
    @GetMapping(value = "paramDefault")
    public Map<String, Object> demo5(
            @RequestParam(value = "id", required = false, defaultValue = "0") int id) {

        // question : 获取整个请求体
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", "wang-default");

        return map;
    }

    @GetMapping(value = "/entity")
    public Map<String, Object> getEntity(HttpEntity<byte[]> requestEntity) {

        Map<String, Object> map = new HashMap<>();

        String requestLanguage  = requestEntity.getHeaders().getFirst("Accept-language");
        String allHeaderMessage = requestEntity.getHeaders().toString();
//        String allBody          = requestEntity.getBody().toString();
//        Byte[] requestBody = requestEntity.getBody();
        map.put("language", requestLanguage);
        map.put("header", allHeaderMessage);
//        map.put("content", allBody);

        return map;
    }

    // 获取 header 请求体的全部信息
    @GetMapping("/getHeader")
    public Map<String, Object> getHeader(@RequestHeader Map<String, Object> map) {
        return map;
    }

    // 获取 header 头的部分信息
    @GetMapping("/getHeader2")
    public Map<String, Object> getHeaderDetail(
            @RequestHeader(value = "User-Agent") String userAgentNick,
            @RequestHeader("Host") String host) {
        Map<String, Object> map = new HashMap<>();

        map.put("user-agent", userAgentNick);
        map.put("host", host);

        return map;
    }

    // form 表单的时候可以 传参为一个类 封装多个属性

    // 直接使用原生的 request 和 response
    public Map<String, Object> getHeaderServet(HttpServletRequest request,
            HttpServletResponse responset) {
        Map<String, Object> map = new HashMap<>();

        String userAgent    = request.getHeader("User-Agent");
        String host         = request.getHeader("Host");
        String cacheControl = request.getHeader("Cache-Control");

        map.put("user-agent", userAgent);
        map.put("host", host);
        map.put("cacheControl", cacheControl);

        return map;
    }

}
