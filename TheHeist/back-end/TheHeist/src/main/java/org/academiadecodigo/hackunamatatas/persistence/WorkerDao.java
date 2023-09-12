package org.academiadecodigo.hackunamatatas.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.hackunamatatas.command.WorkerDto;
import org.academiadecodigo.hackunamatatas.model.Worker;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class WorkerDao extends GenericDao{

    private ObjectMapper mapper = new ObjectMapper();

    public WorkerDao() {
        super(Worker.class);
    }

    public List<WorkerDto> findAll(){

        List<WorkerDto> workerList = new LinkedList<>();

        try {
            WorkerDto workerDto = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/hackuna_matatas/back-end/TheHeist/src/main/resources/jsonBin/SamuelLJackson.json"), WorkerDto.class);
            workerList.add(workerDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return workerList;
    }

    public Worker get(){

        Worker worker;
        try {
            worker = mapper.readValue(new File("/Users/codecadet/Desktop/exercises/myRepo/TheHeist/src/main/resources/jsonBin/SamuelLJackson.json"), Worker.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return worker;
    }

    public List<Worker> findBySkill(String skill){
        TypedQuery<Object[]> query =  em.createQuery("SELECT DISTINCT FROM worker WHERE skill = 'skill'",Object[].class);
        query.setParameter("skill",skill);


        List<Worker> workers = new ArrayList<>();
        List<Object[]> resultList = query.getResultList();

        for (Object[] result : resultList) {
            Integer id = (Integer) result[0];
            String alias = (String) result[1];
            Double rate = (Double) result[2];
            String seniority = (String) result[3];
            String workerSkill = (String) result[4];

            Worker worker = new Worker();
            worker.setId(id);
            worker.setAlias(alias);
            worker.setRate(rate);
            worker.setSeniority(seniority);
            worker.setSkill(workerSkill);

            workers.add(worker);
        }

        return workers;
    }

}
