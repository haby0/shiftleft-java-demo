package io.shiftleft.controller;

import org.springframework.web.bind.annotation.*;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;
import java.io.*;


@RestController
public class XxeController {
    
    @RequestMapping(value="/xmlReader/sec1", method = RequestMethod.GET)
    public String xmlReaderSec1(@RequestParam String data) {
        try {
            SAXReader saxReader = new SAXReader();
            saxReader.read(new InputSource(new StringReader(data)));
        } catch (Exception e) {
            return null;
        }

        return "xmlReader xxe security code";
    }

}
