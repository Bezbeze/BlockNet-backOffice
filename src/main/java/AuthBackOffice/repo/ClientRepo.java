package AuthBackOffice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import AuthBackOffice.entity.ClientDataEntity;

public interface ClientRepo extends MongoRepository<ClientDataEntity, String> {

}
