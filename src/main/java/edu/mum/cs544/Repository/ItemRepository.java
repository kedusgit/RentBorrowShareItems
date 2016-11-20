package edu.mum.cs544.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.Domain.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	@Query("from Item i where i.type=:type")
	List<Item> findAllByType(@Param("type") String type);

	

	@Query("from Item i where i.description like CONCAT('%',:description,'%') ")
	List<Item> findAllByDescriptionLike(@Param("description") String description);

	List<Item> findByNameLike(String name);






	@Query("from Item i where i.status=:status")
	List<Item> findAllByStatus(@Param("status") String status);

}
