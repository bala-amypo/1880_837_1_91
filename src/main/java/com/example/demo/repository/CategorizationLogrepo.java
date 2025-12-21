package com.example.demo.repository;
import com.example.demo.model.CategorizationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.model.Ticket;
public interface CategorizationLogrepo extends JpaRepository<CategorizationLog,Long>{
    public List<CategorizationLog> findByTicketId(Long ticketid);
}
