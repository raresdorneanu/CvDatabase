package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Cv;
import net.javaguides.springboot.repository.CvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CvService implements CvServiceInterf{
    @Autowired
    private CvRepo cvRepo;

    public List<Cv> getAllCvs(String keyword){
        if(keyword != null){
            return cvRepo.getAllCvs(keyword);
        }
        return cvRepo.findAll();
    }

    public Cv getCv(@PathVariable Long id){
        return cvRepo.findById(id).get();
    }

    @Override
    public List<Cv> getAllCvs() {
        return cvRepo.findAll();
    }

    public void saveCv(Cv cv){
        cvRepo.save(cv);
    }
    public void deleteCv(@PathVariable Long id){
        cvRepo.deleteById(id);
    }

    public Page<Cv> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.cvRepo.findAll(pageable);
    }


    public Cv getCandidateById(long id) {
        Optional<Cv> optional = cvRepo.findById(id);
        Cv candidate = null;
        if (optional.isPresent()) {
            candidate = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return candidate;
    }
}
