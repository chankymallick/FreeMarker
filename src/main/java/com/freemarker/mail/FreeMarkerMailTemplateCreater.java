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
    public  String createAndReturnTemplateData(String Content,String Path) {
            try{
            if(Path==null){
            cfg.setDirectoryForTemplateLoading(new File("E:\\AMM_WEBLOGIC_BUILD\\FreeMarkerPOC\\src\\main\\webapp\\FreeMarkerTemplates\\"));
            }
            else
            {
            cfg.setDirectoryForTemplateLoading(new File(Path));
            }    
            Template tmpt= cfg.getTemplate("MappingEmailTemplate.ftl");
            
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
    public  String createAndReturnTemplateDataMapping(String Content,String Path,String mid,String createdby,String pname,String mname) {
            try{
            if(Path==null){
            cfg.setDirectoryForTemplateLoading(new File("E:\\AMM_WEBLOGIC_BUILD\\FreeMarkerPOC\\src\\main\\webapp\\FreeMarkerTemplates\\"));
            }
            else
            {
            cfg.setDirectoryForTemplateLoading(new File(Path));
            }    
            Template tmpt= cfg.getTemplate("MappingEmailTemplate.ftl");
            
            Map <String,Object> data = new HashMap<String,Object>();
            data.put("message",Content );  
            data.put("mapid",mid );  
            data.put("mapname",mname );  
            data.put("projectname",pname );  
            data.put("createdby",createdby );  
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
