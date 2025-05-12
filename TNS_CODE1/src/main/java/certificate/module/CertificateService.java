package certificate.module;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    // Create or update a certificate
    public Certificate saveCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    // Get all certificates
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    // Get a certificate by ID
    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    // Delete a certificate by ID
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
    
    
    public boolean existsById(Long id) {
        return certificateRepository.existsById(id);
    }

    public void deleteById(Long id) {
        certificateRepository.deleteById(id);
    }
    
}
