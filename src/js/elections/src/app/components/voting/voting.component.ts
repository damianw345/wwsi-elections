import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ElectionAreaHttpService } from '../../core/http/election-area-http.service';
import { AuthService } from '../../core/service/auth.service';
import { ElectionArea } from '../../core/model/election-area';
import { ModalFacadeService } from '../../core/service/modal-facade.service';
import { RegisterToOnlineVotingHttpService } from '../../core/http/register-to-online-voting-http.service';
import { MatStepper } from '@angular/material/stepper';

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.scss']
})
export class VotingComponent implements OnInit {

  electionAreaFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  private electionAreas: ElectionArea[];

  @ViewChild('stepper')
  private stepper: MatStepper;

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private modalFacadeService: ModalFacadeService,
              private electionAreaHttpService: ElectionAreaHttpService,
              private registerToOnlineVotingHttpService: RegisterToOnlineVotingHttpService,
  ) {
  }

  ngOnInit() {
    this.electionAreaHttpService.fetchElectionAreas()
      .subscribe(electionAreas => this.electionAreas = electionAreas);
    this.buildFormGroups();
  }

  registerToOnlineVotingInArea() {
    const electionAreaId = this.electionAreaFormGroup.value.electionArea.electionAreaId;
    this.registerToOnlineVotingHttpService.register(electionAreaId)
      .subscribe(response => {
        this.modalFacadeService.openMessageDialog(response)
          .afterClosed()
          .toPromise()
          .then(_ => this.stepper.next());
      });
  }

  private buildFormGroups(): void {
    this.electionAreaFormGroup = this.formBuilder.group({
      electionArea: ['', Validators.required]
    });
    this.secondFormGroup = this.formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }
}
