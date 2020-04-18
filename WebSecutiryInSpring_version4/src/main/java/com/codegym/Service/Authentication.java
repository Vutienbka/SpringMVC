package com.codegym.Service;

import com.codegym.Constant.Constant;
//import com.codegym.Entity.CustomUserDetail;
import com.codegym.Entity.CustomUserDetail;
import com.codegym.Entity.Role;
import com.codegym.Entity.User;
//import com.codegym.Repository.IUserRepository;
import com.codegym.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//Chung ta se xac thuc thong tin dang nhap o day
@EnableTransactionManagement(proxyTargetClass = true)
public class Authentication implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override

    //Load userName tu form dang nhap
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //username trong loadUserByUserName se load thong tin user khi dang nhap
        //Tiep tuc ta xac thuc tai day
        User user = userRepository.findOneByUsernameAndStatus(username, Constant.ACTIVE);
        if(user == null) {
            throw  new UsernameNotFoundException("Username not found");//Nem ra exception neu khong tim thay username
        }
        //Neu tim thay ta se luu tat ca thong tin cua user do roi sang buoc Authority
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: user.getRoleList()){
            authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }
        CustomUserDetail customUserDetail = new CustomUserDetail(user.getUsername(),user.getPassword(),true,true,true,true,authorities);
        customUserDetail.setFullName(user.getFullName());
        return customUserDetail;
    }
}
