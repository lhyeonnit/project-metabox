package org.example.metabox.movie_scrap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieScrapRepository extends JpaRepository<MovieScrap, Integer> {

    @Query("""
            select ms
            from MovieScrap ms
            join fetch ms.movie m
            join fetch ms.user u
            where u.id = :user_id
            """)
    List<MovieScrap> findByUserAndMovie(@Param("user_id") Integer userId);
}
