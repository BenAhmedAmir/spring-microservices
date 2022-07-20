package com.amir.explorecalifornia.repo;

import com.amir.explorecalifornia.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;
@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

    Optional<TourPackage> findByName(@Param("name") String name);


    @Override
    default <S extends TourPackage> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default void delete(TourPackage entity) {

    }

    @Override
    @RestResource(exported = false)
    default void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    default void deleteAll(Iterable<? extends TourPackage> entities) {

    }

    @Override
    default void deleteAll() {

    }
}
