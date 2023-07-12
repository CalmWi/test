package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(namespace = "https://www.example.org/employee")
public class Employee {
    @JsonProperty("FIO")
    @XmlElement(name = "FIO")
    private String fio;
    @JsonProperty("BirthdayDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @XmlElement(name = "BirthdayDate", type = String.class)
    private LocalDate birthday;
    @JsonIgnore
    @XmlElement(name = "Organization")
    @XmlElementWrapper(name = "Organizations")
    private List<Organization> organizations;
}
