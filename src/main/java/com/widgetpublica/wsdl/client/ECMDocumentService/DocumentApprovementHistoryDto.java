
package com.widgetpublica.wsdl.client.ECMDocumentService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de documentApprovementHistoryDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="documentApprovementHistoryDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="approvementDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="colleagueId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="colleagueName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="documentVersion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="iterationSequence" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="levelId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="movementSequence" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="observation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="signed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentApprovementHistoryDto", propOrder = {
    "approvementDate",
    "colleagueId",
    "colleagueName",
    "documentVersion",
    "iterationSequence",
    "levelId",
    "movementSequence",
    "observation",
    "signed",
    "status"
})
public class DocumentApprovementHistoryDto {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar approvementDate;
    protected String colleagueId;
    protected String colleagueName;
    protected int documentVersion;
    protected int iterationSequence;
    protected int levelId;
    protected int movementSequence;
    protected String observation;
    protected boolean signed;
    protected int status;

    /**
     * Obtém o valor da propriedade approvementDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApprovementDate() {
        return approvementDate;
    }

    /**
     * Define o valor da propriedade approvementDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApprovementDate(XMLGregorianCalendar value) {
        this.approvementDate = value;
    }

    /**
     * Obtém o valor da propriedade colleagueId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColleagueId() {
        return colleagueId;
    }

    /**
     * Define o valor da propriedade colleagueId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColleagueId(String value) {
        this.colleagueId = value;
    }

    /**
     * Obtém o valor da propriedade colleagueName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColleagueName() {
        return colleagueName;
    }

    /**
     * Define o valor da propriedade colleagueName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColleagueName(String value) {
        this.colleagueName = value;
    }

    /**
     * Obtém o valor da propriedade documentVersion.
     * 
     */
    public int getDocumentVersion() {
        return documentVersion;
    }

    /**
     * Define o valor da propriedade documentVersion.
     * 
     */
    public void setDocumentVersion(int value) {
        this.documentVersion = value;
    }

    /**
     * Obtém o valor da propriedade iterationSequence.
     * 
     */
    public int getIterationSequence() {
        return iterationSequence;
    }

    /**
     * Define o valor da propriedade iterationSequence.
     * 
     */
    public void setIterationSequence(int value) {
        this.iterationSequence = value;
    }

    /**
     * Obtém o valor da propriedade levelId.
     * 
     */
    public int getLevelId() {
        return levelId;
    }

    /**
     * Define o valor da propriedade levelId.
     * 
     */
    public void setLevelId(int value) {
        this.levelId = value;
    }

    /**
     * Obtém o valor da propriedade movementSequence.
     * 
     */
    public int getMovementSequence() {
        return movementSequence;
    }

    /**
     * Define o valor da propriedade movementSequence.
     * 
     */
    public void setMovementSequence(int value) {
        this.movementSequence = value;
    }

    /**
     * Obtém o valor da propriedade observation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservation() {
        return observation;
    }

    /**
     * Define o valor da propriedade observation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservation(String value) {
        this.observation = value;
    }

    /**
     * Obtém o valor da propriedade signed.
     * 
     */
    public boolean isSigned() {
        return signed;
    }

    /**
     * Define o valor da propriedade signed.
     * 
     */
    public void setSigned(boolean value) {
        this.signed = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

}
