package Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import repos.ClientRepos;

public class ClientService {
    @Autowired
    private ClientRepos clientRepos ;
    @Autowired
    private ModelMapper modelMapper ;




}
