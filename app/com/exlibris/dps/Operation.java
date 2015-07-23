
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="operation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADD"/>
 *     &lt;enumeration value="REPLACE"/>
 *     &lt;enumeration value="REMOVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operation")
@XmlEnum
public enum Operation {

    ADD,
    REPLACE,
    REMOVE;

    public String value() {
        return name();
    }

    public static Operation fromValue(String v) {
        return valueOf(v);
    }

}
