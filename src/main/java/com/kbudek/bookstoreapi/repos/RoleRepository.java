package com.kbudek.bookstoreapi.repos;

import com.kbudek.bookstoreapi.domain.Role;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;

import java.util.Set;
import java.util.UUID;

public interface RoleRepository {
    Set<Role> getAllRoles() throws BSAuthException;

    Set<Role> getUserRoles(UUID user_id);

    Role getRoleById(UUID role_id, String name) throws BSResourceNotFoundException;

    Role addRole(UUID role_id, String name) throws BSAuthException;

    void updateRole(UUID role_id, Role role) throws BSBadRequestException;

    void removeRole(UUID role_id);

}
