import { Injectable } from '@angular/core';
import { ElectionTermHttpService } from '../../../core/http/election-term-http.service';
import { ElectionTerm } from '../../../core/model/election-term';

@Injectable({
  providedIn: 'root'
})
export class ElectionTermService {

  private electionTerms: ElectionTerm[];

  constructor(private electionTermHttpService: ElectionTermHttpService,
  ) {
    this.electionTermHttpService.fetchElectionTerms()
      .subscribe(electionTerms => {
        this.electionTerms = electionTerms;
      });
  }

  get currentElectionTermId(): number {
    return this.electionTerms[0].electionTermId;
  }
}
