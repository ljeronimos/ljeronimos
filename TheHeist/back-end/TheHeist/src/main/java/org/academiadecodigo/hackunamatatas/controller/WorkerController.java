package org.academiadecodigo.hackunamatatas.controller;

import org.academiadecodigo.hackunamatatas.service.WorkerServiceImpl;
import org.academiadecodigo.hackunamatatas.Dto.WorkerToWorkerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorkerController {

    private WorkerToWorkerDto workerToWorkerDto;
    private WorkerServiceImpl workerService;

    @Autowired
    public void setWorkerToWorkerDto(WorkerToWorkerDto workerToWorkerDto) {
        this.workerToWorkerDto = workerToWorkerDto;
    }

    @Autowired
    public void setWorkerService(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }


   /*@RequestMapping(method = RequestMethod.GET, path = "/heist")
    public String showHeist(Model model){
        model.addAttribute("workers",workerToWorkerDto.convert(workerService.list()));
        return "theheist/start";
    }*/
}
