package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Client;
import rovshan.insurance_app.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(@Autowired ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public Client create(@Valid @RequestBody Client client){
        return clientService.create(client);
    }

    @GetMapping("/read/{clientId}")
    public Client read(@Valid @PathVariable("clientId") Long clientId_){
        return clientService.read(clientId_);
    }

    @GetMapping("/readAll")
    public List<Client> readAll(){
        return clientService.readAll();
    }

    @PutMapping("/update")
    public Client update(@Valid @RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/delete/{clientId}")
    public Client delete(@Valid @PathVariable("clientId") Long clientId_){
        return clientService.delete(clientId_);
    }
}
