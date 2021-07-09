package vlad.matyunin.interview1.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlad.matyunin.interview1.dto.FolderDTO;
import vlad.matyunin.interview1.service.FolderService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/folders")
@RequiredArgsConstructor
public class FolderRestController {

    private final FolderService folderService;

    @GetMapping
    public ResponseEntity<List<FolderDTO>> getAllFolders() {
        return new ResponseEntity<>(folderService.getAllFolders(), HttpStatus.OK);
    }
}
