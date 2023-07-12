package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Organization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class XmlService {
    private final String PATH = "organizations.xml";
    private static Logger log = Logger.getLogger(XmlService.class.getName());
    private XmlMapper xmlMapper;

    public XmlService() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
    }

    public void serialiseToXml(final List<Organization> organizations) throws IOException {

        log.info("Serialize organizations...");
        String xmlString = xmlMapper.writeValueAsString(organizations);

        log.info("Write xml file ...");
        File xmlOutput = new File(PATH);
        FileWriter fileWriter = new FileWriter(xmlOutput);
        fileWriter.write(xmlString);
        fileWriter.close();
        log.info("Write to xml file success.");
    }

    public List<Organization> parseFromXml() throws IOException {

        log.info("Read file ...");
        String content = new String(Files.readAllBytes(Paths.get(PATH)));

        log.info("Deserialize organizations...");
        List<Organization> parseList = xmlMapper.readValue(content, new TypeReference<List<Organization>>() {
        });

        return parseList;
    }
}
