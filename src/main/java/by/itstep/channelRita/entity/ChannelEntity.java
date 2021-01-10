package by.itstep.channelRita.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "channel")
public class ChannelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private ChannelEntityType type;

    // один канал для много постов
    @OneToMany(mappedBy = "channel", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})  // название ПОЛЯ в классе <PostEntity> внутри !!!!!!!!!!
    private List<PostEntity> posts = new ArrayList<>();
}
