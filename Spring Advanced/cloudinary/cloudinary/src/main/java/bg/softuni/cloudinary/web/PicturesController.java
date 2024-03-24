package bg.softuni.cloudinary.web;

import bg.softuni.cloudinary.model.binding.PictureBindingModel;
import bg.softuni.cloudinary.model.entity.PictureEntity;
import bg.softuni.cloudinary.model.view.PictureViewModel;
import bg.softuni.cloudinary.repository.PictureRepository;
import bg.softuni.cloudinary.service.CloudinaryImage;
import bg.softuni.cloudinary.service.CloudinaryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PicturesController {
    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;

    public PicturesController(CloudinaryService cloudinaryService, PictureRepository pictureRepository) {

        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
    }

    @GetMapping("/pictures/add")
    public String addPicture() {
        return "add";
    }


    @PostMapping("/picture/add")
    public String addPicture(PictureBindingModel bindingModel) throws IOException {
        var picture = createPictureEntity(bindingModel.getPicture(), bindingModel.getTitle());
        pictureRepository.save(picture);
        return "redirect:/pictures/all";

    }

    private PictureEntity createPictureEntity(MultipartFile file, String title) throws IOException {
        final CloudinaryImage upload = this.cloudinaryService.upload(file);
        return new PictureEntity().setPublicId(upload.getPublicId()).setUrl(upload.getUrl()).setTitle(title);
    }

    @GetMapping("pictures/all")
    public String all(Model model) {
        List<PictureViewModel> pictures = pictureRepository.findAll().stream()
                .map(this::asViewModel).collect(Collectors.toList());
        model.addAttribute("pictures",pictures);

        return "all";
    }
    private PictureViewModel asViewModel(PictureEntity picture){
        return new PictureViewModel().setPublicId(picture.getPublicId())
                .setTitle(picture.getTitle())
                .setUrl(picture.getUrl());
    }
    @DeleteMapping("/pictures/delete")
    public String delete(@RequestParam("public_id") String publicId){
        if(cloudinaryService.delete(publicId)){
            pictureRepository.deleteAllByPublicId(publicId);
        }
        return "redirect:/pictures/all";
    }
}
