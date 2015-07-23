
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for representationContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="representationContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldFilePid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operation" type="{http://dps.exlibris.com/}operation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "representationContent", propOrder = {
    "label",
    "newFile",
    "oldFilePid",
    "operation"
})
public class RepresentationContent {

    protected String label;
    protected String newFile;
    protected String oldFilePid;
    protected Operation operation;

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the newFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewFile() {
        return newFile;
    }

    /**
     * Sets the value of the newFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewFile(String value) {
        this.newFile = value;
    }

    /**
     * Gets the value of the oldFilePid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldFilePid() {
        return oldFilePid;
    }

    /**
     * Sets the value of the oldFilePid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldFilePid(String value) {
        this.oldFilePid = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link Operation }
     *     
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Operation }
     *     
     */
    public void setOperation(Operation value) {
        this.operation = value;
    }

}
