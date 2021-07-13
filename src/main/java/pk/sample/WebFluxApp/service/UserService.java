package pk.sample.WebFluxApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.sample.WebFluxApp.model.Person;
import pk.sample.WebFluxApp.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<Person> getAllUsers()
    {
        List<Person> users = new ArrayList<Person>();
        userRepository.findAll().forEach(student -> users.add(student));
        return users;
    }
    public Person getUserById(int id)
    {
        return userRepository.findById(id).get();
    }
    public void saveOrUpdate(Person student)
    {
        userRepository.save(student);
    }
    public void delete(int id)
    {
        userRepository.deleteById(id);
    }

}
