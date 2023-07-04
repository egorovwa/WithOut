package su.egorovwa.dto;

public record AuthRequest(
        String userName,
        String password
) {
}
