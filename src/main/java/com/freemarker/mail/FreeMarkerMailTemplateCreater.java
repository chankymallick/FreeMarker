/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mallick
 */
public class FreeMarkerMailTemplateCreater {
    Configuration cfg = new Configuration();
    public  String createAndReturnTemplateData(String Content) {
            try{
            cfg.setDirectoryForTemplateLoading(new File("E:\\AMM_WEBLOGIC_BUILD\\FreeMarkerPOC\\src\\main\\webapp\\FreeMarkerTemplates\\"));
            Template tmpt= cfg.getTemplate("EmailTemplateNewMap.ftl");
            
            Map <String,Object> data = new HashMap<String,Object>();
            data.put("message",Content );  
            Writer out = new StringWriter(); 
            tmpt.process(data, out);
            out.flush();
            return out.toString();
        } catch (Exception e) {            
            System.out.println(e);
            return "";
        }
    }
}
