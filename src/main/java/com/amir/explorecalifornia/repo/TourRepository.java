package com.amir.explorecalifornia.repo;

import com.amir.explorecalifornia.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    @Override
    @RestResource(exported = false)
    default <S extends Tour> S save(S entity) {
        return null;
    }

    @Override
    @RestResource(exported = false)
    default <S extends Tour> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    @RestResource(exported = false)
    default void deleteById(Integer integer) {

    }

    @Override
    @RestResource(exported = false)
    default void delete(Tour entity) {

    }

    @Override
    @RestResource(exported = false)
    default void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    @RestResource(exported = false)
    default void deleteAll(Iterable<? extends Tour> entities) {

    }

    @Override
    @RestResource(exported = false)
    default void deleteAll() {

    }
}
