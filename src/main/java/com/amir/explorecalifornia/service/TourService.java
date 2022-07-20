package com.amir.explorecalifornia.service;

import com.amir.explorecalifornia.domain.Difficulty;
import com.amir.explorecalifornia.domain.Region;
import com.amir.explorecalifornia.domain.Tour;
import com.amir.explorecalifornia.domain.TourPackage;
import com.amir.explorecalifornia.repo.TourPackageRepository;
import com.amir.explorecalifornia.repo.TourRepository;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;

    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }
    /**
     * Create a new Tour Object and persist it to the Database.
     *
     * @param title
     * @param description
     * @param blurb
     * @param price
     * @param duration
     * @param bullets
     * @param keywords
     * @param tourPackageName
     * @param difficulty
     * @param region
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(()-> new RuntimeException("Tour package does not exist: " + tourPackageName));

        return tourRepository.save(new Tour(title, description,blurb, price, duration,
                bullets, keywords, tourPackage, difficulty, region));
    }
    /**
     * Calculate the number of Tours in the Database.
     *
     * @return the total.
     */
    public long total() {
        return tourRepository.count();
    }
}
