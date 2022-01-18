package br.com.ms.hrworker.services;

import br.com.ms.hrworker.entities.Worker;
import br.com.ms.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public List<Worker> findAll(Sort sort) {
        return workerRepository.findAll(sort);
    }

    public List<Worker> findAllById(Iterable<Long> iterable) {
        return workerRepository.findAllById(iterable);
    }

    public <S extends Worker> List<S> saveAll(Iterable<S> iterable) {
        return workerRepository.saveAll(iterable);
    }

    public Worker getOne(Long aLong) {
        return workerRepository.getOne(aLong);
    }

    public <S extends Worker> S save(S s) {
        return workerRepository.save(s);
    }

    public Optional<Worker> findById(Long aLong) {
        return workerRepository.findById(aLong);
    }

    public long count() {
        return workerRepository.count();
    }

    public void deleteById(Long aLong) {
        workerRepository.deleteById(aLong);
    }

    public void delete(Worker worker) {
        workerRepository.delete(worker);
    }

    public <S extends Worker> Optional<S> findOne(Example<S> example) {
        return workerRepository.findOne(example);
    }

    public <S extends Worker> Page<S> findAll(Example<S> example, Pageable pageable) {
        return workerRepository.findAll(example, pageable);
    }

    public <S extends Worker> boolean exists(Example<S> example) {
        return workerRepository.exists(example);
    }
}
