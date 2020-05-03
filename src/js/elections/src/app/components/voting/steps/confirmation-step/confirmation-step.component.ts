import { Component, Input } from '@angular/core';
import { VotingHttpService } from '../../../../core/http/voting-http.service';
import { ModalFacadeService } from '../../../../core/service/modal-facade.service';
import { MatStepper } from '@angular/material/stepper';
import { Candidate } from '../../../../core/model/candidate';

@Component({
  selector: 'app-confirmation-step',
  templateUrl: './confirmation-step.component.html',
  styleUrls: ['./confirmation-step.component.scss']
})
export class ConfirmationStepComponent {

  @Input()
  private stepper: MatStepper;

  @Input()
  private electionAreaId: number;

  @Input()
  private electionTermId: number;

  @Input()
  public candidate: Candidate;

  constructor(private modalFacadeService: ModalFacadeService,
              private votingHttpService: VotingHttpService
  ) {
  }

  vote() {
    this.votingHttpService.vote({
      candidateId: this.candidate.candidateId,
      electionTermId: this.electionTermId,
      electionAreaId: this.electionAreaId,
      authMethodId: 4, // epuap
    }).subscribe(response => {
      this.modalFacadeService.openMessageDialog(response)
        .afterClosed()
        .toPromise()
        .then(_ => this.stepper.next())
    });
  }
}
