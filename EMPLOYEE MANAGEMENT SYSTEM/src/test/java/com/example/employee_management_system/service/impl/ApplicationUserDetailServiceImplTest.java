package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Role;
import com.example.employee_management_system.model.entity.User;
import com.example.employee_management_system.model.entity.enums.RoleNameEnum;
import com.example.employee_management_system.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailServiceImplTest {
    private static final String TEST_USERNAME = "Vomer";
    private static final String TEST_PASSWORD = "1234";
    private static final int TEST_AUTHORITY_NUMBER = 3;
    private ApplicationUserDetailServiceImpl serviceToTest;
    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setup() {
        serviceToTest = new ApplicationUserDetailServiceImpl(mockUserRepository);

    }

    @Test
    void testThrowUsernameNotFoundException() {
        Assertions
                .assertThrows(UsernameNotFoundException.class,
                        () -> serviceToTest.loadUserByUsername(TEST_USERNAME));

    }

    @Test
    void testThatDataIsFilledCorrectly() {

        User testUser = createUser(TEST_USERNAME, TEST_PASSWORD);

        Role testRole1 = createRole(RoleNameEnum.EMPLOYEE);
        Role testRole2 = createRole(RoleNameEnum.MODERATOR);
        Role testRole3 = createRole(RoleNameEnum.BOSS);

        List<Role> testRoleList = new ArrayList<>();

        testRoleList.add(testRole1);
        testRoleList.add(testRole2);
        testRoleList.add(testRole3);

        testUser.setRoles(testRoleList);

        when(mockUserRepository.findUserByUsername(testUser.getUsername()))
                .thenReturn(Optional.of(testUser));

        UserDetails testUserDetails = serviceToTest.loadUserByUsername(testUser.getUsername());

        Assertions.assertEquals(testUser.getUsername(), testUserDetails.getUsername());
        Assertions.assertEquals(testUser.getPassword(), testUserDetails.getPassword());

        Assertions.assertEquals(testUser.getRoles().size(), testUserDetails.getAuthorities().size());

        Assertions.assertEquals(TEST_AUTHORITY_NUMBER, testUser.getRoles().size());
        Assertions.assertEquals(TEST_AUTHORITY_NUMBER, testUserDetails.getAuthorities().size());

    }

    private Role createRole(RoleNameEnum roleName) {
        return new Role()
                .setRole(roleName);

    }

    private User createUser(String name, String password) {
        return new User()
                .setUsername(name)
                .setPassword(password);

    }
}
