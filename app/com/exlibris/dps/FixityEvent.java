
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for fixityEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fixityEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="copyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="filePid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fixityEvent", propOrder = {
    "agentName",
    "algorithmName",
    "copyId",
    "date",
    "filePid",
    "status"
})
public class FixityEvent {

    protected String agentName;
    protected String algorithmName;
    protected String copyId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected String filePid;
    protected Boolean status;

    /**
     * Gets the value of the agentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * Sets the value of the agentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentName(String value) {
        this.agentName = value;
    }

    /**
     * Gets the value of the algorithmName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithmName() {
        return algorithmName;
    }

    /**
     * Sets the value of the algorithmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithmName(String value) {
        this.algorithmName = value;
    }

    /**
     * Gets the value of the copyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopyId() {
        return copyId;
    }

    /**
     * Sets the value of the copyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopyId(String value) {
        this.copyId = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the filePid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilePid() {
        return filePid;
    }

    /**
     * Sets the value of the filePid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilePid(String value) {
        this.filePid = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStatus(Boolean value) {
        this.status = value;
    }

}
