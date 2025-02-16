package tasks.task_demo.user.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import tasks.task_demo.user.entitY.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findByUsername(String username);
}
