package com.example.nicecoding.security.service;

import com.example.nicecoding.security.model.Kullanici;
import com.example.nicecoding.security.model.KullaniciDTO;
import com.example.nicecoding.security.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class KullaniciServiceImpl implements KullaniciService{
        private final KullaniciRepository kullaniciRepository;
        private final BCryptPasswordEncoder passwordEncoder;

        @Autowired
        //@Lazy
    public KullaniciServiceImpl(KullaniciRepository kullaniciRepository, BCryptPasswordEncoder passwordEncoder) {
        this.kullaniciRepository = kullaniciRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Kullanici saveKullanici(KullaniciDTO kullaniciDTO) {
            Kullanici kul = new Kullanici(
                    kullaniciDTO.getFirstName(),
                    kullaniciDTO.getLastName(),
                    kullaniciDTO.getEmail(),
                    passwordEncoder.encode(kullaniciDTO.getPassword()),
                    Arrays.asList(new Status("STATUS_KULLANICI")));
        return kullaniciRepository.save(kul);
    }

    @Override
    public List<Kullanici> listOfKullanici(){
        return kullaniciRepository.findAll();
    }

    @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            Kullanici kullanici = kullaniciRepository.findByEmail(email);
            if(kullanici == null){
                throw new UsernameNotFoundException("Invalid Email or Password");
            }
            return new org.springframework.security.core.userdetails.User(kullanici.getEmail(),
                    kullanici.getPassword(),mapRolesToAuthority(kullanici.getStatus()));
        }
        private Collection<? extends GrantedAuthority> mapRolesToAuthority(Collection<Status> status){
            return status.stream()
                    .map(status1 -> new SimpleGrantedAuthority(status1.getStatusName())).collect(Collectors.toList());
        }
}
