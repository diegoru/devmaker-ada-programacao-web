package br.com.ada.adabook.repository;

import br.com.ada.adabook.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    UserDetails findByLogin(String Login);
}
