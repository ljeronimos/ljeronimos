package org.academiadecodigo.hackunamatatas.Dto;

import org.academiadecodigo.hackunamatatas.command.JobDto;
import org.academiadecodigo.hackunamatatas.model.Job;
import org.academiadecodigo.hackunamatatas.model.Skill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JobDtoToJob {

    public Job convert(JobDto jobDto){
        Job job = new Job();
        job.setTitle(jobDto.getTitle());

        List<Skill> jobSkills = new ArrayList<>();

        //System.out.println(jobDto.getSkills()+" "+jobDto.getTitle());

        for(String skill: jobDto.getSkills()){

            Skill newSkill = new Skill();
            newSkill.setTitle(skill);
            jobSkills.add(newSkill);
        }

        job.setSkills(jobSkills);
        return job;
    }

}
