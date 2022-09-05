package com.isa35.isa3.service;

import com.isa35.isa3.dto.CabinQuery;
import com.isa35.isa3.dto.CabinRequest;
import com.isa35.isa3.model.Cabin;
import com.isa35.isa3.model.User;
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
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<Cabin> findByAvailability(CabinQuery query) {
        List<Cabin> cabins = cabinRepository.findAll();


//        cabins = cabins.stream().filter(cabin -> cabin.getName().toLowerCase().contains(query.getName().toLowerCase())).collect(Collectors.toList());
//        cabins = cabins.stream().filter(cabin -> cabin.getAddress().toLowerCase().contains(query.getAddress().toLowerCase())).collect(Collectors.toList());
        cabins = cabins.stream().filter(cabin -> {
            Interval availability = cabin.getAvailability();
            Interval interval = Interval.of(query.getStart(), Duration.ofDays(query.getDays()));

            System.out.println(cabin.getId() + ": " + cabin.getName());
            System.out.println("available:" + availability);
            System.out.println("intervals:" + interval);

            return availability.encloses(interval);
        }).collect(Collectors.toList());

        return cabins;
    }

    public Cabin create(User host, CabinRequest dto) {
        Cabin c = new Cabin();
        c.setName(dto.getName());
        c.setAddress(dto.getAddress());
        c.setDescription(dto.getDescription());
        c.setAvailability(Interval.of(
                dto.getAvailableFrom(),
                dto.getAvailableTo()));
        c.setPeople(dto.getPeople());
        c.setPrice(dto.getPrice());
        c.setCost(dto.getCost());
        c.setRules(dto.getRules());
        c.setHost(host);
        host.addCabin(c);
        return cabinRepository.save(c);
    }

    public Cabin edit(Cabin c, CabinRequest dto) {
        c.setName(dto.getName());
        c.setAddress(dto.getAddress());
        c.setDescription(dto.getDescription());
        c.setAvailability(Interval.of(
                dto.getAvailableFrom(),
                dto.getAvailableTo()));
        c.setPeople(dto.getPeople());
        c.setRules(dto.getRules());
        c.setPrice(dto.getPrice());
        c.setCost(dto.getCost());
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
