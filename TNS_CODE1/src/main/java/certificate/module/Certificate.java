package certificate.module;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;

@Entity
@Table(name = "certificate")

public class Certificate {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String certificateName;
    private String issuingOrganization;
    private LocalDate issueDate;
    private Long studentId;
    

    
	public Certificate() {
		super();
	}



	public Certificate(Long id, String certificateName, String issuingOrganization, LocalDate issueDate,
			Long studentId) {
		super();
		this.id = id;
		this.certificateName = certificateName;
		this.issuingOrganization = issuingOrganization;
		this.issueDate = issueDate;
		this.studentId = studentId;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCertificateName() {
		return certificateName;
	}



	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}



	public String getIssuingOrganization() {
		return issuingOrganization;
	}



	public void setIssuingOrganization(String issuingOrganization) {
		this.issuingOrganization = issuingOrganization;
	}



	public LocalDate getIssueDate() {
		return issueDate;
	}



	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}



	public Long getStudentId() {
		return studentId;
	}



	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}



	@Override
	public String toString() {
		return "Certificate [id=" + id + ", certificateName=" + certificateName + ", issuingOrganization="
				+ issuingOrganization + ", issueDate=" + issueDate + ", studentId=" + studentId + "]";
	}
    

    
    
}
    
