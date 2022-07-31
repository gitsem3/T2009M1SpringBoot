package t2009m1springboot.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t2009m1springboot.entity.Account;
import t2009m1springboot.repository.AccountRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Service
@Transactional
public class MyUserDetailService implements UserDetailsService{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm account theo user name trong bảng accounts.
        Account account = accountRepository.findAccountByUsername(username);
        /*
            Tạo danh sách quyền. (một người dùng có thể có nhiều quyền).
            Có thể tạo ra bảng quyền riêng mapping n - n với accounts
         */
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (account.getRole() == 1) {
            // thêm quyền theo trường role trong account
            authorities.add(new SimpleGrantedAuthority("user"));
        } else if (account.getRole() == 2) {
            authorities.add(new SimpleGrantedAuthority("admin"));
        } else {
            authorities.add(new SimpleGrantedAuthority("guest"));
        }
        /*
            Tạo đối tượng user detail theo thông tin username, password và quyền được lấy ra ở trên.
            Trong đó password là pass được mã hoá
         */
        return new User(account.getUsername(), account.getPasswordHash(), authorities);
    }
}
