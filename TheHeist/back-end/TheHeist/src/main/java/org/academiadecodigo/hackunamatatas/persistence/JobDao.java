package org.academiadecodigo.hackunamatatas.persistence;

import org.academiadecodigo.hackunamatatas.model.Job;
import org.springframework.stereotype.Repository;

@Repository
public class JobDao extends GenericDao{


    public JobDao() {
        super(Job.class);
    }

}
