package com.gywy.gms.config;

import org.apache.ibatis.datasource.DataSourceFactory;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {

	public static final String DATA_SOURCE_FILE = "data-source.properties";

	public static final String SETTING_FILE = "setting.properties";

	public static Properties loadFromResource(String fileName) {
		Properties properties = null;
		InputStream in = null;
		try {
			try {
				in = DataSourceFactory.class.getResourceAsStream("/"+fileName);
				properties = new Properties();
				properties.load(in);
			} finally {
				if (in != null)
					in.close();
			}
    	} catch (IOException e) {
			e.printStackTrace();
		}
        return properties;
	}

	public static Properties loadFromExternal(String fileName) {
		Properties properties = null;
		InputStream in = null;

		if(!fileName.contains("/")) {
			fileName = externalDir() + fileName;
		}

		try {
			try {
				if(!new File(fileName).exists()) {
					return null;
				}
				in = new FileInputStream(fileName);
				properties = new Properties();
				properties.load(in);
			} finally {
				if (in != null)
					in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

        return properties;
	}

	public static String externalDir() {
		return System.getProperty("user.home") + "/";
	}

	public static void save(Properties properties,String fileName) throws Exception {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(externalDir() + fileName);
			properties.store(out, "setting");
		} finally {
			if (out != null) out.close();
		}

	}

	public static boolean exists(String fileName) {
		if(!fileName.contains("/")) {
			fileName = externalDir() + fileName;
		}
		return new File(fileName).exists();
	}
}
