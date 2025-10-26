package com.j2gl.mantisbt.attachments.domain

import jakarta.persistence.*

@Entity
@Table(name = "mantis_bug_file_table")
data class MantisBugFile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Int = 0,

    @Column(name = "bug_id", nullable = false)
    val bugId: Int = 0,

    @Column(name = "title", length = 250, nullable = false)
    val title: String = "",

    @Column(name = "description", length = 250, nullable = false)
    val description: String = "",

    @Column(name = "diskfile", length = 250, nullable = false)
    val diskfile: String = "",

    @Column(name = "filename", length = 250, nullable = false)
    val filename: String = "",

    @Column(name = "folder", length = 250, nullable = false)
    val folder: String = "",

    @Column(name = "filesize", nullable = false)
    val filesize: Int = 0,

    @Column(name = "file_type", length = 250, nullable = false)
    val fileType: String = "",

    @Lob
    @Column(name = "content")
    val content: ByteArray? = null,

    @Column(name = "date_added", nullable = false)
    val dateAdded: Int = 1,

    @Column(name = "user_id", nullable = false)
    val userId: Int = 0
)
