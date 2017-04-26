package com.test.project.giflib.service;

import com.test.project.giflib.dao.GifDao;
import com.test.project.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by g0ng0n
 */
public class GifServiceImpl implements GifService{

    @Autowired
    private GifDao gifDao;

    @Override
    public List<Gif> findAll() {
        return gifDao.findAll();
    }

    @Override
    public Gif findById(Long id) {
        return gifDao.findById(id);
    }

    @Override
    public void save(Gif gif, MultipartFile file){
        try {

            gif.setBytes(file.getBytes());
            gifDao.save(gif);
        }catch (IOException e){
            System.err.println("Unable to get byte array from uploaded file");
        }
    }

    @Override
    public void delete(Gif gif) {
        gifDao.delete(gif);

    }
}
