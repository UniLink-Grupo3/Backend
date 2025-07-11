package com.epicor.platform.u202111952.movilesback.controller;

import com.epicor.platform.u202111952.movilesback.model.UniversityStudentWithoutCar;
import com.epicor.platform.u202111952.movilesback.repository.UniversityStudentWithoutCarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final UniversityStudentWithoutCarRepository repo;

    public StudentController(UniversityStudentWithoutCarRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Map<String, Object> createStudent(@RequestBody UniversityStudentWithoutCar student) {
        student.setId(null);
        student.setImage("default_image.png");
        UniversityStudentWithoutCar saved = repo.save(student);
        return Map.of("success", true, "id", saved.getId());
    }

    @GetMapping
    public List<UniversityStudentWithoutCar> getAllStudents() {
        return repo.findAll();
    }
}
