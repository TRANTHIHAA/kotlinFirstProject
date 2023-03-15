package com.example.kotlin.controller

import com.example.kotlin.controller.AccountDTOController.Companion.BASE_PERSON_URL
import com.example.kotlin.model.dto.AddAccount
import com.example.kotlin.model.dto.UpdateAccount
import com.example.kotlin.model.dto.ViewAccount
import com.example.kotlin.service.AccountManagementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class AccountDTOController(private val accountManagementService: AccountManagementService) {

    @GetMapping("/{id}")
     fun findById(@PathVariable id: Long): ResponseEntity<ViewAccount?> {
        val personResponse: ViewAccount? = this.accountManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(personResponse)
    }

    @GetMapping
     fun findAll(): ResponseEntity<Iterable<ViewAccount>> {
        return ResponseEntity.ok(this.accountManagementService.findAll())
    }

    @PostMapping
     fun save(@RequestBody addAccount : AddAccount): ResponseEntity<ViewAccount> {
        val viewAccount = this.accountManagementService.save(addAccount)
        return ResponseEntity
            .created(URI.create(BASE_PERSON_URL.plus("/${viewAccount.id}")))
            .body(viewAccount)
    }

    @PutMapping
    fun update(@RequestBody updateAccount: UpdateAccount): ResponseEntity<ViewAccount> {
        return ResponseEntity.ok(this.accountManagementService.update(updateAccount))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.accountManagementService.deleteById(id)
        return ResponseEntity.noContent().build();
    }

    companion object {
        const val BASE_PERSON_URL: String = "/api/v1/account"
    }
}
