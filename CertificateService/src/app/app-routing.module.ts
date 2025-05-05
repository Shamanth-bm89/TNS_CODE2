import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

const routes: Routes = [
  { path: 'some-path', component: AppComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],  // Set up routes
  exports: [RouterModule]
})
export class AppRoutingModule {}
