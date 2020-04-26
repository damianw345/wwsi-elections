package com.github.damianw345.elections.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.damianw345.elections.exception.AppRuntimeException;
import com.github.damianw345.elections.exception.code.AppExceptionCode;
import com.github.damianw345.elections.model.area.Counties;
import com.github.damianw345.elections.model.area.ElectionAreaDetails;
import com.github.damianw345.elections.util.XmlCountiesMapper;
import lombok.Value;
import org.springframework.util.StringUtils;

@Value
public class ElectionAreaDto {
    int electionAreaId;
    String electionArea;
    String area;
    Counties counties;

    public static ElectionAreaDto of(ElectionAreaDetails electionAreaDetails) {
        try {
            return new ElectionAreaDto(
                    electionAreaDetails.getOkregWyborczyID(),
                    electionAreaDetails.getOkregWyborczy(),
                    electionAreaDetails.getObszar(),
                    getCounties(electionAreaDetails)
            );
        } catch (Exception e) {
            throw new AppRuntimeException(AppExceptionCode.E003, e);
        }
    }

    private static Counties getCounties(ElectionAreaDetails electionAreaDetails) throws JsonProcessingException {
        String areaDetails = electionAreaDetails.getOpis();
        Counties counties;
        if (StringUtils.isEmpty(areaDetails)) {
            counties = new Counties();
        } else {
            counties = XmlCountiesMapper.deserializeCounties(electionAreaDetails.getOpis());
        } return counties;
    }
}
