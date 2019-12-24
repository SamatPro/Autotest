package ru.hh.kazan.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.hh.kazan.models.ResumeData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotNull;

public class TestDataGenerator {
  public static void main(String[] args) throws IOException {
    String type = "groups";
    int count = 3;
    String filename = "groups.xml";
    String format = "xml";
    if (type.equals("groups"))
    {
      generateForGroups(count, filename, format);
    }
    else
    {
      System.out.println("Unrecognized type of data" + type);
    }
  }
  static void generateForGroups(int count, String filename, String format) throws IOException{
    List<ResumeData> groups = new ArrayList<ResumeData>();
    for (int i = 0; i < count; i++)
    {
      ResumeData resumeData = new ResumeData();
      resumeData.setFirstName(generateRandomString(10));
      resumeData.setLastName(generateRandomString(11));
      resumeData.setDateOfBirth("5");
      resumeData.setYearOfBirth("1992");
      resumeData.setCityName("Казань");
      resumeData.setPhone("9083488771");
      resumeData.setPosition(generateRandomString(15));
      resumeData.setSkills(generateRandomString(20));
      groups.add(resumeData);
    }
    if (format.equals("xml"))
    {
      writeGroupsToXmlFile(groups, filename);

    }
    else
    {
      System.out.println("Unrecognized format" + format);
    }
  }

  static void writeGroupsToXmlFile(List<ResumeData> groups, String filename) throws IOException{
    XmlMapper xmlMapper = new XmlMapper();
    xmlMapper.writeValue(new File(filename), groups);
    File file = new File("group.xml");
    assertNotNull(file);
  }

  public static String generateRandomString(int max)
  {
    String symbols = "ABCDEFGHIJKLMNOQRSTUVWXYZabcdefghijklmnoqrstuvwxyz";
    StringBuilder randString = new StringBuilder();
    int count = (int)(Math.random()*max);
    for(int i=0;i<count;i++)
      randString.append(symbols.charAt((int)(Math.random()*symbols.length())));

    System.out.println(randString);
    return randString.toString();
  }

}

