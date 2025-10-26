package com.j2gl.mantisbt.attachments.domain

import jakarta.persistence.*

@Entity
@Table(name = "mantis_bug_table")
data class MantisBug(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Int = 0,

    @Column(name = "project_id", nullable = false)
    val projectId: Int = 0,

    @Column(name = "reporter_id", nullable = false)
    val reporterId: Int = 0,

    @Column(name = "handler_id", nullable = false)
    val handlerId: Int = 0,

    @Column(name = "duplicate_id", nullable = false)
    val duplicateId: Int = 0,

    @Column(name = "priority", nullable = false)
    val priority: Int = 30,

    @Column(name = "severity", nullable = false)
    val severity: Int = 50,

    @Column(name = "reproducibility", nullable = false)
    val reproducibility: Int = 10,

    @Column(name = "status", nullable = false)
    val status: Int = 10,

    @Column(name = "resolution", nullable = false)
    val resolution: Int = 10,

    @Column(name = "projection", nullable = false)
    val projection: Int = 10,

    @Column(name = "eta", nullable = false)
    val eta: Int = 10,

    @Column(name = "bug_text_id", nullable = false)
    val bugTextId: Int = 0,

    @Column(name = "os", length = 32, nullable = false)
    val os: String = "",

    @Column(name = "os_build", length = 32, nullable = false)
    val osBuild: String = "",

    @Column(name = "platform", length = 32, nullable = false)
    val platform: String = "",

    @Column(name = "version", length = 64, nullable = false)
    val version: String = "",

    @Column(name = "fixed_in_version", length = 64, nullable = false)
    val fixedInVersion: String = "",

    @Column(name = "build", length = 32, nullable = false)
    val build: String = "",

    @Column(name = "profile_id", nullable = false)
    val profileId: Int = 0,

    @Column(name = "view_state", nullable = false)
    val viewState: Int = 10,

    @Column(name = "summary", length = 128, nullable = false)
    val summary: String = "",

    @Column(name = "sponsorship_total", nullable = false)
    val sponsorshipTotal: Int = 0,

    @Column(name = "sticky", nullable = false)
    val sticky: Int = 0,

    @Column(name = "target_version", length = 64, nullable = false)
    val targetVersion: String = "",

    @Column(name = "category_id", nullable = false)
    val categoryId: Int = 1,

    @Column(name = "date_submitted", nullable = false)
    val dateSubmitted: Int = 1,

    @Column(name = "due_date", nullable = false)
    val dueDate: Int = 1,

    @Column(name = "last_updated", nullable = false)
    val lastUpdated: Int = 1
)

