import { Component, Input } from '@angular/core';
import { RegisterToOnlineVotingHttpService } from '../../../../core/http/register-to-online-voting-http.service';
import { ModalFacadeService } from '../../../../core/service/modal-facade.service';
import { ElectionAreaService } from '../../service/election-area.service';
import { FindCandidatesHttpService } from '../../../../core/http/find-candidates-http.service';
import { CandidateService } from '../../service/candidate.service';
import { MatStepper } from '@angular/material/stepper';
import { ElectionTermService } from '../../service/election-term.service';

@Component({
  selector: 'app-election-area-step',
  templateUrl: './election-area-step.component.html',
  styleUrls: ['./election-area-step.component.scss']
})
export class ElectionAreaStepComponent {

  @Input()
  private stepper: MatStepper;

  constructor(
    private registerToOnlineVotingHttpService: RegisterToOnlineVotingHttpService,
    private modalFacadeService: ModalFacadeService,
    private findCandidatesHttpService: FindCandidatesHttpService,
    public electionAreaService: ElectionAreaService,
    private electionTermService: ElectionTermService,
    private candidateService: CandidateService
  ) {
  }

  registerToOnlineVotingInArea() {
    const electionAreaId = this.electionAreaService.chosenElectionAreaId;
    this.registerToOnlineVotingHttpService.register(electionAreaId)
      .subscribe(response => {
        this.modalFacadeService.openMessageDialog(response)
          .afterClosed()
          .toPromise()
          .then(_ =>
            this.findCandidatesHttpService
              .fetchCandidates(this.electionTermService.currentElectionTermId, electionAreaId, 0)
              .toPromise()
          )
          .then(candidates => this.candidateService.pushCandidates(candidates))
          .then(_ => this.stepper.next());
      });
  }
}
