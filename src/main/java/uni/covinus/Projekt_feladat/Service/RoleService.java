package uni.covinus.Projekt_feladat.Service;

import uni.covinus.Projekt_feladat.Entities.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    void deleteRole(Long roleId);
    Role getRoleById(Long roleId);
    List<Role> getAllRoles();
}
