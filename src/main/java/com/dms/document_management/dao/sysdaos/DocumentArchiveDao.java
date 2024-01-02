package com.dms.document_management.dao.sysdaos;

import com.dms.document_management.models.sysmodels.DocumentArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentArchiveDao extends JpaRepository<DocumentArchive, UUID> {
}
