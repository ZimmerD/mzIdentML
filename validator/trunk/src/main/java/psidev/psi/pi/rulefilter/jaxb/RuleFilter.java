//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.29 at 11:12:30 AM CEST 
//

package psidev.psi.pi.rulefilter.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}userConditions"/>
 *         &lt;element ref="{}ruleConditions" minOccurs="0"/>
 *         &lt;element ref="{}references" minOccurs="0"/>
 *         &lt;element ref="{}mandatoryElements" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "userConditions", "ruleConditions",
		"references", "mandatoryElements" })
@XmlRootElement(name = "ruleFilter")
public class RuleFilter {

	@XmlElement(required = true)
	protected UserConditions userConditions;
	protected RuleConditions ruleConditions;
	protected References references;
	protected MandatoryElements mandatoryElements;

	/**
	 * Gets the value of the userConditions property.
	 * 
	 * @return possible object is {@link UserConditions }
	 * 
	 */
	public UserConditions getUserConditions() {
		return userConditions;
	}

	/**
	 * Sets the value of the userConditions property.
	 * 
	 * @param value
	 *            allowed object is {@link UserConditions }
	 * 
	 */
	public void setUserConditions(UserConditions value) {
		this.userConditions = value;
	}

	/**
	 * Gets the value of the ruleConditions property.
	 * 
	 * @return possible object is {@link RuleConditions }
	 * 
	 */
	public RuleConditions getRuleConditions() {
		return ruleConditions;
	}

	/**
	 * Sets the value of the ruleConditions property.
	 * 
	 * @param value
	 *            allowed object is {@link RuleConditions }
	 * 
	 */
	public void setRuleConditions(RuleConditions value) {
		this.ruleConditions = value;
	}

	/**
	 * Gets the value of the references property.
	 * 
	 * @return possible object is {@link References }
	 * 
	 */
	public References getReferences() {
		return references;
	}

	/**
	 * Sets the value of the references property.
	 * 
	 * @param value
	 *            allowed object is {@link References }
	 * 
	 */
	public void setReferences(References value) {
		this.references = value;
	}

	/**
	 * Gets the value of the mandatoryElements property.
	 * 
	 * @return possible object is {@link MandatoryElements }
	 * 
	 */
	public MandatoryElements getMandatoryElements() {
		return mandatoryElements;
	}

	/**
	 * Sets the value of the mandatoryElements property.
	 * 
	 * @param value
	 *            allowed object is {@link MandatoryElements }
	 * 
	 */
	public void setMandatoryElements(MandatoryElements value) {
		this.mandatoryElements = value;
	}

}
