package by.itstep.channelRita.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tittle", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne // много постов для 1 канала
    @JoinColumn(name = "channel_id")
    private ChannelEntity channel;


}
