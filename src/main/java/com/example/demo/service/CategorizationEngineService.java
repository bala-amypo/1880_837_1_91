package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;

import java.util.List;

public interface CategorizationEngineService {

    // Categorize a ticket using rules & policies
    Ticket categorizeTicket(Long ticketId);

    // Get single categorization log by log id
    CategorizationLog getLog(Long logId);

    // Get all logs related to a ticket
    List<CategorizationLog> getLogsForTicket(Long ticketId);
}
