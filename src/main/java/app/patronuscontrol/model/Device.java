package app.patronuscontrol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "devices", indexes = @Index(name = "macIdx", columnList = "mac_addr"))
public class Device {
    @Id
    private Long id;

    @Column(name = "coordinate", nullable = true)
    private byte[] coordinate;

    @Column(name = "mac_addr", nullable = false, length = 17, unique = true)
    private String macAddr;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "device_type", referencedColumnName = "id", nullable = false)
    private SupportedDevice deviceType;
}
