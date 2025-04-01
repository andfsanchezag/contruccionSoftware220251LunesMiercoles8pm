package app.adapters.partners.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.adapters.partners.entity.PartnerEntity;

public interface PartnerRepository extends JpaRepository<PartnerEntity, Long> {

}
