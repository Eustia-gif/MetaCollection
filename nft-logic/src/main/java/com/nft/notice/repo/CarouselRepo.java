// CarouselRepo.java
package com.nft.notice.repo;

import com.nft.notice.domain.Carousel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarouselRepo extends JpaRepository<Carousel, Integer> {

    Page<Carousel> findAll(Pageable pageable);
}