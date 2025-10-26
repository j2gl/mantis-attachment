package com.j2gl.mantisbt.attachments.repository

import com.j2gl.mantisbt.attachments.domain.MantisBug
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MantisBugRepository : JpaRepository<MantisBug, Int> {

    @Query("""
        SELECT m FROM MantisBug m 
        ORDER BY m.id ASC 
        LIMIT :limit
        """)
    fun findTopNByOrderByIdAsc(@Param("limit") limit: Int): List<MantisBug>

}
