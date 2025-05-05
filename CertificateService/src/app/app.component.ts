import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';  // ✅ Add this

import { CertificateService } from './certificate.service';
import { Certificate } from './certificate.model';

declare var bootstrap: any;

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],  // ✅ Add HttpClientModule
  providers: [CertificateService],  // ✅ Provide your service
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'certificateservice';
  certificateDetails: Certificate[] = [];

  certificateToUpdate: Certificate = {
    id: 0,
    certificateName: '',
    issuingOrganization: '',
    issueDate: '',
    studentId: 0
  };

  constructor(private certificateService: CertificateService) {}

  ngOnInit() {
    this.getCertificates();
  }

  getCertificates() {
    this.certificateService.getCertificates().subscribe({
      next: (data: Certificate[]) => {
        this.certificateDetails = Array.isArray(data) ? data : [];
      },
      error: (err) => {
        console.error('Error fetching certificates:', err);
        this.showError('Error fetching data. Please try again.');
      }
    });
  }

  register(registerForm: NgForm) {
    if (registerForm.invalid) return;

    this.certificateService.addCertificate(registerForm.value).subscribe({
      next: () => {
        registerForm.reset();
        this.getCertificates();
      },
      error: (error) => {
        console.error('Error adding certificate:', error);
        this.showError('Error adding certificate.');
      }
    });
  }

  edit(certificate: Certificate) {
    this.certificateToUpdate = { ...certificate };
  }

  updateCertificate() {
    if (!this.certificateToUpdate.id) {
      this.showError('Invalid data');
      return;
    }

    this.certificateService.updateCertificate(this.certificateToUpdate).subscribe({
      next: () => {
        this.getCertificates();
        this.closeModal();
      },
      error: (error) => {
        console.error('Error updating certificate:', error);
        this.showError('Error updating certificate.');
      }
    });
  }

  deleteCertificate(certificate: Certificate) {
    if (certificate.id !== undefined) {
      this.certificateService.deleteCertificate(certificate.id).subscribe({
        next: () => {
          this.getCertificates();
        },
        error: (err) => {
          //console.error('Error deleting certificate:', err);
          this.showError('Error deleting certificate.');
        }
      });
    }
  }
  

  closeModal() {
    const modalElement = document.getElementById('editModal');
    if (modalElement) {
      const modal = bootstrap.Modal.getInstance(modalElement);
      if (modal) {
        modal.hide();
      }
    }

    this.resetCertificateForm();
  }

  private showError(message: string) {
    alert(message);
  }

  private resetCertificateForm() {
    this.certificateToUpdate = {
      id: 0,
      certificateName: '',
      issuingOrganization: '',
      issueDate: '',
      studentId: 0
    };
  }
}
