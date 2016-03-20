package ro.robertgabriel.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ro.robertgabriel.entities.AccessLog;
import ro.robertgabriel.repositories.AccessLogRepository;

import javax.inject.Inject;
import java.util.List;

@Service
public class DefaultAccessLogService {
    @Inject
    public AccessLogRepository accessLogRepository;

    public List<AccessLog> get() {
        return accessLogRepository.findAll();
    }


    public Page<AccessLog> getPaginated(PageRequest pageRequest) {
        return accessLogRepository.findAll(pageRequest);
    }
}
