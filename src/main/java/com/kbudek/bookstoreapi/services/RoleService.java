package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.Role;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoleService {

    Set<Role> getAllRoles();

    Set<Role> getUserRoles(UUID user_id);

    Role getRoleById(UUID role_id, String name) throws BSResourceNotFoundException;

    Role addRole(UUID role_id, String name) throws BSBadRequestException;

    void updateRole(UUID role_id, Role role) throws BSBadRequestException;

    void removeRole(UUID role_id) throws BSResourceNotFoundException;
}
