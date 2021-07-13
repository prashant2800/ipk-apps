package pk.sample.WebFluxApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pk.sample.WebFluxApp.model.Person;

@Repository
public interface UserRepository extends CrudRepository<Person, Integer> {
}
