package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.binding.EmployeeFillInfoBindingModel;
import com.example.employee_management_system.model.binding.UserRegisterBindingModel;
import com.example.employee_management_system.model.entity.*;
import com.example.employee_management_system.model.view.EmployeeViewModel;
import com.example.employee_management_system.model.view.EmptyEmployeeViewModel;
import com.example.employee_management_system.repository.*;
import com.example.employee_management_system.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;
    private final LocationRepository locationRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository, PositionRepository positionRepository, DepartmentRepository departmentRepository, LocationRepository locationRepository, AddressRepository addressRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initEmployee() {
        if (employeeRepository.count() > 0) {
            return;
        }
        addBoss();
        addModerator();
        addEmployee();
    }

    @Override
    public List<EmployeeViewModel> allEmployees() {
        return employeeRepository
                .findAllByFullNameIsNotNull()
                .stream()
                .map(employee -> {
                    EmployeeViewModel employeeViewModel = modelMapper.map(employee, EmployeeViewModel.class);
                    employeeViewModel
                            .setTown(employee.getAddress().getTown())
                            .setUser(employee.getUser().getUsername())
                            .setPosition(employee.getPosition().getPosition().name())
                            .setDepartment(employee.getDepartment().getDepartment().name());
                    return employeeViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void createEmptyEmploy(UserRegisterBindingModel userRegisterBindingModel) {
        Employee employee = new Employee();
        employee.setUser(userRepository.findUserByUsername(userRegisterBindingModel.getUsername()).orElseThrow());
        employeeRepository.save(employee);
    }

    @Override
    public List<EmptyEmployeeViewModel> nullEmployees() {
        List<Employee> allByFullNameIsNull = employeeRepository.findAllByFullNameIsNull();
        List<EmptyEmployeeViewModel> empty = new ArrayList<>();
        for (Employee employee : allByFullNameIsNull) {
            String username = employee.getUser().getUsername();
            Long id = employee.getUser().getId();
            EmptyEmployeeViewModel employeeViewModel = new EmptyEmployeeViewModel();
            employeeViewModel.setUserID(id);
            employeeViewModel.setUsername(username);
            empty.add(employeeViewModel);
        }
        return empty;
    }

    @Override
    public EmployeeViewModel findEmployeeWithID(Long id) {
        Employee byId = employeeRepository.findById(id).orElseThrow();
        EmployeeViewModel map = modelMapper.map(byId, EmployeeViewModel.class);
        map.setUser(userRepository.findById(id).get().getUsername());
        return map;
    }

    @Override
    public void fillDataWithMoreEmployeeInfo(Long id, EmployeeFillInfoBindingModel employeeFillInfoBindingModel) {
        Employee employeeToUpdate = modelMapper.map(employeeFillInfoBindingModel, Employee.class);

        Address address = new Address();
        address
                .setStreet(employeeFillInfoBindingModel.getStreet())
                .setTown(employeeFillInfoBindingModel.getTown())
                .setLocation(locationRepository.findLocationByLocation(employeeFillInfoBindingModel.getLocation()));
        addressRepository.save(address);

        employeeToUpdate
                .setAddress(address)
                .setDepartment(departmentRepository.findDepartmentByDepartment(employeeFillInfoBindingModel.getDepartment()))
                .setPosition(positionRepository.findPositionByPosition(employeeFillInfoBindingModel.getPosition()))
                .setUser(userRepository.findById(id).orElseThrow());

        employeeRepository.save(employeeToUpdate);
    }

    @Override
    public EmployeeFillInfoBindingModel findByIDTEST(Long id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        EmployeeFillInfoBindingModel map = modelMapper.map(byId, EmployeeFillInfoBindingModel.class);
        System.out.println();
        return map;
    }


    private void addEmployee() {
        Employee employee = new Employee();
        Address address = new Address();

        Location location = locationRepository.findById(3L).orElseThrow();
        location.setId(3L);

        address
                .setTown("Veliko Tarnovo")
                .setStreet("Ul. Vasil Levski N11")
                .setLocation(location);
        addressRepository.save(address);

        employee.setUser(userRepository.findUserByUsername("User").orElseThrow())
                .setFullName("User Userov")
                .setEmail("user@gmail.com")
                .setBirthday(LocalDate.of(1995, 9, 9))
                .setHiredOn(LocalDate.of(2015, 6, 6))
                .setMobilePhone("0889461834")
                .setPosition(positionRepository.findById(9L).orElseThrow())
                .setDepartment(departmentRepository.findById(5L).orElseThrow())
                .setAddress(address);
        employeeRepository.save(employee);
    }

    private void addModerator() {
        Employee employee = new Employee();
        Address address = new Address();

        Location location = locationRepository.findById(2L).orElseThrow();
        location.setId(3L);

        address
                .setTown("Sofia")
                .setStreet("Ul. Hristo Botev N17")
                .setLocation(location);
        addressRepository.save(address);

        employee.setUser(userRepository.findUserByUsername("Moderator").orElseThrow())
                .setFullName("Moderator Moderatorov")
                .setEmail("moderator@gmail.com")
                .setBirthday(LocalDate.of(1985, 6, 6))
                .setHiredOn(LocalDate.of(2010, 4, 4))
                .setMobilePhone("0884674523")
                .setPosition(positionRepository.findById(2L).orElseThrow())
                .setDepartment(departmentRepository.findById(2L).orElseThrow())
                .setAddress(address);
        employeeRepository.save(employee);
    }

    private void addBoss() {
        Employee employee = new Employee();
        Address address = new Address();

        Location location = locationRepository.findById(1L).orElseThrow();
        location.setId(3L);

        address
                .setTown("Sofia")
                .setStreet("Bul. Evlogi and Hristo Georgievi N3")
                .setLocation(location);
        addressRepository.save(address);

        employee.setUser(userRepository.findUserByUsername("Boss").orElseThrow())
                .setFullName("Boss Bossov")
                .setEmail("boss@gmail.com")
                .setBirthday(LocalDate.of(1975, 3, 3))
                .setHiredOn(LocalDate.of(2000, 2, 2))
                .setMobilePhone("0885458364")
                .setPosition(positionRepository.findById(1L).orElseThrow())
                .setDepartment(departmentRepository.findById(1L).orElseThrow())
                .setAddress(address);
        employeeRepository.save(employee);
    }
}
