package com.j2gl.mantisbt.attachments.repository

import com.j2gl.mantisbt.attachments.domain.MantisBugFile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MantisBugFileRepository : JpaRepository<MantisBugFile, Int>