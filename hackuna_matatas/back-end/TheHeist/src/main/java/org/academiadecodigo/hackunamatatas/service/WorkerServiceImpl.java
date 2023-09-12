package org.academiadecodigo.hackunamatatas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.hackunamatatas.Dto.WorkerDtoToWorker;
import org.academiadecodigo.hackunamatatas.command.WorkerDto;
import org.academiadecodigo.hackunamatatas.model.Job;
import org.academiadecodigo.hackunamatatas.model.Worker;
import org.academiadecodigo.hackunamatatas.persistence.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl {

    private WorkerDao workerDao;
    private WorkerDtoToWorker workerDtoToWorker;

    @Autowired
    public void setWorkerDtoToWorker(WorkerDtoToWorker workerDtoToWorker) {
        this.workerDtoToWorker = workerDtoToWorker;
    }

    @Autowired
    public void setWorkerDao(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Transactional
    public List<WorkerDto> list(){
        return workerDao.findAll();
    }

    @Transactional
    public List<Worker> findBySkill(String skill){
        return workerDao.findBySkill(skill);
    }
    @Transactional
    public Worker get(){
        return workerDao.get();
    }

    @Transactional
    public Worker getWorker(Integer id){
        return (Worker) workerDao.find(id);
    }

    @Transactional
    public Worker save(Worker worker){
        return (Worker) workerDao.saveOrUpdate(worker);
    }

    @Transactional
    public List<Worker> populateDB(){

        ObjectMapper mapper = new ObjectMapper();
        WorkerDto workerDto1 = null;
        WorkerDto workerDto2 = null;
        WorkerDto workerDto3 = null;
        WorkerDto workerDto4 = null;
        WorkerDto workerDto5 = null;
        WorkerDto workerDto6 = null;
        WorkerDto workerDto7 = null;
        WorkerDto workerDto8 = null;
        WorkerDto workerDto9 = null;
        try {
            workerDto1 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/SamuelLJackson.json"), WorkerDto.class);
            workerDto2 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/MrBlonde.json"), WorkerDto.class);
            workerDto3 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/MrBlue.json"), WorkerDto.class);
            workerDto4 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/MrBrown.json"), WorkerDto.class);
            workerDto5 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/MrOrange.json"), WorkerDto.class);
            workerDto6 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/MrPink.json"), WorkerDto.class);
            workerDto7 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/MrWhite.json"), WorkerDto.class);
            workerDto8 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/NiceGuyEddie.json"), WorkerDto.class);
            workerDto9 = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/JoeCabot.json"), WorkerDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(workerDto1.getAlias()+" "+workerDto1.getSkill());
        System.out.println(workerDto9.getAlias()+" "+workerDto9.getSkill());
        List<Worker> workerList =new ArrayList<>();

        Worker worker1 = workerDtoToWorker.convert(workerDto1);
        Worker worker2 = workerDtoToWorker.convert(workerDto2);
        Worker worker3 = workerDtoToWorker.convert(workerDto3);
        Worker worker4 = workerDtoToWorker.convert(workerDto4);
        Worker worker5 = workerDtoToWorker.convert(workerDto5);
        Worker worker6 = workerDtoToWorker.convert(workerDto6);
        Worker worker7 = workerDtoToWorker.convert(workerDto7);
        Worker worker8 = workerDtoToWorker.convert(workerDto8);
        Worker worker9 = workerDtoToWorker.convert(workerDto9);

        workerList.add((Worker) workerDao.saveOrUpdate(worker1));
        workerList.add((Worker) workerDao.saveOrUpdate(worker2));
        workerList.add((Worker) workerDao.saveOrUpdate(worker3));
        workerList.add((Worker) workerDao.saveOrUpdate(worker4));
        workerList.add((Worker) workerDao.saveOrUpdate(worker5));
        workerList.add((Worker) workerDao.saveOrUpdate(worker6));
        workerList.add((Worker) workerDao.saveOrUpdate(worker7));
        workerList.add((Worker) workerDao.saveOrUpdate(worker8));
        workerList.add((Worker) workerDao.saveOrUpdate(worker9));

        return workerList;
    }
}
