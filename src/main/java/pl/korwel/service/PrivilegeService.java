package pl.korwel.service;

import pl.korwel.model.Privilege;
import pl.korwel.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeService extends BaseService<Privilege, Long> {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    public PrivilegeService(PrivilegeRepository privilegeRepository) {
        super(privilegeRepository);
    }

    public Privilege getByName(String name) {
        return  privilegeRepository.findByName(name);
    }
}
