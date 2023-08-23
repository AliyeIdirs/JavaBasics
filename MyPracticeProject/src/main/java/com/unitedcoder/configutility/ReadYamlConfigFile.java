package com.unitedcoder.configutility;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class ReadYamlConfigFile {
    public static void main(String[] args) {
        Object config=initializeConfig("TestData","config.yaml");
        readProperty(config,"username");
        readProperty(config,"password");
        readProperty(config,"testUrl");
    }

    //read a yaml config file as an object
    public static Object initializeConfig(String filePath, String configFileName){
        String workingDir= System.getProperty("user.dir");
        String yamlFilePath=workingDir+ File.separator+filePath+File.separator+configFileName;
        File configFile=new File(yamlFilePath);
        YamlReader reader= null;
        try {
            reader = new YamlReader(new FileReader(configFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Object commonConfigObject= null;
        try {
            commonConfigObject = reader.read();
        } catch (YamlException e) {
            throw new RuntimeException(e);
        }
        return commonConfigObject;
    }
    //read a key from yaml object
    public static String readProperty(Object object, String key){
        //create a map for key value pair object
        Map map=(Map)object;
        String value=(String)map.get(key);
        System.out.println("Key= "+key+" Value= "+value);
        return value;
    }
}
