package certificate.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // Create a new certificate
    @PostMapping
    public ResponseEntity<Certificate> createCertificate(@RequestBody Certificate certificate) {
        Certificate savedCertificate = certificateService.saveCertificate(certificate);
        return ResponseEntity.ok(savedCertificate);
    }

    // Get all certificates
    @GetMapping("/certificates")
    public ResponseEntity<List<Certificate>> getAllCertificates() {
        return ResponseEntity.ok(certificateService.getAllCertificates());
    }

    // Get a certificate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable Long id) {
        Optional<Certificate> certificate = certificateService.getCertificateById(id);
        return certificate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing certificate
    @PutMapping("/{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable Long id, @RequestBody Certificate certificateDetails) {
        Optional<Certificate> optionalCertificate = certificateService.getCertificateById(id);

        if (optionalCertificate.isPresent()) {
            Certificate certificate = optionalCertificate.get();
            certificate.setCertificateName(certificateDetails.getCertificateName());
            certificate.setIssuingOrganization(certificateDetails.getIssuingOrganization());
            certificate.setIssueDate(certificateDetails.getIssueDate());
            certificate.setStudentId(certificateDetails.getStudentId());

            Certificate updatedCertificate = certificateService.saveCertificate(certificate);
            return ResponseEntity.ok(updatedCertificate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a certificate by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable Long id) {
        if (!certificateService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        certificateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
