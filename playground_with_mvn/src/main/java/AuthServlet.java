import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;

public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // This should ideally be loaded from a configuration file
    private static final String SECRET_KEY = "your-secret-key";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate the user
        boolean authenticated = authenticateUser(username, password);

        if (authenticated) {
            // Generate JWT token
            SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            String token = Jwts.builder()
                    .setSubject(username)
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

            // Send the JWT token as a response
            response.setContentType("text/plain");
            response.getWriter().write(token);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username or password");
        }
    }

    private boolean authenticateUser(String username, String password) {
        // Your authentication logic goes here
        // Return true if the user is authenticated, false otherwise
    }
}
