import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Certificate } from './certificate.model';


@Injectable({
  providedIn: 'root'
})
export class CertificateService {
  private baseUrl = 'http://localhost:8088/certificate';

  constructor(private http: HttpClient) { }

  getCertificates(): Observable<Certificate[]> {
    return this.http.get<Certificate[]>(`${this.baseUrl}/certificates`);
  }


  addCertificate(certificate: Certificate): Observable<any> {
    return this.http.post(this.baseUrl, certificate);
  }

  updateCertificate(certificate: Certificate): Observable<any> {
    return this.http.put(`${this.baseUrl}/${certificate.id}`, certificate);
  }

  deleteCertificate(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}