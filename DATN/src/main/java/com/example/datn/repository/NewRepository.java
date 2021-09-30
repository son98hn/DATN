package com.example.datn.repository;

import com.example.datn.entity.NewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NewRepository extends JpaRepository<NewEntity, Long> {
    @Query(value = "select * from news inner join category on news.category_id=category.id inner join category_parent on category.category_parent_id=category_parent.id where category_parent.code=?1 and status=1", nativeQuery = true)
    List<NewEntity> findNewsByCategoryParentCode(String categoryParentCode, Pageable pageable);

    @Query(value = "select * from news inner join category on [news].category_id=category.id inner join category_parent on category.category_parent_id=category_parent.id where category_parent.code=?1 and status=1", nativeQuery = true)
    List<NewEntity> findNewsByCategoryParentCode1(String categoryParentCode);

    @Query(value = "SELECT * FROM news where news.status=1", nativeQuery = true)
    List<NewEntity> findAllActive(Pageable pageable);

    @Query(value = "SELECT * FROM news where news.status=0", nativeQuery = true)
    List<NewEntity> findAllDeactive(Pageable pageable);

    @Query(value = "SELECT COUNT(news.id) FROM news INNER JOIN category ON category.id = news.category_id INNER JOIN category_parent ON category.category_parent_id = category_parent.id WHERE category_parent.code =?1 and status=1", nativeQuery = true)
    int totalItemByCategoryParent(String categoryParent);

    @Query(value = "select count(*) from news where status=0", nativeQuery = true)
    int totalItemDeactive();

    @Query(value = "select count(*) from news where status=1", nativeQuery = true)
    int totalItemActive();

    @Query(value = "SELECT TOP (1) * " +
            "FROM news INNER JOIN [category] ON news.category_id=[category].id INNER JOIN [category_parent] ON " +
            "[category].category_parent_id=[category_parent].id where [category_parent].code=?1 and status=1 order by news.id DESC", nativeQuery = true)
    NewEntity findTopByCategoryParentCode(String categoryParentCode);

    NewEntity findByTitle(String title);

    void removeById(Long id);

    Boolean existsByTitleAndContent(String title, String content);
}
