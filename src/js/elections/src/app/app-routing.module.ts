import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { VotingComponent } from './components/voting/voting.component';
import { AuthGuard } from './core/guard/auth.guard';

const routes: Routes = [

  {
    path: '',
    pathMatch: 'full',
    component: LoginComponent
  },
  {
    path: 'voting',
    pathMatch: 'full',
    component: VotingComponent,
    canActivate: [
      AuthGuard
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
