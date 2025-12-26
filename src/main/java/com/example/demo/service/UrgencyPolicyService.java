package com.example.demo.service.impl;
import com.example.demo.model.UrgencyPolicy;
import java.util.List;
public interface UrgencyPolicyservice{
    public UrgencyPolicy createPolicy(UrgencyPolicy policy);
    public List<UrgencyPolicy> getAllpolicies();
    public UrgencyPolicy getPolicy(Long id);
}