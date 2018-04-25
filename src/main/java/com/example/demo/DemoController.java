package com.example.demo;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class DemoController {

    private static final Gson GSON = new Gson();

    @RequestMapping("/index/{param}")
    public @ResponseBody
    ArrayList<String> get(@PathVariable("param") int i) {
        ArrayList<String> integers = new ArrayList<>();
        integers.add(getHash(i, "tech"));
        integers.add(getHash(i, "master"));
        integers.add(getHash(i, "installer"));
        integers.add(getHash(i, "test"));
        return integers;
    }

    private String getHash(int i, String type) {
        int value = Math.abs((type + i).hashCode()) % 10000;
        return Strings.padStart(String.valueOf(value), 4, '0');
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
}
