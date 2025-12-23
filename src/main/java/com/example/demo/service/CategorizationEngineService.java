package com.example.demo.service.impl;
import java.util.List;
import com.example.demo.model.Ticket;
import com.example.demo.model.CategorizationLog;
public interface CategorizationEngineService{
    Ticket categorizeTicket(Long ticketid);
    List<CategorizationLog> getLogsForTicket(Long ticketid);
    CategorizationLog getLog(Long id);
}