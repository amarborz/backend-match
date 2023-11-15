package nl.youngcapital.match.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.match.api.dto.LoginRequestDto;
import nl.youngcapital.match.api.dto.LoginResponseDto;
import nl.youngcapital.match.model.Persoon;
import nl.youngcapital.match.service.AuthenticationService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("auth/login")
	public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
		Optional<? extends Persoon> optional = authenticationService.authenticate(dto.getEmail(), dto.getWachtwoord());
		
		if (optional.isPresent()) {
			Persoon persoon = optional.get();
			
			return new LoginResponseDto(true, persoon.getToken(), persoon.getNaam(), persoon.getRole(), persoon.getId());
		}
		
		return new LoginResponseDto(false, null, null, null, 0);
	}
	
}
