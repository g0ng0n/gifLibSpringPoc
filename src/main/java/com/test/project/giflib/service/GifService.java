package com.test.project.giflib.service;

import com.test.project.giflib.model.Gif;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by g0ng0n.
 */
public interface GifService {

    List<Gif> findAll();

    Gif findById(Long id);

    void save(Gif gif, MultipartFile file);

    void delete(Gif gif);

    void toggleFavorite(Gif gif);
}
