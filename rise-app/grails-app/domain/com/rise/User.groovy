package com.rise

class User {

    public static final int PASSWORD_MIN_SIZE = 6

	transient springSecurityService

	String emailAddress
	String password
    String firstName
    String lastName
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
    Role role

	static transients = ['springSecurityService']

	static constraints = {
        emailAddress blank: false, unique: true, email: true
		password blank: false, minSize: PASSWORD_MIN_SIZE
        firstName blank: false
        lastName blank: false
	}

	static mapping = {
        table 'users'
		password column: '`password`'
        id generator: 'uuid'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
