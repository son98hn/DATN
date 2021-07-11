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
public interface NewRepository extends JpaRepository<NewEntity, Long>  {
    @Query(value = "select * from [new] inner join category on [new].categoryid=category.id inner join categoryparent on category.categoryparent=categoryparent.id where categoryparent.code=?1",nativeQuery = true)
    List<NewEntity> findNewsByCategoryParentCode(String categoryParentCode, Pageable pageable);
    @Query(value = "select * from [new] inner join category on [new].categoryid=category.id inner join categoryparent on category.categoryparent=categoryparent.id where categoryparent.code=?1",nativeQuery = true)
    List<NewEntity> findNewsByCategoryParentCode1(String categoryParentCode);
    @Query(value = "SELECT * FROM [new]",nativeQuery = true)
    List<NewEntity> findNew(Pageable pageable);
    @Query(value = "SELECT COUNT(new.id) FROM new INNER JOIN category ON category.id = new.categoryid INNER JOIN categoryparent ON category.categoryparent = categoryparent.id WHERE categoryparent.code =?1", nativeQuery = true)
    int totalItemByCategoryParent(String categoryParent);
    @Query(value = "SELECT TOP (1) * " +
            "FROM [new] INNER JOIN [category] ON [new].categoryid=[category].id INNER JOIN [categoryparent] ON " +
            "[category].categoryparent=[categoryparent].id where [categoryparent].code=?1 order by [new].id DESC",nativeQuery = true)
    NewEntity findTopByCategoryParentCode(String categoryParentCode);
    NewEntity findByTitle(String title);
    void removeById(Long id);
}
