package com.example.demo.service.impl;

import com.example.demo.service.impl.CategorizationEngineService;
import com.example.demo.model.Ticket;
import com.example.demo.model.CategorizationLog;
import com.example.demo.repository.Ticketrepo;
import com.example.demo.repository.CategorizationLogrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class  CategorizationEngineServiceimpl implements CategorizationEngineService{
    @Autowired
    CategorizationLogrepo obj1;
    @Autowired
    Ticketrepo obj2; 
    public Ticket categorizeTicket(Long ticketid){
        return obj2.findById(ticketid).orElseThrow(()->new RuntimeException("No Id Found"));

    }
    public List<CategorizationLog> getLogsForTicket(Long ticketid){
        return obj1.findByTicketId(ticketid);
    }
    public CategorizationLog getLog(Long id){
        return obj1.findById(id).orElse(null);
    }
}