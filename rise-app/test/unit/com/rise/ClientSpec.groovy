package com.rise

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Client)
@Build([User, RiseInfo, Client])
class ClientSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "user should not be null"() {
        when:
            def client = Client.buildWithoutSave(user: null)

        then:
            !client.validate(['user'])
    }

    void "riseInfo should not be null"() {
        when:
            def client = Client.buildWithoutSave(riseInfo: null)

        then:
            !client.validate(['riseInfo'])
    }

    void "should successfully save when user and riseInfo is NOT null"() {
        given:
            def user = User.build().save(flush: true, failOnError: true)
            def riseInfo = RiseInfo.build().save(flush: true, failonError: true)

        when:
            def client = new Client(user: user, riseInfo: riseInfo)

        then:
            client.validate()
    }
}
