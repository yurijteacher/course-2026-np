package ua.com.kisit.course2026np.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.course2026np.entity.Clients;
import ua.com.kisit.course2026np.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientsService {

    private final ClientRepository clientRepository;

    public void saveNewClient(Clients client) {
        clientRepository.save(client);
    }

    public Clients findById(Long id) {
        return clientRepository.findById(id).get();
    }


}
