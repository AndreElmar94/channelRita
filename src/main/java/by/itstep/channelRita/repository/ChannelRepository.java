package by.itstep.channelRita.repository;

import by.itstep.channelRita.entity.ChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<ChannelEntity, Integer> {

    ChannelEntity findOneById(Integer id);
}
