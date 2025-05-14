package com.epicor.platform.u202111952.movilesback.controller;

import com.epicor.platform.u202111952.movilesback.dto.LoginRequest;
import com.epicor.platform.u202111952.movilesback.model.User;
import com.epicor.platform.u202111952.movilesback.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user, HttpSession session) {
        if (repo.findByCorreo(user.getCorreo()).isPresent()) {
            return Map.of("error", "Correo ya registrado");
        }
        repo.save(user);
        session.setAttribute("userId", user.getCorreo());
        return Map.of("success", true);
    }

    @PostMapping("/login")
    public Map<String, Boolean> login(@RequestBody LoginRequest credentials, HttpSession session) {
        String correo = credentials.getCorreo();
        String contrasena = credentials.getContrasena();

        return repo.findByCorreo(correo)
                .filter(user -> user.getContrasena().equals(contrasena))
                .map(user -> {
                    session.setAttribute("userId", user.getCorreo());
                    return Map.of("success", true);
                })
                .orElse(Map.of("success", false));
    }


    @GetMapping("/me")
    public Object getSessionUser(HttpSession session) {
        String correo = (String) session.getAttribute("userId");
        if (correo == null) return Map.of("error", "No autenticado");

        return repo.findByCorreo(correo)
                .map(user -> Map.of(
                        "nombre", user.getNombre(),
                        "correo", user.getCorreo(),
                        "numero", user.getNumero()))
                .orElse(Map.of("error", "Usuario no encontrado"));
    }
}
