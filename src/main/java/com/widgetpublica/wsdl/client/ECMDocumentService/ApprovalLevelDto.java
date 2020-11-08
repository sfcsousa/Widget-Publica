
package com.widgetpublica.wsdl.client.ECMDocumentService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de approvalLevelDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="approvalLevelDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="approvalMode" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="levelDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="levelId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mandatorySignature" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approvalLevelDto", propOrder = {
    "approvalMode",
    "levelDescription",
    "levelId",
    "mandatorySignature"
})
public class ApprovalLevelDto {

    protected int approvalMode;
    protected String levelDescription;
    protected int levelId;
    protected boolean mandatorySignature;

    /**
     * Obtém o valor da propriedade approvalMode.
     * 
     */
    public int getApprovalMode() {
        return approvalMode;
    }

    /**
     * Define o valor da propriedade approvalMode.
     * 
     */
    public void setApprovalMode(int value) {
        this.approvalMode = value;
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
     * Obtém o valor da propriedade mandatorySignature.
     * 
     */
    public boolean isMandatorySignature() {
        return mandatorySignature;
    }

    /**
     * Define o valor da propriedade mandatorySignature.
     * 
     */
    public void setMandatorySignature(boolean value) {
        this.mandatorySignature = value;
    }

}
