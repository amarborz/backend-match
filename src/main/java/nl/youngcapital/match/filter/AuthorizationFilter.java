package nl.youngcapital.match.filter;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Haal de token op uit de header. Als de token niet is meegegeven dan is authorizeHeader
		// null
		String authorizeHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (authorizeHeader != null) {
			
			// Bij wie hoort de token. Gebruik bijvoorbeeld traineeerepository om 
			// er achter te komen welk person gekoppeld is aan de token 
			
			// Als de token is gevonden dan de bijhorende persoon opslaan in de request.
			// Request attributes is een tijdelijk lijst waar we objecten kunnen opslaan
			// zoals de gevonden persoon
			// request.setAttribute("YC_PERSOON", gevondenPersoonBijDeToken);
		}

		// Ga door met de rest van de filters
		filterChain.doFilter(request, response);
	}

}
