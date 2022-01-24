package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvRepo extends JpaRepository<Cv, Long> {
    @Query("SELECT cv FROM Cv cv WHERE cv.firstName LIKE %?1%")
    public List<Cv> getAllCvs(String keyword);
}
