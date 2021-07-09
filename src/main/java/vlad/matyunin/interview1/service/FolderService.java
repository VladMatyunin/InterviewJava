package vlad.matyunin.interview1.service;

import org.springframework.stereotype.Service;
import vlad.matyunin.interview1.dto.FolderDTO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FolderService {

    private final List<FolderDTO> ALL_FOLDERS = new ArrayList<>();

    public List<FolderDTO> getAllFolders() {
        return ALL_FOLDERS;
    }

    @PostConstruct
    private void init() {
        List<FolderDTO> subFolders = new ArrayList<>();
        FolderDTO subSubFolder1 = new FolderDTO(1L, "Subfolder for Test folder1", new ArrayList<>(), 2);
        FolderDTO subFolder1 = new FolderDTO(1L, "Test folder1", Collections.singletonList(subSubFolder1), 1);
        subFolders.add(subFolder1);
        subFolders.add(new FolderDTO(2L, "Test folder2", new ArrayList<>(), 1));
        FolderDTO root1 = new FolderDTO(1L, "Root 1", subFolders, 0);
        ALL_FOLDERS.add(root1);
    }
}
