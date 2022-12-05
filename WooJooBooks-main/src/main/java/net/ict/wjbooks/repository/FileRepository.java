package net.ict.wjbooks.repository;

import net.ict.wjbooks.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findBys_numOrderByIdAsc(Long s_num);
    File findBys_numAndRepimgYn(Long s_num, String repimgYn);
}
