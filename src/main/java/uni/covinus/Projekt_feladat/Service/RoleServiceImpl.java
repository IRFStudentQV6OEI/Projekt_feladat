package uni.covinus.Projekt_feladat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import uni.covinus.Projekt_feladat.Entities.Role;
import uni.covinus.Projekt_feladat.Repositories.RoleRepository;

import java.util.List;
import java.util.Optional;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        validateRole(role);
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public Role getRoleById(Long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        return role.orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    private void validateRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        if (!StringUtils.hasText(role.getName())) {
            throw new IllegalArgumentException("Role name is required");
        }
        // Itt további validációs szabályokat adhatsz hozzá
    }
}
