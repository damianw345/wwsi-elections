import { Component, ViewChild } from '@angular/core';
import { AuthService } from '../../core/service/auth.service';
import { MatStepper } from '@angular/material/stepper';
import { CandidateService } from './service/candidate.service';
import { ElectionAreaService } from './service/election-area.service';
import { ElectionTermService } from './service/election-term.service';

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.scss']
})
export class VotingComponent {

  @ViewChild('stepper')
  private stepper: MatStepper;

  constructor(private authService: AuthService,
              public electionAreaService: ElectionAreaService,
              private electionTermService: ElectionTermService,
              public candidateService: CandidateService
  ) {
  }

}
