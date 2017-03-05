package org.luger.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource

/**
 * Created by gerardo8 on 25/02/2017.
 */
@RepositoryRestResource(path = "people")
interface PersonRepository : JpaRepository<Person, Long> {

    @RestResource(path = "by-email")
    fun findByEmail(@Param(value = "email") email: String) : Person?
}
