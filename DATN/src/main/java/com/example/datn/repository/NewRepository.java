package com.example.datn.repository;

import com.example.datn.entity.NewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NewRepository extends JpaRepository<NewEntity, Long> {
    @Query(value = "select * from news as n INNER JOIN category as c on n.category_id=c.id INNER JOIN category_parent as cp ON c.category_parent_id=cp.id WHERE cp.code=?1 and n.status=1", nativeQuery = true)
    List<NewEntity> findNewsByCategoryParentCode(String categoryParentCode, Pageable pageable);

    @Query(value = "select * from news as n inner join category as c on n.category_id=c.id inner join category_parent as cp on c.category_parent_id=cp.id where cp.code=?1 AND n.status=1", nativeQuery = true)
    List<NewEntity> findNewsByCategoryParentCode1(String categoryParentCode);

    @Query(value = "SELECT * FROM news as n where n.status=1", nativeQuery = true)
    List<NewEntity> findAllActive(Pageable pageable);

    @Query(value = "SELECT * FROM news as n where n.status=0", nativeQuery = true)
    List<NewEntity> findAllDeactive(Pageable pageable);

    @Query(value = "SELECT COUNT(n.id) FROM news as n INNER JOIN category as c ON c.id = n.category_id INNER JOIN category_parent as cp ON c.category_parent_id = cp.id WHERE cp.code=?1 and n.status=1", nativeQuery = true)
    int totalItemByCategoryParent(String categoryParent);

    @Query(value = "select count(*) from news as n where n.status=0", nativeQuery = true)
    int totalItemDeactive();

    @Query(value = "select count(*) from news as n where n.status=1", nativeQuery = true)
    int totalItemActive();

    @Query(value = "SELECT TOP (1) * " +
            "FROM news as n INNER JOIN category as c ON n.category_id=c.id INNER JOIN category_parent as cp ON " +
            "c.category_parent_id=cp.id where cp.code=?1 and n.status=1 order by n.id DESC", nativeQuery = true)
    NewEntity findTopByCategoryParentCode(String categoryParentCode);

    NewEntity findByTitle(String title);

    void removeById(Long id);

    Boolean existsByTitleAndContent(String title, String content);
}
