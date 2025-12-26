package com.example.demo.controller;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.service.impl.UrgencyPolicyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class UrgencyPolicyController {

    private final UrgencyPolicyServiceImpl policyService;

    public UrgencyPolicyController(UrgencyPolicyServiceImpl policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public UrgencyPolicy create(@RequestBody UrgencyPolicy policy) {
        return policyService.createPolicy(policy);
    }

    @GetMapping
    public List<UrgencyPolicy> getAll() {
        return policyService.getAllPolicies();
    }
}
