package app.adapters.partners.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import app.adapters.partners.entity.PartnerEntity;
import app.adapters.users.entity.UserEntity;
import jakarta.transaction.Transactional;

public interface PartnerRepository extends JpaRepository<PartnerEntity, Long> {

	PartnerEntity findByUserId(UserEntity userId);

	int countByType(String string);

	@Modifying
    @Transactional
    @Query("UPDATE PartnerEntity p SET p.type = :newType WHERE p.type = :oldType")
    void updateType(String oldType, String newType);
	List<PartnerEntity> findByType(String string);


}
