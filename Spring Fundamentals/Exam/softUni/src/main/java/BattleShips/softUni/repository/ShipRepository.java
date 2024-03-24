package BattleShips.softUni.repository;

import BattleShips.softUni.model.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {

    Optional<ShipEntity> findByName(String attacker);

    @Query("Select s.name From ShipEntity s Where s.id NOT IN(:id)")
    List<String> findAllShipNamesWithIdDifferentFrom(Long id);

    @Query("Select s From ShipEntity s Order By s.id")
    List<ShipEntity> findAllShipsOrderedById();
}
