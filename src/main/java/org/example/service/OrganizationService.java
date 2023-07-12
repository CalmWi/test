package org.example.service;

import org.example.common.Status;
import org.example.model.Organization;

import java.util.List;

public class OrganizationService {
    public static void printOpenedOrganizations(List<Organization> organizations) {
        organizations.stream()
                .filter(org -> org.getStatus().equals(Status.OPENED))
                .forEach(System.out::println);
    }
}
