package com.kw.Proj2_spr_2020202060.Image.Repository;

import com.kw.Proj2_spr_2020202060.Image.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}