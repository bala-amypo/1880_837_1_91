package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;

import java.util.List;

public class UrgencyPolicyServiceImpl {

    private final UrgencyPolicyRepository policyRepository;

    public UrgencyPolicyServiceImpl(UrgencyPolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public UrgencyPolicy createPolicy(UrgencyPolicy policy) {
        return policyRepository.save(policy);
    }

    public UrgencyPolicy getPolicy(Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy not found"));
    }

    public List<UrgencyPolicy> getAllPolicies() {
        return policyRepository.findAll();
    }
}
