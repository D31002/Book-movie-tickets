package vnpt.movie_booking_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnpt.movie_booking_be.models.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Integer> {
    Membership findByName(String name);
}
