package com.ibira.api.domain.movel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovelRepository extends JpaRepository<Movel, Long> {
    Page<Movel> findAllByAtivoTrue(Pageable paginacao);

}
