package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Cv;

import java.util.List;

public interface CvServiceInterf {
    List<Cv> getAllCvs();
    void saveCv(Cv cv);
    Cv getCv(Long id);
    Cv getCandidateById(long id);

}
