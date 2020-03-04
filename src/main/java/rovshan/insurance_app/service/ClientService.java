package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Client;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(@Autowired ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        Optional<Client> clientOP = Optional.ofNullable(client);
        return clientRepository.save(clientOP.orElseThrow(() ->
                new Exception("CREATE CLIENT operation could not be executed. Input data is invalid")));
    }

    public Client read(Long clientId_) {
        return clientRepository.findById(clientId_).orElseThrow(() ->
                new Exception(String.format("READ CLIENT operation could not be executed. CLIENT with %d id could not be found", clientId_)));
    }
}