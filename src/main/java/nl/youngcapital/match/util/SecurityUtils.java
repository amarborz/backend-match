package nl.youngcapital.match.util;

import jakarta.servlet.http.HttpServletRequest;
import nl.youngcapital.match.model.Persoon;

public final class SecurityUtils {

	private static final String PERSOON_ATTRIBUTE = "YC_USER";

	public static final void setAuthenticatedUser(HttpServletRequest request, Persoon persoon) {
		if (persoon == null) {
			request.removeAttribute(PERSOON_ATTRIBUTE);
		} else {
			request.setAttribute(PERSOON_ATTRIBUTE, persoon);
		}
	}

	public static final Persoon getAuthenticatedUser(HttpServletRequest request) {
		return (Persoon) request.getAttribute(PERSOON_ATTRIBUTE);
	}

	public static final boolean hasRole(HttpServletRequest request, String role) {
		Persoon persoon = getAuthenticatedUser(request);
		if (persoon == null)
			return false;

		return persoon.getRole().equals(role);
	}

	public static final boolean isOpdrachtgever(final HttpServletRequest request) {
		return hasRole(request, "ROLE_OPDRACHTGEVER");
	}

	public static final boolean isTalentmanager(final HttpServletRequest request) {
		return hasRole(request, "ROLE_TALENTMANAGER");
	}

	public static final boolean isTrainee(final HttpServletRequest request) {
		return hasRole(request, "ROLE_TRAINEE");
	}

	public static final boolean isAuthenticatedUser(final HttpServletRequest request, final long userId) {
		Persoon persoon = getAuthenticatedUser(request);
		if (persoon == null)
			return false;

		return persoon.getId() == userId;
	}

	public static final boolean isAuthenticated(final HttpServletRequest request) {
		return getAuthenticatedUser(request) != null;
	}

	public static final boolean isAdminOrUser(final HttpServletRequest request, final long userId) {
		if (isAdmin(request))
			return true;

		return isAuthenticatedUser(request, userId);
	}
	
	public static final boolean isAdminOrUser(final HttpServletRequest request, final User user) {
		if (!isAuthenticated(request))
			return false; 
		
		if (isAdmin(request))
			return true;

		return isAuthenticatedUser(request, user.getId());
	}


}
