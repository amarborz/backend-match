//package nl.youngcapital.match.service;
//
//import nl.youngcapital.match.model.Opdrachtgever;
//import nl.youngcapital.match.model.Persoon;
//import nl.youngcapital.match.model.Talentmanager;
//import nl.youngcapital.match.model.Trainee;
//import nl.youngcapital.match.persistence.PersoonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PersoonService implements UserDetailsService {
//
//    @Autowired
//    private PersoonRepository persoonRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Persoon persoon = persoonRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        // Add roles based on user type
//        if (persoon instanceof Talentmanager) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_TALENTMANAGER"));
//        } else if (persoon instanceof Trainee) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_TRAINEE"));
//        } else if (persoon instanceof Opdrachtgever) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_OPDRACHTGEVER"));
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//                persoon.getEmail(), persoon.getWachtwoord(), authorities
//        );
//    }
//}
