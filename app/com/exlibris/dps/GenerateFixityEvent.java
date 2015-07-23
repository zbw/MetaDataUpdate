
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for generateFixityEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="generateFixityEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pdsHandle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="event" type="{http://dps.exlibris.com/}fixityEvent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generateFixityEvent", propOrder = {
    "pdsHandle",
    "event"
})
public class GenerateFixityEvent {

    protected String pdsHandle;
    protected FixityEvent event;

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
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link FixityEvent }
     *     
     */
    public FixityEvent getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixityEvent }
     *     
     */
    public void setEvent(FixityEvent value) {
        this.event = value;
    }

}
