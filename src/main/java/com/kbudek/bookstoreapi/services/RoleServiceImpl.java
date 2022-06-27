package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.Role;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;
import com.kbudek.bookstoreapi.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Set<Role> getAllRoles() {
        return null;
    }

    @Override
    public Set<Role> getUserRoles(UUID user_id) {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(UUID.randomUUID(), "admin"));
        roles.add(new Role(UUID.randomUUID(), "user"));
        roles.add(new Role(UUID.randomUUID(), "tester"));
        return roles;
    }

    @Override
    public Role getRoleById(UUID role_id, String name) throws BSResourceNotFoundException {
        return null;
    }

    @Override
    public Role addRole(UUID role_id, String name) throws BSBadRequestException {
        return null;
    }

    @Override
    public void updateRole(UUID role_id, Role role) throws BSBadRequestException {

    }

    @Override
    public void removeRole(UUID role_id) throws BSResourceNotFoundException {

    }
}
