package com.j2gl.mantisbt.attachments.domain

import com.j2gl.mantisbt.attachments.repository.MantisBugRepository
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class MantisBugRepositoryIT @Autowired constructor(
    val repository: MantisBugRepository
) {

    @BeforeEach
    fun setUp() {
        repository.deleteAllInBatch()
    }

    @Test
    fun `should save and retrieve MantisBug`() {
        val bug = createBug("Test bug summary")
        val saved = repository.save(bug)
        saved.id shouldNotBe 0
        val found = repository.findById(saved.id)
        found.isPresent shouldBe true
        found.get().summary shouldBe "Test bug summary"
    }

    @Test
    fun `should delete MantisBug`() {
        val bug = createBug("Delete bug summary")
        val saved = repository.save(bug)
        repository.deleteById(saved.id)
        val found = repository.findById(saved.id)
        found.isPresent shouldBe false
    }

    @Test
    fun `should retrieve top N from MantisBugs`() {

        // save 11 entities
        for (i in 1..11) {
            repository.save(createBug("Test bug summary $i"))
        }

        val bugs = repository.findTopNByOrderByIdAsc(10)
        for (bug in bugs) {
            println(bug)
        }
        bugs.size shouldBe 10
    }

    private fun createBug(summary: String): MantisBug = MantisBug(
        projectId = 1,
        reporterId = 2,
        handlerId = 3,
        duplicateId = 0,
        priority = 30,
        severity = 50,
        reproducibility = 10,
        status = 10,
        resolution = 10,
        projection = 10,
        eta = 10,
        bugTextId = 0,
        os = "Linux",
        osBuild = "5.10.0",
        platform = "x86_64",
        version = "1.0.0",
        fixedInVersion = "1.0.1",
        build = "20251026",
        profileId = 0,
        viewState = 10,
        summary = summary,
        sponsorshipTotal = 0,
        sticky = 0,
        targetVersion = "1.1.0",
        categoryId = 1,
        dateSubmitted = 20251026,
        dueDate = 20251101,
        lastUpdated = 20251026
    )
}
