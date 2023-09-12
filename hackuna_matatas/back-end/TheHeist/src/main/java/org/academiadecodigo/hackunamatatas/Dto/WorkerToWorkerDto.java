package org.academiadecodigo.hackunamatatas.Dto;

import org.academiadecodigo.hackunamatatas.Dto.AbstractConverter;
import org.academiadecodigo.hackunamatatas.command.WorkerDto;
import org.academiadecodigo.hackunamatatas.model.Skill;
import org.academiadecodigo.hackunamatatas.model.Worker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class WorkerToWorkerDto extends AbstractConverter<Worker,WorkerDto> {

    public WorkerDto convert(Worker worker){

        WorkerDto workerDto = new WorkerDto();
        workerDto.setId(worker.getId());
        workerDto.setAlias(worker.getAlias());
        workerDto.setRate(worker.getRate());
        workerDto.setSeniority(worker.getSeniority());
        workerDto.setSkill(worker.getSkill());

        return workerDto;
    }
}
