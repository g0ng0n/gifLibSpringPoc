package com.test.project.giflib.dao;

import com.test.project.giflib.model.Gif;

import java.util.List;

/**
 * Created by g0ng0n.
 *
 */
public interface GifDao {


    List<Gif> findAll();

    Gif findById(Long id);

    void save(Gif gif);

    void delete(Gif gif);
}
