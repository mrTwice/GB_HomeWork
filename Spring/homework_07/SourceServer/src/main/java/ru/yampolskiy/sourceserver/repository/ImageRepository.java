package ru.yampolskiy.sourceserver.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yampolskiy.sourceserver.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}