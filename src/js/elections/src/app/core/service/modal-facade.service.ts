import { Injectable } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MessageDialogComponent } from '../../components/message-dialog/message-dialog.component';

@Injectable({
  providedIn: 'root'
})
export class ModalFacadeService {

  constructor(private dialog: MatDialog) {
  }

  openMessageDialog(message: string): MatDialogRef<MessageDialogComponent> {
    return this.dialog.open(MessageDialogComponent, {
      data: {
        message
      },
      panelClass: 'custom-dialog-container'
    });
  }
}
