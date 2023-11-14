//package nl.youngcapital.match.api;
//
//import nl.youngcapital.match.model.Persoon;
//import nl.youngcapital.match.service.PersoonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/persoon")
//public class PersoonController {
//
//    @Autowired
//    private PersoonService persoonService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody Persoon loginRequest) {
//        // Retrieve the user from the database
//        UserDetails userDetails = persoonService.loadUserByUsername(loginRequest.getWachtwoord());
//
//        // Perform a simple authentication check
//        if (userDetails != null && ((UserDetails) userDetails).getPassword().equals(loginRequest.getWachtwoord())) {
//            // Return a success response (you might want to return a token or additional information)
//            return ResponseEntity.ok().build();
//        } else {
//            // Return an authentication failure response
//            return ResponseEntity.status(401).build();
//        }
//    }
//}
