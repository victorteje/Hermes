package com.example.Hermesbackend.repositories;

import com.example.Hermesbackend.models.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface IGuideRepository extends JpaRepository<Guide, Long> {

    ArrayList<Guide> findByDestination(Guide guide);
    List<Guide> getGuidesByDestination(String destination);
    @Query(
        value = "SELECT * FROM guides WHERE guides.destination LIKE %:keyword%",
        nativeQuery = true
    )
    List<Guide> search(@Param("keyword") String keyword);

}
