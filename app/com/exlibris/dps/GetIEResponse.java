
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getIEResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getIEResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getIE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getIEResponse", propOrder = {
    "getIE"
})
public class GetIEResponse {

    protected String getIE;

    /**
     * Gets the value of the getIE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetIE() {
        return getIE;
    }

    /**
     * Sets the value of the getIE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetIE(String value) {
        this.getIE = value;
    }

}
