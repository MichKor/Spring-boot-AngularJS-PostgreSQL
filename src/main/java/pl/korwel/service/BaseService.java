package pl.korwel.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseService<T, ID extends Serializable> {

    private JpaRepository<T, ID> repository;

    public BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        List<T> list = new LinkedList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public T getOne(ID id) {
        return repository.findOne(id);
    }

    public void addNew(T t) {
        repository.save(t);
    }

    public void update(ID id, T t) {
        repository.save(t);
    }

    public void delete(ID id) {
        repository.delete(id);
    }
}