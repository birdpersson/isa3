package com.isa35.isa3.service;

import com.isa35.isa3.dto.CabinDTO;
import com.isa35.isa3.model.Cabin;
import com.isa35.isa3.repository.CabinRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.threeten.extra.Interval;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public Cabin findById(Long id) {
        return cabinRepository.findById(id).orElseGet(null);
    }

    public List<Cabin> findAll() {
        return cabinRepository.findAll();
    }

    public Cabin create(CabinDTO dto) {
        Cabin c = new Cabin();
        c.setName(dto.getName());
        c.setAddress(dto.getAddress());
        c.setDescription(dto.getDescription());
        c.setAvailability(Interval.of(
                dto.getAvailableFrom(),
                dto.getAvailableTo()));
        c.setPriceList(dto.getPriceList());
        c.setRules(dto.getRules());
        c.setRooms(dto.getRooms());
        c.setBeds(dto.getBeds());
        return cabinRepository.save(c);
    }

    public Cabin edit(CabinDTO dto, Long id) {
        Cabin c = findById(id);
        c.setName(dto.getName());
        c.setAddress(dto.getAddress());
        c.setDescription(dto.getDescription());
        c.setAvailability(Interval.of(
                dto.getAvailableFrom(),
                dto.getAvailableTo()));
        c.setPriceList(dto.getPriceList());
        c.setRules(dto.getRules());
        c.setRooms(dto.getRooms());
        c.setBeds(dto.getBeds());
        return cabinRepository.save(c);
    }

    public Cabin upload(MultipartFile[] multipartFiles, Long id) {
        List<String> paths = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            String ext = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            String fileName = UUID.randomUUID() + "." + ext;

            String home = System.getProperty("user.home");
            String path = home + File.separator + "isa" + File.separator + "images";
            try {
                Path uploadPath = Paths.get(path);

                if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);

                try (InputStream inputStream = multipartFile.getInputStream()) {
                    Path filePath = uploadPath.resolve(fileName);
                    Resource resource = new UrlResource(filePath.toUri());
                    System.out.println(resource);
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                }
                paths.add(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Cabin c = findById(id);
        c.setImages(paths);
        return cabinRepository.save(c);
    }

}
