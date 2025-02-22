package app.adapters.guests.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.guests.entity.GuestEntity;
import app.adapters.users.entity.UserEntity;

public interface GuestRepository extends JpaRepository<GuestEntity, Long> {

	public GuestEntity findByUserId(UserEntity userEntity);

}
