package org.example.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "https://www.example.org/status")
@XmlEnum
public enum Status {
    OPENED,
    CLOSED
}
