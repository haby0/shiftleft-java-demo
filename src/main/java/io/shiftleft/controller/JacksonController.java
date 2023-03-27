package io.shiftleft.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JacksonController {

    @RequestMapping(value="/jackson/sec1", method = RequestMethod.GET)
    public String JacksonSec1(@RequestParam String data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        Object obj = mapper.readValue("aaaa", Object.class);
        return mapper.writeValueAsString(obj);
    }
}
