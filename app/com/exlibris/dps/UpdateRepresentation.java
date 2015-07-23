
package com.exlibris.dps;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateRepresentation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateRepresentation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pdsHandle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iePid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="repPid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="submissionReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="representationContent" type="{http://dps.exlibris.com/}representationContent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateRepresentation", propOrder = {
    "pdsHandle",
    "iePid",
    "repPid",
    "submissionReason",
    "representationContent"
})
public class UpdateRepresentation {

    protected String pdsHandle;
    protected String iePid;
    protected String repPid;
    protected String submissionReason;
    protected List<RepresentationContent> representationContent;

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
     * Gets the value of the repPid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepPid() {
        return repPid;
    }

    /**
     * Sets the value of the repPid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepPid(String value) {
        this.repPid = value;
    }

    /**
     * Gets the value of the submissionReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmissionReason() {
        return submissionReason;
    }

    /**
     * Sets the value of the submissionReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmissionReason(String value) {
        this.submissionReason = value;
    }

    /**
     * Gets the value of the representationContent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the representationContent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRepresentationContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RepresentationContent }
     * 
     * 
     */
    public List<RepresentationContent> getRepresentationContent() {
        if (representationContent == null) {
            representationContent = new ArrayList<RepresentationContent>();
        }
        return this.representationContent;
    }

}
