package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.Status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(namespace = "https://www.example.org/organization")
public class Organization {
    @JsonProperty("OrgName")
    @XmlElement(name = "OrgName")
    private String name;
    @JsonProperty("CreationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @XmlElement(name = "CreationDate", type = String.class)
    private LocalDate creationDate;
    @JsonProperty("Status")
    @XmlElement(name = "Status")
    private Status status;
    @JacksonXmlElementWrapper(localName = "Employees")
    @JsonProperty("Employee")
    @XmlElement(name = "Employee")
    @XmlElementWrapper(name = "Employees")
    private List<Employee> employees;
}
