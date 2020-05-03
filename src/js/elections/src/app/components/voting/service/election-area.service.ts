import { Injectable } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ElectionArea } from '../../../core/model/election-area';
import { ElectionAreaHttpService } from '../../../core/http/election-area-http.service';

@Injectable({
  providedIn: 'root'
})
export class ElectionAreaService {

  electionAreaFormGroup: FormGroup;
  electionAreas: ElectionArea[];

  constructor(
    private formBuilder: FormBuilder,
    private electionAreaHttpService: ElectionAreaHttpService
  ) {

    this.electionAreaFormGroup = this.formBuilder.group({
      electionArea: ['', Validators.required]
    });

    this.electionAreaHttpService.fetchElectionAreas()
      .subscribe(electionAreas => this.electionAreas = electionAreas);
  }

  public get chosenElectionAreaId(): number {
    return this.electionAreaFormGroup.value.electionArea.electionAreaId;
  }

}
