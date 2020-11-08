
package com.widgetpublica.wsdl.client.ECMDocumentService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de documentSecurityConfigDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="documentSecurityConfigDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="attributionType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="attributionValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="companyId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="documentId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="downloadEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="foo" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="inheritSecurity" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="permission" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="securityLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="securityVersion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="sequence" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="showContent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
@XmlType(name = "documentSecurityConfigDto", propOrder = {
    "attributionType",
    "attributionValue",
    "companyId",
    "documentId",
    "downloadEnabled",
    "foo",
    "inheritSecurity",
    "permission",
    "securityLevel",
    "securityVersion",
    "sequence",
    "showContent",
    "version"
})
public class DocumentSecurityConfigDto {

    protected Integer attributionType;
    protected String attributionValue;
    protected long companyId;
    protected int documentId;
    protected Boolean downloadEnabled;
    @XmlElement(nillable = true)
    protected List<String> foo;
    protected boolean inheritSecurity;
    protected Boolean permission;
    protected Integer securityLevel;
    protected Boolean securityVersion;
    protected int sequence;
    protected Boolean showContent;
    protected int version;

    /**
     * Obtém o valor da propriedade attributionType.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAttributionType() {
        return attributionType;
    }

    /**
     * Define o valor da propriedade attributionType.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAttributionType(Integer value) {
        this.attributionType = value;
    }

    /**
     * Obtém o valor da propriedade attributionValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributionValue() {
        return attributionValue;
    }

    /**
     * Define o valor da propriedade attributionValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributionValue(String value) {
        this.attributionValue = value;
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
     * Obtém o valor da propriedade downloadEnabled.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDownloadEnabled() {
        return downloadEnabled;
    }

    /**
     * Define o valor da propriedade downloadEnabled.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDownloadEnabled(Boolean value) {
        this.downloadEnabled = value;
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
     * Obtém o valor da propriedade inheritSecurity.
     * 
     */
    public boolean isInheritSecurity() {
        return inheritSecurity;
    }

    /**
     * Define o valor da propriedade inheritSecurity.
     * 
     */
    public void setInheritSecurity(boolean value) {
        this.inheritSecurity = value;
    }

    /**
     * Obtém o valor da propriedade permission.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPermission() {
        return permission;
    }

    /**
     * Define o valor da propriedade permission.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPermission(Boolean value) {
        this.permission = value;
    }

    /**
     * Obtém o valor da propriedade securityLevel.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSecurityLevel() {
        return securityLevel;
    }

    /**
     * Define o valor da propriedade securityLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSecurityLevel(Integer value) {
        this.securityLevel = value;
    }

    /**
     * Obtém o valor da propriedade securityVersion.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSecurityVersion() {
        return securityVersion;
    }

    /**
     * Define o valor da propriedade securityVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSecurityVersion(Boolean value) {
        this.securityVersion = value;
    }

    /**
     * Obtém o valor da propriedade sequence.
     * 
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * Define o valor da propriedade sequence.
     * 
     */
    public void setSequence(int value) {
        this.sequence = value;
    }

    /**
     * Obtém o valor da propriedade showContent.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowContent() {
        return showContent;
    }

    /**
     * Define o valor da propriedade showContent.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowContent(Boolean value) {
        this.showContent = value;
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
