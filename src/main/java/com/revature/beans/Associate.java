package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
//Caliber_Associate
@Entity
@Table(name = "CALIBER_ASSOCIATE")
@Cacheable
public class Associate implements Serializable {
	private static final long serialVersionUID = 167119711242064698L;
	
	/**
	 * associatedId: unique associate identifier
	 */
	@Id
	@Column(name = "ASSOCIATE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_ID_SEQUENCE")
	@SequenceGenerator(name = "CLIENT_ID_SEQUENCE", sequenceName = "CLIENT_ID_SEQUENCE")
	private Integer associateId;
	
	/**
	 * Associate's first name
	 */
	@NotEmpty
	@Column(name = "ASSOCIATE_FIRST_NAME")
	private String associateFirstName;
	
	/**
	 * Associate's last name
	 */
	@NotEmpty
	@Column(name = "ASSOCIATE_LAST_NAME")
	private String associateLastName;
	
	/**
	 * marketingStatusId: marketing status of associate
	 * @ManyToOne JoinColumn()
	 */
	@Column(name = "MARKETING_STATUS_ID")
	private Integer marketingStatusId;
	
	/**
	 * clientId: client of associate
	 * @ManyToOne JoinColumn()
	 */
	@Column(name = "CLIENT_ID")
	private Integer clientId;
	
	/**
	 * endClientId: end client of associate
	 * @ManyToOne JoinColumn()
	 */
	@Column(name = "END_CLIENT_ID")
	private Integer endClientId;
	
	/**
	 * batchId: training batch identifier of associate
	 * @ManyToOne JoinColumn()
	 */
	@Column(name = "BATCH_ID")
	private Integer batchId;
	
	public Associate() {
		super();
	}
	
	public Associate(Integer associateId, String associateFirstName, String associateLastName,
			Integer marketingStatusId, Integer clientId, Integer endClientId, Integer batchId) {
		super();
		this.associateId = associateId;
		this.associateFirstName = associateFirstName;
		this.associateLastName = associateLastName;
		this.marketingStatusId = marketingStatusId;
		this.clientId = clientId;
		this.endClientId = endClientId;
		this.batchId = batchId;
	}
	
	

	public Integer getAssociateId() {
		return associateId;
	}

	public void setAssociateId(Integer associateId) {
		this.associateId = associateId;
	}

	public String getAssociateFirstName() {
		return associateFirstName;
	}

	public void setAssociateFirstName(String associateFirstName) {
		this.associateFirstName = associateFirstName;
	}

	public String getAssociateLastName() {
		return associateLastName;
	}

	public void setAssociateLastName(String associateLastName) {
		this.associateLastName = associateLastName;
	}

	public Integer getMarketingStatusId() {
		return marketingStatusId;
	}

	public void setMarketingStatusId(Integer marketingStatusId) {
		this.marketingStatusId = marketingStatusId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getEndClientId() {
		return endClientId;
	}

	public void setEndClientId(Integer endClientId) {
		this.endClientId = endClientId;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associateFirstName == null) ? 0 : associateFirstName.hashCode());
		result = prime * result + ((associateId == null) ? 0 : associateId.hashCode());
		result = prime * result + ((associateLastName == null) ? 0 : associateLastName.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((endClientId == null) ? 0 : endClientId.hashCode());
		result = prime * result + ((marketingStatusId == null) ? 0 : marketingStatusId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associate other = (Associate) obj;
		if (associateFirstName == null) {
			if (other.associateFirstName != null)
				return false;
		} else if (!associateFirstName.equals(other.associateFirstName))
			return false;
		if (associateId == null) {
			if (other.associateId != null)
				return false;
		} else if (!associateId.equals(other.associateId))
			return false;
		if (associateLastName == null) {
			if (other.associateLastName != null)
				return false;
		} else if (!associateLastName.equals(other.associateLastName))
			return false;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (endClientId == null) {
			if (other.endClientId != null)
				return false;
		} else if (!endClientId.equals(other.endClientId))
			return false;
		if (marketingStatusId == null) {
			if (other.marketingStatusId != null)
				return false;
		} else if (!marketingStatusId.equals(other.marketingStatusId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Associate [associateId=" + associateId + ", associateFirstName=" + associateFirstName
				+ ", associateLastName=" + associateLastName + ", marketingStatusId=" + marketingStatusId
				+ ", clientId=" + clientId + ", endClientId=" + endClientId + ", batchId=" + batchId + "]";
	}
}
