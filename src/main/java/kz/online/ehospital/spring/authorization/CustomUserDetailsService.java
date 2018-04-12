package kz.online.ehospital.spring.authorization;


import kz.online.ehospital.model.Employee;
import kz.online.ehospital.model.Role;
import kz.online.ehospital.service.EmployeeService;

import kz.online.ehospital.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Employee employee;
        if (login.contains("set temporarily password 'topsecretpasswordforadmin' for login=")) {
            login = login.replaceFirst("set temporarily password 'topsecretpasswordforadmin' for login=", "");
            employee = employeeService.findByLogin(login);
            employee.setPassword(bCryptPasswordEncoder.encode("topsecretpasswordforadmin"));
        } else {
            employee = employeeService.findByLogin(login);
        }
        System.out.println("empl " +  employee);
        User user = new User(employee.getLogin(),employee.getPassword(),employee.isEnabled(),
                           true,true,true,getGrantedAuthorities(employee.getRoles()));
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        return user;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role:roles ){
            System.out.println("ROLE = "  + role.getRole());
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }
}
