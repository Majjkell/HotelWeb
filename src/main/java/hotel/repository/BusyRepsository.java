package hotel.repository;

import hotel.model.Busy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusyRepsository extends JpaRepository<Busy,Long> {
}
