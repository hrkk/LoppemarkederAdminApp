package dk.roninit.loppadmin

class Role {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}

    @Override
    public java.lang.String toString() {
        return authority
    }
}
