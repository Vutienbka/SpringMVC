package UploadController;

import Model.UploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

@Controller
public class UploadController {

    // save uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/vutienbka/Downloads/";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploadMulti")
    public String multiFileUpload(@ModelAttribute UploadForm form,
                                  RedirectAttributes redirectAttributes) {

        StringJoiner stringJoiner = new StringJoiner(",");

        for (MultipartFile file : form.getFiles()) {

            if (file.isEmpty()) {
                continue;
            }

            try {

                byte[] bytes = file.getBytes(); //Lay dung luong file
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename()); // Truy cap file
                Files.write(path, bytes); //Chuyen file sang dang file nhi phan

                stringJoiner.add(file.getOriginalFilename()); // Lay ten file vao List StringJoiner

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String uploadedFileName = stringJoiner.toString();

        if (StringUtils.isEmpty(uploadedFileName)) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
        } else {
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + UPLOADED_FOLDER + uploadedFileName + "'");
        }
        return "redirect:/uploadStatus";

    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}