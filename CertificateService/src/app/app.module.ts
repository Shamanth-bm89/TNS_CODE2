import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';  // Import HttpClientModule
import { AppComponent } from './app.component';  // Import standalone component
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule,  // Add HttpClientModule here
    RouterModule.forRoot([])  // You can define your routes here if needed
  ]
})
export class AppModule {}
