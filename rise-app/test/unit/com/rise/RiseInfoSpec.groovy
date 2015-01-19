package com.rise

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(RiseInfo)
@Build(RiseInfo)
class RiseInfoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "staticIP should not be blank"() {
        when:
            def riseInfo = RiseInfo.buildWithoutSave(staticIP: '')

        then:
            !riseInfo.validate(['staticIP'])
    }

    void "framedRoute is an optional attribute, hence, it accepts blank/null values"() {
        when:
            def riseInfo = RiseInfo.buildWithoutSave(framedRoute: framedRouteInput)

        then:
            riseInfo.validate(['framedRoute'])

        where:
            framedRouteInput << ['', null, 'notNullNorBlank']
    }

    void "rateLimit should not be blank"() {
        when:
            def riseInfo = RiseInfo.buildWithoutSave(rateLimit: '')

        then:
            !riseInfo.validate(['rateLimit'])
    }
}
