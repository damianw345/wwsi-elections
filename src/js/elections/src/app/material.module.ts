import { NgModule } from '@angular/core';

import { MatButtonModule, MatCardModule, MatInputModule } from '@angular/material';

const modules = [
  MatCardModule,
  MatInputModule,
  MatButtonModule
];

@NgModule({
  imports: modules,
  exports: modules,
})
export class MaterialModule {
}
