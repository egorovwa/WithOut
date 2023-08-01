package su.egorovwa.dto.state;

public record DriverRuntime(
        Long driverId,
        DriverCurrentStatus status
) {
}
