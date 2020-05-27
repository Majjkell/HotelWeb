package hotel.repository;

import hotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

    @Query(value = "SELECT g FROM Guest AS g WHERE  g.firstName = ?1 AND g.password = ?2")
    Guest findFirstByFirstNameAndPassword(String firstName,String password);
}
