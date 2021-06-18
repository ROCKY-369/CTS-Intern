package com.example.controller;

import com.example.model.Trainee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraineeController {
  private static List<Trainee> trainees;

  static {
    trainees = new ArrayList<>();
    trainees.add(new Trainee(1, "arun", "arun@ac.com", "CDE"));
    trainees.add(new Trainee(2, "ajay", "ajay@ac.com", "CDE"));
    trainees.add(new Trainee(3, "ram", "ram@ac.com", "CDE"));
    trainees.add(new Trainee(4, "sai", "sai@ac.com", "CDE"));
  }

  @GetMapping("/trainees")
  public List<Trainee> getAllTrainees() {
    return trainees;
  }

  @GetMapping("/trainee/{id}")
  public Trainee getTrainee(@PathVariable Integer id) {
    return trainees.stream().filter(t -> t.getId() == id).findAny().orElseThrow();
  }

  @PostMapping("/trainee")
  public void addTrainee(@RequestBody Trainee trainee) {
    trainees.add(trainee);
  }

  @PutMapping("/trainees/{id}")
  public void updateTrainee(
    @PathVariable Integer id,
    @RequestBody Trainee trainee
  ) {
    Trainee toBeUpdated = trainees.stream().filter(t -> t.getId() == id).findAny().orElseThrow();

    trainees.set(trainees.indexOf(toBeUpdated), trainee);
  }

  @DeleteMapping("/trainee/{id}")
  public Boolean deleteTrainee(@PathVariable Integer id) {
    Trainee toBeDeleted = trainees.stream().filter(t -> t.getId() == id).findAny().orElseThrow();
    return trainees.remove(toBeDeleted);
  }
}
