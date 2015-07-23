
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getIEMDResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getIEMDResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getIEMD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getIEMDResponse", propOrder = {
    "getIEMD"
})
public class GetIEMDResponse {

    protected String getIEMD;

    /**
     * Gets the value of the getIEMD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetIEMD() {
        return getIEMD;
    }

    /**
     * Sets the value of the getIEMD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetIEMD(String value) {
        this.getIEMD = value;
    }

}
