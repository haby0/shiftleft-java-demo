package io.shiftleft.controller;

import org.springframework.web.bind.annotation.*;
import org.dom4j.io.SAXReader;
import org.springframework.web.context.request.WebRequest;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;


@RestController
public class XxeController {
    
    @RequestMapping(value="/xmlReader/sec1", method = RequestMethod.GET)
    public String xmlReaderSec1(WebRequest request) {
        try {
            SAXReader saxReader = new SAXReader();
            saxReader.read(new InputSource(new StringReader(request.getHeader("Cookie"))));
        } catch (Exception e) {
            return null;
        }

        return "xmlReader xxe security code";
    }


    @RequestMapping(value = "/DocumentBuilder/vuln01", method = RequestMethod.POST)
    public String DocumentBuilderVuln01(WebRequest request) {
        try {
            String body = request.getHeader("Cookie");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(body);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);  // parse xml
        } catch (Exception e) {
            return null;
        }
        return "DocumentBuilder xxe security code";
    }

}
