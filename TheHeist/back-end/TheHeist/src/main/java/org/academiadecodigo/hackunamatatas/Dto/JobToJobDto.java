package org.academiadecodigo.hackunamatatas.Dto;

import org.academiadecodigo.hackunamatatas.command.JobDto;
import org.academiadecodigo.hackunamatatas.model.Job;
import org.academiadecodigo.hackunamatatas.model.Skill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobToJobDto extends AbstractConverter<Job,JobDto>{

    public JobDto convert(Job job){

        JobDto jobDto = new JobDto();
        jobDto.setTitle(job.getTitle());

        List<String> skillList = new ArrayList<>();

        for(Skill skill:job.getSkills()){
            skillList.add(skill.getTitle());
        }
        jobDto.setSkills(skillList);

        return jobDto;
    }

}
