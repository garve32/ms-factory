package com.hanwha.msdocument.controller;

import com.hanwha.mscore.context.TenantContext;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/a")
    public String a() {
        return "a";
    }

    @GetMapping("/b")
    public Map b() {
        Map<String, Object> map = new HashMap();
        map.put("a", "b");
        return map;
    }

}
