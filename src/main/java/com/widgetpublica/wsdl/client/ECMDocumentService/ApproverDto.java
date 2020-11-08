
package com.widgetpublica.wsdl.client.ECMDocumentService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de approverDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="approverDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="approvelMode" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="approverType" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="colleagueId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="companyId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="documentId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="foo" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="levelDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="levelId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approverDto", propOrder = {
    "approvelMode",
    "approverType",
    "colleagueId",
    "companyId",
    "documentId",
    "foo",
    "levelDescription",
    "levelId",
    "version"
})
public class ApproverDto {

    protected int approvelMode;
    protected int approverType;
    protected String colleagueId;
    protected long companyId;
    protected int documentId;
    @XmlElement(nillable = true)
    protected List<String> foo;
    protected String levelDescription;
    protected int levelId;
    protected int version;

    /**
     * Obtém o valor da propriedade approvelMode.
     * 
     */
    public int getApprovelMode() {
        return approvelMode;
    }

    /**
     * Define o valor da propriedade approvelMode.
     * 
     */
    public void setApprovelMode(int value) {
        this.approvelMode = value;
    }

    /**
     * Obtém o valor da propriedade approverType.
     * 
     */
    public int getApproverType() {
        return approverType;
    }

    /**
     * Define o valor da propriedade approverType.
     * 
     */
    public void setApproverType(int value) {
        this.approverType = value;
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
     * Obtém o valor da propriedade companyId.
     * 
     */
    public long getCompanyId() {
        return companyId;
    }

    /**
     * Define o valor da propriedade companyId.
     * 
     */
    public void setCompanyId(long value) {
        this.companyId = value;
    }

    /**
     * Obtém o valor da propriedade documentId.
     * 
     */
    public int getDocumentId() {
        return documentId;
    }

    /**
     * Define o valor da propriedade documentId.
     * 
     */
    public void setDocumentId(int value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the foo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the foo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFoo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFoo() {
        if (foo == null) {
            foo = new ArrayList<String>();
        }
        return this.foo;
    }

    /**
     * Obtém o valor da propriedade levelDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevelDescription() {
        return levelDescription;
    }

    /**
     * Define o valor da propriedade levelDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevelDescription(String value) {
        this.levelDescription = value;
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
     * Obtém o valor da propriedade version.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Define o valor da propriedade version.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

}
