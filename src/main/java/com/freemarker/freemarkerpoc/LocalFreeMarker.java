/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freemarker.freemarkerpoc;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mallick
 */
public class LocalFreeMarker {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        try {
            cfg.setDirectoryForTemplateLoading(new File("E:\\AMM_WEBLOGIC_BUILD\\FreeMarkerPOC\\src\\main\\webapp\\FreeMarkerTemplates\\"));
            Template tmpt= cfg.getTemplate("free.ftl");
            Map <String,Object> data = new HashMap<String,Object>();
            data.put("message", "helloworld");
            List <String> countries = new ArrayList<String>();
            countries.add("India");
            countries.add("Pakistan");
            countries.add("Bangladesh");
            countries.add("Sri lanka");
            data.put("countries",countries);
            Writer out = new OutputStreamWriter(System.out); 
            tmpt.process(data, out);
            out.flush();
           Writer file = new FileWriter (new File("D:\\FTL_helloworld.txt"));
           tmpt.process(data, file);
           file.flush();
           file.close();
        } catch (Exception e) {            
            System.out.println(e);
        }
    }
    
}
