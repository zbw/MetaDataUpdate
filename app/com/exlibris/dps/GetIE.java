
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getIE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getIE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pdsHandle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iePid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getIE", propOrder = {
    "pdsHandle",
    "iePid",
    "flags"
})
public class GetIE {

    protected String pdsHandle;
    protected String iePid;
    protected Long flags;

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
     * Gets the value of the iePid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIePid() {
        return iePid;
    }

    /**
     * Sets the value of the iePid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIePid(String value) {
        this.iePid = value;
    }

    /**
     * Gets the value of the flags property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFlags() {
        return flags;
    }

    /**
     * Sets the value of the flags property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFlags(Long value) {
        this.flags = value;
    }

}
