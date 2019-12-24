package ru.hh.kazan;

import org.w3c.dom.*;
import javax.xml.parsers.*;

import java.io.File;

public class Settings {
  public static String file = "Settings.xml";

  private static String baseUrl;
  private static String login;
  private static String password;
  private static Document document;

  public Settings() throws Exception {
    if (!new File(file).exists()){
      throw new Exception("Problem: settings file not found: " + file);
    }
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    document = builder.parse(new File( file ));
    document.getDocumentElement().normalize();
  }

  public static String getBaseUrl() {
    if (baseUrl == null){
      Element root = document.getDocumentElement();
      baseUrl = root.getElementsByTagName("baseurl").item(0).getTextContent();
    }
    return baseUrl;
  }

  public static String getLogin() {
    if (login == null){
      NodeList nList = document.getElementsByTagName("user");
      Element element = (Element) nList.item(0);
      login = element.getElementsByTagName("login").item(0).getTextContent();
    }
    return login;
  }

  public static String getPassword() {
    if (password == null){
      NodeList nList = document.getElementsByTagName("user");
      Element element = (Element) nList.item(0);
      password = element.getElementsByTagName("password").item(0).getTextContent();
    }
    return password;
  }
}
