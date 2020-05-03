import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Candidate } from '../../../../core/model/candidate';
import { SelectionModel } from '@angular/cdk/collections';
import { CandidateService } from '../../service/candidate.service';

@Component({
  selector: 'app-candidate-choose-step',
  templateUrl: './candidate-choose-step.component.html',
  styleUrls: ['./candidate-choose-step.component.scss']
})
export class CandidateChooseStepComponent implements OnInit {

  candidatesDataSource = new MatTableDataSource<Candidate>(null);

  displayedColumns: string[] = ['id', 'electionArea', 'committee', 'candidate', 'party'];

  selection = new SelectionModel<Candidate>(false, []);

  constructor(public candidateService: CandidateService) {
  }

  ngOnInit() {
    this.candidateService.allCandidates$
      .subscribe(candidates => this.candidatesDataSource.data = candidates);
  }
}
