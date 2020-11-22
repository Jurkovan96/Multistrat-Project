package com.example.demo.mapper;

import com.example.demo.entity.Project;
import com.example.demo.entity.Team;
import com.example.demo.model.ProjectDto;
import org.modelmapper.ModelMapper;

public class ModelMapperImpl {

    public static void main(String[] args) {
        Project project = new Project();
        project.setProjectName("ceva");
        project.setProjectId(1);
        project.setProjectTeam(new Team());

        mapProject(project);
    }

    private static void mapProject(Project project) {
        ModelMapper modelMapper = new ModelMapper();
        ProjectDto projectDto = new ProjectDto();
        modelMapper.map(project, projectDto);

        System.out.println(projectDto.getProjectId());
        System.out.println(projectDto.getProjectName());
    }


}
