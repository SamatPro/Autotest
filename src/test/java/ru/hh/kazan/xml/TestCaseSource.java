package ru.hh.kazan.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.hh.kazan.models.ResumeData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TestCaseSource {

  public static void main(String[] args) throws IOException {
    System.out.println(resumeDataFromXmlFile().get(1));
  }

  public static List<ResumeData> resumeDataFromXmlFile() throws IOException {
    File file = new File("groups.xml");
    XmlMapper xmlMapper = new XmlMapper();
    String xml = inputStreamToString(new FileInputStream(file));
    List<ResumeData> resumeData = xmlMapper.readValue(xml, ArrayList.class);
    return resumeData;
  }

  public static String inputStreamToString(InputStream is) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    br.close();
    return sb.toString();
  }

}
