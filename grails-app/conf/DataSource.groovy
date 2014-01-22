dataSource {
//    test {
//        pooled = true
//        driverClassName = "org.h2.Driver"
//        username = "sa"
//        password = ""
//    }
  //  production {
        pooled = true
        driverClassName = "com.mysql.jdbc.Driver"
        dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
        username = "grails"
        password = "server"
   // }
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
//    HUSK at rette dataSource
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
//    development {
//        dataSource {
//            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:mysql://localhost:3306/loppemarkeder?autoconnect=true"
//        }
//    }
//    test {
//        dataSource {
//            dbCreate = "update"
//            url = "jdbc:mysql://localhost:3306/loppemarkeder?autoconnect=true"
//        }
//    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/loppemarkeder?autoconnect=true"
        }
    }
}
