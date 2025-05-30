package com.madislm.jobprocessor.mapper;

import com.madislm.jobprocessor.dto.JobResponseDto;
import com.madislm.jobprocessor.model.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobMapper {

    @Mapping(source = "id", target = "jobId")
    JobResponseDto jobToJobResponseDto(Job job);
}
