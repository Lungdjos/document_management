package com.dms.document_management.dao.sysdaos;

import com.dms.document_management.models.sysmodels.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryDao extends JpaRepository<Library, UUID> {
}
