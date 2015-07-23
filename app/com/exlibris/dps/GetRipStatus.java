
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRipStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRipStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pdsHandle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ripID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRipStatus", propOrder = {
    "pdsHandle",
    "ripID"
})
public class GetRipStatus {

    protected String pdsHandle;
    protected Long ripID;

    /**
     * Gets the value of the pdsHandle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdsHandle() {
        return pdsHandle;
    }

    /**
     * Sets the value of the pdsHandle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdsHandle(String value) {
        this.pdsHandle = value;
    }

    /**
     * Gets the value of the ripID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRipID() {
        return ripID;
    }

    /**
     * Sets the value of the ripID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRipID(Long value) {
        this.ripID = value;
    }

}
