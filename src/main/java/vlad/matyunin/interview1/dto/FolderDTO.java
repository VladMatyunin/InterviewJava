package vlad.matyunin.interview1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FolderDTO {

    private Long id;

    private String name;

    private List<FolderDTO> subFolders = new ArrayList<>();

    private Integer level = 0;
}
