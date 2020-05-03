import { Injectable } from '@angular/core';
import { Candidate } from '../../../core/model/candidate';
import { BehaviorSubject, Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  candidateFormGroup: FormGroup;
  private allCandidates: BehaviorSubject<Candidate[]> = new BehaviorSubject<Candidate[]>(null);
  allCandidates$: Observable<Candidate[]> = this.allCandidates.asObservable();
  private chosenCandidateSubject: BehaviorSubject<Candidate> = new BehaviorSubject<Candidate>(null);
  chosenCandidate$: Observable<Candidate> = this.chosenCandidateSubject.asObservable();

  constructor(private formBuilder: FormBuilder) {
    this.candidateFormGroup = this.formBuilder.group({
      candidateId: ['', Validators.required],
      candidateName: ['', Validators.required],
    });
  }

  pushCandidates(candidates: Candidate[]) {
    this.allCandidates.next(candidates);
  }

  chooseCandidate(candidate: Candidate) {
    this.chosenCandidateSubject.next(candidate);
    this.candidateFormGroup.patchValue({candidateId: candidate.candidateId})
    this.candidateFormGroup.patchValue({candidateName: candidate.candidateNameSurname})
  }
}
