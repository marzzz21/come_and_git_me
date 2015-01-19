package com.rise

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.buildtestdata.mixin.Build
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
@Build(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "emailAddress should not be blank"() {
        when:
            def user = User.buildWithoutSave(emailAddress: "")

        then:
            !user.validate(['emailAddress'])
    }

    void "emailAddress should be in correct format"() {
       when:
            def user = User.buildWithoutSave(emailAddress: "invalid@email@address@format.com")

       then:
            !user.validate(['emailAddress'])
    }

    void "emailAddress should be unique"() {
        given:
            def user = User.build(emailAddress: "rise@rise.com")
            user.save(flush: true, failOnError: true)

        when:
            def anotherUser = User.buildWithoutSave(emailAddress: "rise@rise.com")

        then:
            !anotherUser.validate()
        }

    @Unroll
    void "password should not be blank and must have a length of at least 6 characters"() {
        when:
            def user = User.buildWithoutSave(password: passwordInput)

        then:
            user.validate(['password']) == result

        where:
            passwordInput              | result
            ''                         | false
            'weakButAcceptablePassword'| true
            '12345'                    | false
    }

    void "firstName should not be blank"() {
        when:
            def user = User.buildWithoutSave(firstName: '')

        then:
            !user.validate(['firstName'])
    }

    void "lastName should not be blank"() {
        when:
            def user = User.buildWithoutSave(lastName: '')

        then:
            !user.validate(['lastName'])
    }
}
