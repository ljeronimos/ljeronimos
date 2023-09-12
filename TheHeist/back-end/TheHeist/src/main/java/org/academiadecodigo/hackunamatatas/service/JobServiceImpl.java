package org.academiadecodigo.hackunamatatas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.hackunamatatas.Dto.JobDtoToJob;
import org.academiadecodigo.hackunamatatas.command.JobDto;
import org.academiadecodigo.hackunamatatas.command.WorkerDto;
import org.academiadecodigo.hackunamatatas.model.Job;
import org.academiadecodigo.hackunamatatas.model.Skill;
import org.academiadecodigo.hackunamatatas.persistence.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl {

    private JobDao jobDao;

    private JobDtoToJob jobDtoToJob;

    @Autowired
    public void setJobDtoToJob(JobDtoToJob jobDtoToJob) {
        this.jobDtoToJob = jobDtoToJob;
    }

    @Autowired
    public void setJobDao(JobDao jobDao) {
        this.jobDao = jobDao;
    }


    @Transactional
    public Job getJob(Integer id){
        return (Job) jobDao.find(id);
    }


    @Transactional
    public Job save(Job job){
        return (Job) jobDao.saveOrUpdate(job);
    }

    @Transactional
    public void populateDB(){

        ObjectMapper mapper = new ObjectMapper();
        JobDto jobDto1 = null;
        JobDto jobDto2 = null;
        JobDto jobDto3 = null;
        List<Skill> skillList = new ArrayList<>();

        try {
            jobDto1 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/BankRobbery.json"), JobDto.class);
            jobDto2 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/DiamondRobbery.json"), JobDto.class);
            jobDto3 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/SupermarketRobbery.json"), JobDto.class);
            Job job1 = jobDtoToJob.convert(jobDto1);
            Job job2 = jobDtoToJob.convert(jobDto2);
            Job job3 = jobDtoToJob.convert(jobDto3);


            for(Skill skill:job1.getSkills()){
                skillList.add(skill);
                skill.setJob(job1);
            }
            job1.setSkills(skillList);
            jobDao.saveOrUpdate(job1);

            skillList.clear();

            for(Skill skill:job2.getSkills()){
                skillList.add(skill);
                skill.setJob(job2);
            }
            job2.setSkills(skillList);
            jobDao.saveOrUpdate(job2);

            skillList.clear();

            for(Skill skill:job3.getSkills()){
                skillList.add(skill);
                skill.setJob(job3);
            }
            job3.setSkills(skillList);
            jobDao.saveOrUpdate(job3);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
