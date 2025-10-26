package com.j2gl.mantisbt.attachments.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class MantisBugFileRepositoryIntegrationTest @Autowired constructor(
    val repository: MantisBugFileRepository
) {
    @Test
    fun `should save and retrieve MantisBugFile`() {
        val bugFile = MantisBugFile(
            bugId = 123,
            title = "Test Title",
            description = "Test Description",
            diskfile = "diskfile.dat",
            filename = "filename.txt",
            folder = "/tmp",
            filesize = 42,
            fileType = "text/plain",
            content = "Hello World".toByteArray(),
            dateAdded = 20251026,
            userId = 1
        )
        val saved = repository.save(bugFile)
        saved.id shouldNotBe 0
        val found = repository.findById(saved.id)
        found.isPresent shouldBe true
        found.get().title shouldBe "Test Title"
    }

    @Test
    fun `should delete MantisBugFile`() {
        val bugFile = MantisBugFile(
            bugId = 456,
            title = "Delete Test",
            description = "Delete Description",
            diskfile = "deletefile.dat",
            filename = "delete.txt",
            folder = "/delete",
            filesize = 99,
            fileType = "text/plain",
            content = null,
            dateAdded = 20251026,
            userId = 2
        )
        val saved = repository.save(bugFile)
        repository.deleteById(saved.id)
        val found = repository.findById(saved.id)
        found.isPresent shouldBe false
    }
}
