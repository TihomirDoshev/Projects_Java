package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.binding.UserRegisterBindingModel;
import com.example.employee_management_system.model.entity.*;
import com.example.employee_management_system.model.entity.enums.DepartmentNameEnum;
import com.example.employee_management_system.model.entity.enums.LocationNameEnum;
import com.example.employee_management_system.model.entity.enums.PositionNameEnum;
import com.example.employee_management_system.model.view.EmployeeViewModel;
import com.example.employee_management_system.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    private static final String BOSS_USERNAME = "Boss";
    private static final String MODERATOR_USERNAME = "Moderator";
    private static final String USER_USERNAME = "User";
    private static final String EMPLOYEE1_FULL_NAME = "Ivan Ivanov";
    private static final String EMPLOYEE2_FULL_NAME = "Gosho Goshev";
    private static final String DTO_USERNAME = "username";
    private static final String DTO_PASSWORD = "password";
    private static final String USER1_USERNAME = "Ivan Ivanov";
    private static final String USER2_USERNAME = "Gosho Goshev";
    private static final String TOWN_NAME = "Veliko Tarnovo";
    private static final String STREET_NAME = "Marmarliiska 52";

    private EmployeeServiceImpl serviceToTest;
    @Mock
    private EmployeeRepository mockEmployeeRepository;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private PositionRepository mockPositionRepository;
    @Mock
    private DepartmentRepository mockDepartmentRepository;
    @Mock
    private LocationRepository mockLocationRepository;
    @Mock
    private AddressRepository mockAddressRepository;
    @Mock
    private ModelMapper mockModelMapper;

    @BeforeEach
    void setup() {
        serviceToTest = new EmployeeServiceImpl(
                mockEmployeeRepository, mockUserRepository, mockPositionRepository,
                mockDepartmentRepository, mockLocationRepository, mockAddressRepository,
                mockModelMapper);

    }

    @Test
    void testInitBossModeratorAndEmployee() {

        Location testLocation1 = createLocationMethod(LocationNameEnum.USA, 1L);
        User testUser1 = createUserMethod(BOSS_USERNAME);
        Position testPosition1 = createPositionMethod(PositionNameEnum.CEO);
        Department testDepartment1 = createDepartmentMethod(DepartmentNameEnum.EXECUTIVE);

        Location testLocation2 = createLocationMethod(LocationNameEnum.CANADA, 2L);
        User testUser2 = createUserMethod(MODERATOR_USERNAME);
        Position testPosition2 = createPositionMethod(PositionNameEnum.ADMIN_MANAGER);
        Department testDepartment2 = createDepartmentMethod(DepartmentNameEnum.ADMINISTRATION);

        Location testLocation3 = createLocationMethod(LocationNameEnum.BULGARIA, 3L);
        User testUser3 = createUserMethod(USER_USERNAME);
        Position testPosition3 = createPositionMethod(PositionNameEnum.CTO);
        Department testDepartment3 = createDepartmentMethod(DepartmentNameEnum.PRODUCT_MARKETING);

        when(mockEmployeeRepository.count()).thenReturn(0L);

        when(mockLocationRepository.findById(1L)).thenReturn(Optional.of(testLocation1));
        when(mockUserRepository.findUserByUsername(testUser1.getUsername())).thenReturn(Optional.of(testUser1));
        when(mockPositionRepository.findById(1L)).thenReturn(Optional.of(testPosition1));
        when(mockDepartmentRepository.findById(1L)).thenReturn(Optional.of(testDepartment1));

        when(mockLocationRepository.findById(2L)).thenReturn(Optional.of(testLocation2));
        when(mockUserRepository.findUserByUsername(testUser2.getUsername())).thenReturn(Optional.of(testUser2));
        when(mockPositionRepository.findById(2L)).thenReturn(Optional.of(testPosition2));
        when(mockDepartmentRepository.findById(2L)).thenReturn(Optional.of(testDepartment2));

        when(mockLocationRepository.findById(3L)).thenReturn(Optional.of(testLocation3));
        when(mockUserRepository.findUserByUsername(testUser3.getUsername())).thenReturn(Optional.of(testUser3));
        when(mockPositionRepository.findById(9L)).thenReturn(Optional.of(testPosition3));
        when(mockDepartmentRepository.findById(5L)).thenReturn(Optional.of(testDepartment3));

        serviceToTest.initEmployee();

    }

    @Test
    void testCantFindEmployeeWithGivenID() {
        Assertions
                .assertThrows(NoSuchElementException.class,
                        () -> serviceToTest.findEmployeeWithID(5L));
    }

    @Test
    void testFindEmployeeWithID() {

        EmployeeViewModel testEmployeeViewModel =
                new EmployeeViewModel().setFullName(EMPLOYEE1_FULL_NAME);

        Employee testEmployee = new Employee().setFullName(EMPLOYEE1_FULL_NAME);

        testEmployee.setId(5L);

        User testUser = createUserMethod(USER_USERNAME);
        testEmployeeViewModel.setUser(testUser.getUsername());

        when(mockEmployeeRepository.findById(5L)).thenReturn(Optional.of(testEmployee));

        when(mockUserRepository.findById(5L)).thenReturn(Optional.of(testUser));

        when(mockModelMapper.map(testEmployee, EmployeeViewModel.class)).thenReturn(testEmployeeViewModel);

        Optional<Employee> empByID = mockEmployeeRepository.findById(5L);
        Optional<User> userByID = mockUserRepository.findById(5L);

        EmployeeViewModel mappedViewModel = mockModelMapper.map(testEmployee, EmployeeViewModel.class);

        Assertions.assertEquals(EMPLOYEE1_FULL_NAME, empByID.get().getFullName());
        Assertions.assertEquals(USER_USERNAME, userByID.get().getUsername());

        Assertions.assertEquals(mappedViewModel, testEmployeeViewModel);

        serviceToTest.findEmployeeWithID(5L);

    }

    @Test
    void testCreateEmptyEmployee() {

        UserRegisterBindingModel testUserRegistrationDTO = new UserRegisterBindingModel();

        testUserRegistrationDTO
                .setUsername(DTO_USERNAME)
                .setPassword(DTO_PASSWORD);

        Employee testEmployee = new Employee();
        User testUser = createUserMethod(DTO_USERNAME);

        testEmployee.setUser(testUser);

        when(mockUserRepository.findUserByUsername(testUserRegistrationDTO.getUsername()))
                .thenReturn(Optional.of(testUser));

        serviceToTest.createEmptyEmploy(testUserRegistrationDTO);

        Optional<User> optionalTestUser = mockUserRepository.findUserByUsername(testUserRegistrationDTO.getUsername());

        Assertions.assertEquals(DTO_USERNAME, optionalTestUser.get().getUsername());
        Assertions.assertEquals(optionalTestUser, mockUserRepository.findUserByUsername(DTO_USERNAME));
        Assertions.assertEquals(DTO_USERNAME, testUser.getUsername());
        Assertions
                .assertEquals(testUser.getUsername(), mockUserRepository.findUserByUsername(DTO_USERNAME).get().getUsername());
    }

    @Test
    void nullEmployeesEXPERIMENT() {

        User testUser1 = new User().setUsername(USER1_USERNAME);
        User testUser2 = new User().setUsername(USER2_USERNAME);

        Employee testEmployee1 =
                new Employee()
                        .setEmail(null)
                        .setFullName(EMPLOYEE1_FULL_NAME)
                        .setUser(testUser1);

        testEmployee1.setId(1L);

        Employee testEmployee2 = new Employee().setEmail(null).setFullName(EMPLOYEE2_FULL_NAME).setUser(testUser2);
        testEmployee2.setId(2L);

        List<Employee> testEmployeeList = new ArrayList<>();

        testEmployeeList.add(testEmployee1);
        testEmployeeList.add(testEmployee2);

        when(mockEmployeeRepository.findAllByFullNameIsNull()).thenReturn(testEmployeeList);

        List<Employee> allByFullNameIsNull = mockEmployeeRepository.findAllByFullNameIsNull();

        Assertions.assertEquals(testEmployeeList.size(), allByFullNameIsNull.size());
        Assertions.assertEquals(EMPLOYEE1_FULL_NAME, allByFullNameIsNull.get(0).getFullName());
        Assertions.assertEquals(EMPLOYEE2_FULL_NAME, allByFullNameIsNull.get(1).getFullName());
        Assertions.assertNull(allByFullNameIsNull.get(0).getEmail());
        Assertions.assertNull(allByFullNameIsNull.get(1).getEmail());

        List<EmployeeViewModel> testEmployeeViewModelList = getEmployeeViewModels(allByFullNameIsNull, testUser1, testUser2);

        Assertions.assertEquals(testEmployeeList.size(), testEmployeeViewModelList.size());
        Assertions.assertEquals(serviceToTest.nullEmployees().size(), testEmployeeViewModelList.size());

    }

    @Test
    void testAllEmployees() {

        EmployeeViewModel testEmployeeViewModel = new EmployeeViewModel();
        List<EmployeeViewModel> testMainList = new ArrayList<>();
        List<Employee> testEmployeeList = new ArrayList<>();

        Location testLocation = new Location().setLocation(LocationNameEnum.BULGARIA);
        Address testAddress = new Address().setTown(TOWN_NAME).setStreet(STREET_NAME).setLocation(testLocation);
        User testUser = createUserMethod(USER2_USERNAME);
        Position testPosition = new Position().setPosition(PositionNameEnum.CEO);
        Department testDepartment = new Department().setDepartment(DepartmentNameEnum.DEVELOPMENT);
        Employee employee1 = new Employee()
                .setFullName(USER1_USERNAME)
                .setAddress(testAddress)
                .setUser(testUser)
                .setPosition(testPosition)
                .setDepartment(testDepartment);
        testEmployeeViewModel
                .setTown(employee1.getAddress().getTown())
                .setUser(employee1.getUser().getUsername())
                .setPosition(employee1.getPosition().getPosition().name())
                .setDepartment(employee1.getDepartment().getDepartment().name());

        testEmployeeList.add(employee1);

        when(mockEmployeeRepository.findAllByFullNameIsNotNull()).thenReturn(testEmployeeList);
        Assertions.assertEquals(mockEmployeeRepository.findAllByFullNameIsNotNull().size(), testEmployeeList.size());

        when(mockModelMapper.map(employee1, EmployeeViewModel.class)).thenReturn(testEmployeeViewModel);
        EmployeeViewModel map = mockModelMapper.map(employee1, EmployeeViewModel.class);
        testMainList.add(map);
        serviceToTest.allEmployees();
    }


    private static List<EmployeeViewModel> getEmployeeViewModels(List<Employee> allByFullNameIsNull, User testUser1, User testUser2) {
        EmployeeViewModel testEmployeeViewModel1 = new EmployeeViewModel();
        EmployeeViewModel testEmployeeViewModel2 = new EmployeeViewModel();

        List<EmployeeViewModel> testEmployeeViewModelList = new ArrayList<>();

        testEmployeeViewModel1.setEmail(allByFullNameIsNull.get(0).getEmail());
        testEmployeeViewModel1.setUser(testUser1.getUsername());
        testEmployeeViewModel2.setEmail(allByFullNameIsNull.get(1).getEmail());
        testEmployeeViewModel2.setUser(testUser2.getUsername());

        testEmployeeViewModelList.add(testEmployeeViewModel1);
        testEmployeeViewModelList.add(testEmployeeViewModel2);
        return testEmployeeViewModelList;
    }

    private Department createDepartmentMethod(DepartmentNameEnum name) {
        Department testDepartment = new Department();
        testDepartment.setDepartment(name);
        return testDepartment;

    }

    private Position createPositionMethod(PositionNameEnum name) {
        Position testPosition = new Position();
        testPosition.setPosition(name);
        return testPosition;

    }

    private User createUserMethod(String name) {
        User testUser = new User();
        testUser.setUsername(name);
        return testUser;

    }

    private Location createLocationMethod(LocationNameEnum name, Long id) {
        Location testLocation = new Location();
        testLocation
                .setLocation(name)
                .setId(id);
        return testLocation;

    }
}
