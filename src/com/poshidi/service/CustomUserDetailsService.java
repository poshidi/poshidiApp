package com.poshidi.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import com.poshidi.dao.UserDao;
import com.poshidi.bean.DbUser;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * һ���Զ����service���������ݿ���в���. ���Ժ�����Ҫͨ�����ݿⱣ��Ȩ��.����Ҫ���Ǽ̳�UserDetailsService
 *
 * @author liukai
 *
 */
public class CustomUserDetailsService implements UserDetailsService {

    protected static Logger logger = Logger.getLogger("service");

    private UserDao userDAO = new UserDao();

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {

        UserDetails user = null;

        try {

            // �������ݿ���ƥ���û���¼��.
            // ���ǿ���ͨ��daoʹ��JDBC���������ݿ�
            DbUser dbUser = userDAO.getDatabase(username);

            // Populate the Spring User object with details from the dbUser
            // Here we just pass the username, password, and access level
            // getAuthorities() will translate the access level to the correct
            // role type

            user = new User(dbUser.getUsername(), dbUser.getPassword()
                    .toLowerCase(), true, true, true, true,
                    getAuthorities(dbUser.getAccess()));

        } catch (Exception e) {
            logger.error("Error in retrieving user");
            throw new UsernameNotFoundException("Error in retrieving user");
        }

        return user;
    }

    /**
     * ��÷��ʽ�ɫȨ��
     *
     * @param access
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(Integer access) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        // ���е��û�Ĭ��ӵ��ROLE_USERȨ��
        logger.debug("Grant ROLE_USER to this user");
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        // �������accessΪ1.��ӵ��ROLE_ADMINȨ��
        if (access.compareTo(1) == 0) {
            logger.debug("Grant ROLE_ADMIN to this user");
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }

        return authList;
    }
}