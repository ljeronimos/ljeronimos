package org.academiadecodigo.hackunamatatas.Dto;

import org.academiadecodigo.hackunamatatas.command.WorkerDto;
import org.academiadecodigo.hackunamatatas.model.Skill;
import org.academiadecodigo.hackunamatatas.model.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class WorkerDtoToWorker extends AbstractConverter<WorkerDto, Worker> {

    public Worker convert(WorkerDto workerDto){

        Worker worker = new Worker();
        worker.setAlias(workerDto.getAlias());
        worker.setRate(workerDto.getRate());
        worker.setSeniority(workerDto.getSeniority());
        worker.setSkill(workerDto.getSkill());

        return worker;
    }
}
