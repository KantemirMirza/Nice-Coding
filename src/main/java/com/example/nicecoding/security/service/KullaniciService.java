package com.example.nicecoding.security.service;

import com.example.nicecoding.security.model.Kullanici;
import com.example.nicecoding.security.model.KullaniciDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface KullaniciService extends UserDetailsService {


    Kullanici saveKullanici(KullaniciDTO kullaniciDTO);

    List<Kullanici> listOfKullanici();
}
