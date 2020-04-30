import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ElectionAreaHttpService } from '../../core/http/election-area-http.service';
import { AuthService } from '../../core/service/auth.service';
import { ElectionArea } from '../../core/model/election-area';
import { ModalFacadeService } from '../../core/service/modal-facade.service';
import { RegisterToOnlineVotingHttpService } from '../../core/http/register-to-online-voting-http.service';
import { MatStepper } from '@angular/material/stepper';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';
import { FindCandidatesHttpService } from '../../core/http/find-candidates-http.service';
import { ElectionTerm } from '../../core/model/election-term';
import { ElectionTermHttpService } from '../../core/http/election-term-http.service';
import { Candidate } from '../../core/model/candidate';
import { VotingHttpService } from '../../core/http/voting-http.service';

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.scss']
})
export class VotingComponent implements OnInit {

  electionAreaFormGroup: FormGroup;
  candidateFormGroup: FormGroup;

  electionAreas: ElectionArea[];
  displayedColumns: string[] = ['id', 'electionArea', 'committee', 'candidate', 'party'];
  dataSource = new MatTableDataSource<Candidate>(null);

  @ViewChild('stepper')
  private stepper: MatStepper;

  selection = new SelectionModel<Candidate>(false, []);
  private electionTerms: ElectionTerm[];
  private candidates: Candidate[];

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private modalFacadeService: ModalFacadeService,
              private electionAreaHttpService: ElectionAreaHttpService,
              private registerToOnlineVotingHttpService: RegisterToOnlineVotingHttpService,
              private electionTermHttpService: ElectionTermHttpService,
              private findCandidatesHttpService: FindCandidatesHttpService,
              private votingHttpService: VotingHttpService
  ) {
  }


  ngOnInit() {
    this.electionAreaHttpService.fetchElectionAreas()
      .subscribe(electionAreas => this.electionAreas = electionAreas);
    this.buildFormGroups();
  }

  // fixme I was really short on time while writing this demo project...
  registerToOnlineVotingInArea() {
    const electionAreaId = this.getChosenElectionAreaId();
    this.registerToOnlineVotingHttpService.register(electionAreaId)
      .subscribe(response => {
        this.modalFacadeService.openMessageDialog(response)
          .afterClosed()
          .toPromise()
          .then(_ => this.electionTermHttpService.fetchElectionTerms()
            .toPromise()
            .then(terms => this.electionTerms = terms)
            .then(__ =>
              this.findCandidatesHttpService.fetchCandidates(this.electionTerms[0].electionTermId, this.getChosenElectionAreaId(), 0)
                .toPromise()
                .then(candidates => this.candidates = candidates))
          )
          .then(_ => this.dataSource.data = this.candidates)
          .then(_ => this.stepper.next());
      });
  }

  chooseCandidate(row: Candidate) {
    this.candidateFormGroup.patchValue({candidateId: row.candidateId})
    this.candidateFormGroup.patchValue({candidateName: row.candidateNameSurname})
  }

  vote() {
    this.votingHttpService.vote({
      candidateId: this.candidateFormGroup.value.candidateId,
      electionTermId: this.electionTerms[0].electionTermId,
      electionAreaId: this.getChosenElectionAreaId(),
      authMethodId: 4, // epuap
    }).subscribe(response => {
      this.modalFacadeService.openMessageDialog(response)
        .afterClosed()
        .toPromise()
        .then(_ => this.stepper.next())
    });
  }

  private getChosenElectionAreaId(): number {
    return this.electionAreaFormGroup.value.electionArea.electionAreaId;
  }

  private buildFormGroups(): void {
    this.electionAreaFormGroup = this.formBuilder.group({
      electionArea: ['', Validators.required]
    });
    this.candidateFormGroup = this.formBuilder.group({
      candidateId: ['', Validators.required],
      candidateName: ['', Validators.required],
    });
  }
}
