package org.academiadecodigo.hackunamatatas.controller;

import org.academiadecodigo.hackunamatatas.Dto.JobDtoToJob;
import org.academiadecodigo.hackunamatatas.Dto.JobToJobDto;
import org.academiadecodigo.hackunamatatas.Dto.WorkerDtoToWorker;
import org.academiadecodigo.hackunamatatas.Dto.WorkerToWorkerDto;
import org.academiadecodigo.hackunamatatas.command.JobDto;
import org.academiadecodigo.hackunamatatas.command.WorkerDto;
import org.academiadecodigo.hackunamatatas.model.Job;
import org.academiadecodigo.hackunamatatas.model.Skill;
import org.academiadecodigo.hackunamatatas.model.Worker;
import org.academiadecodigo.hackunamatatas.service.JobServiceImpl;
import org.academiadecodigo.hackunamatatas.service.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class WorkerControllerREST {

    private WorkerServiceImpl workerService;
    private JobServiceImpl jobService;
    private WorkerToWorkerDto workerToWorkerDto;

    private WorkerDtoToWorker workerDtoToWorker;
    private JobToJobDto jobToJobDto;
    private JobDtoToJob jobDtoToJob;

    @Autowired
    public void setJobDtoToJob(JobDtoToJob jobDtoToJob) {
        this.jobDtoToJob = jobDtoToJob;
    }

    @Autowired
    public void setWorkerService(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }

    @Autowired
    public void setJobService(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @Autowired
    public void setWorkerDtoToWorker(WorkerDtoToWorker workerDtoToWorker) {
        this.workerDtoToWorker = workerDtoToWorker;
    }

    @Autowired
    public void setWorkerToWorkerDto(WorkerToWorkerDto workerToWorkerDto) {
        this.workerToWorkerDto = workerToWorkerDto;
    }

    @Autowired
    public void setJobToJobDto(JobToJobDto jobToJobDto) {
        this.jobToJobDto = jobToJobDto;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/skills")
    public ResponseEntity<JobDto> listSkills(@RequestBody JobDto jobDto){

        System.out.println(jobDto.getTitle());
        Job job;

        switch (jobDto.getTitle()){
            case "Bank Robbery":
                job = jobService.getJob(1);
                break;
            case "Diamond Robbery":
                job = jobService.getJob(2);
                break;
            case "Supermarket Robbery":
                job = jobService.getJob(3);
                break;
            default:
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        JobDto jobDto1 = jobToJobDto.convert(job);
        return new ResponseEntity<>(jobDto1,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/workers")
    public ResponseEntity<List<Worker>> listWorkers(@RequestBody ArrayList<String> skillList){

        List<Integer> skillsId = new ArrayList<>();

        for(String skill:skillList){
            switch (skill){
                case "mastermind":
                    skillsId.add(1);
                    skillsId.add(9);
                    break;
                case "muscle":
                    skillsId.add(2);
                    break;
                case "diamond Specialist":
                    skillsId.add(3);
                    break;
                case "distraction":
                    skillsId.add(4);
                    break;
                case "gunner":
                    skillsId.add(5);
                    skillsId.add(6);
                    break;
                case "cleanup":
                    skillsId.add(7);
                    break;
                case "driver":
                    skillsId.add(8);
                    break;
            }
        }

        List<Worker> workerList = new ArrayList<>();
        for(Integer id:skillsId) {
            Worker worker = workerService.getWorker(id);
            workerList.add(worker);
        }

        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public ResponseEntity<WorkerDto> sendWorker(){

        WorkerDto workerDto = workerToWorkerDto.convert(workerService.get());

        return new ResponseEntity<>(workerDto,HttpStatus.I_AM_A_TEAPOT);
    }
}
