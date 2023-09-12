package org.academiadecodigo.hackunamatatas.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.academiadecodigo.hackunamatatas.model.Skill;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobDto {

    private String title; //Diamond Heist
    private List<String> skills; //Driver, gunman, diamond specialist, robber

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
