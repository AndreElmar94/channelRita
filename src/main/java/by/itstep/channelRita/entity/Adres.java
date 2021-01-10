package by.itstep.channelRita.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "adres")
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "srteet", nullable = false)
    private String srteet;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
