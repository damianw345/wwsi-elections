package com.github.damianw345.elections.repository;

import com.github.damianw345.elections.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElectionsRepository {

    List<Candidate> findCandidates(Integer termId, Integer electionAreaId, Integer committeeId);

    List<Committee> findCommittees(Integer termId, Integer electionAreaId);

    List<AuthenticationMethod> findAuthenticationMethods();

    List<ElectionArea> findElectionAreas(Integer termId);

    List<ElectionAreaServer> findElectionAreaServers(Integer electionAreaId);

    List<ElectionAreaDetails> findElectionAreasWithDetails();

    List<ElectionTerm> findElectionTerms();

}
