package com.kbudek.bookstoreapi.repos;

import com.kbudek.bookstoreapi.domain.Role;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public Set<Role> getAllRoles() throws BSAuthException {
        return null;
    }

    @Override
    public Set<Role> getUserRoles(UUID user_id) {
        return null;
    }

    @Override
    public Role getRoleById(UUID role_id, String name) throws BSResourceNotFoundException {
        return null;
    }

    @Override
    public Role addRole(UUID role_id, String name) throws BSAuthException {
        return null;
    }

    @Override
    public void updateRole(UUID role_id, Role role) throws BSBadRequestException {

    }

    @Override
    public void removeRole(UUID role_id) {

    }
}
