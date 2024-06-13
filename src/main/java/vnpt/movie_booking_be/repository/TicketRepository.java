package vnpt.movie_booking_be.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vnpt.movie_booking_be.models.Ticket;

import java.util.Date;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("SELECT t.total FROM Ticket t WHERE t.id = :ticketId")
    Integer findTotalByTicketId(@Param("ticketId") int ticketId);

    @Query("SELECT t.orderTime FROM Ticket t WHERE t.id = :ticketId")
    Date findOrderTimeByTicketId(@Param("ticketId") int ticketId);

    @Query("SELECT t.status FROM Ticket t WHERE t.id = :ticketId")
    Integer findStatusByTicketId(@Param("ticketId") int ticketId);

    @Query("SELECT t.user.id FROM Ticket t WHERE t.id = :ticketId")
    Integer findUserIdByTicketId(@Param("ticketId") int ticketId);

    @Query("SELECT t.movie.id FROM Ticket t WHERE t.id = :ticketId")
    Integer findMovieIdByTicketId(@Param("ticketId") int ticketId);

    @Query("SELECT t.screening.id FROM Ticket t WHERE t.id = :ticketId")
    Integer findScreeningIdByTicketId(@Param("ticketId") int ticketId);

    @Modifying
    @Transactional
    @Query("UPDATE Ticket t SET t.qrcode = :qr WHERE t.id = :ticketId")
    void updateQRCodeByTicketId(@Param("ticketId") int ticketId, @Param("qr") String qr);
}
