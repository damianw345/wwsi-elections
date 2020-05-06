import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { LoginComponent } from './components/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { VotingComponent } from './components/voting/voting.component';
import { MatStepperModule } from '@angular/material/stepper';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { MessageDialogComponent } from './components/message-dialog/message-dialog.component';
import { MatIconModule } from '@angular/material/icon';
import { TokenInterceptor } from './core/http/token-interceptor';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SummaryStepComponent } from './components/voting/steps/summary-step/summary-step.component';
import { ConfirmationStepComponent } from './components/voting/steps/confirmation-step/confirmation-step.component';
import { CandidateChooseStepComponent } from './components/voting/steps/candidate-choose-step/candidate-choose-step.component';
import { ElectionAreaStepComponent } from './components/voting/steps/election-area-step/election-area-step.component';
import { ErrorInterceptor } from './core/http/error-interceptor';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    VotingComponent,
    MessageDialogComponent,
    NavbarComponent,
    SummaryStepComponent,
    ConfirmationStepComponent,
    CandidateChooseStepComponent,
    ElectionAreaStepComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatStepperModule,
    MatSelectModule,
    MatDialogModule,
    MatIconModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    CommonModule
  ],
  entryComponents: [MessageDialogComponent],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
