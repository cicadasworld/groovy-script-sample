import groovy.sql.GroovyRowResult

@GrabConfig(systemClassLoader = true)
@Grab('mysql:mysql-connector-java:8.0.18')

/**
 * create by
 * @author hujin 2020/9/10
 */

def url = "jdbc:mysql://localhost:3306/twitter?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai"
import groovy.sql.Sql
def user = "twitter"
def password = "123456"
def driverClassName = "com.mysql.cj.jdbc.Driver"

def sql = Sql.newInstance(url, user, password, driverClassName)
println "Connected!"

// create schema
//sql.execute('DROP TABLE IF EXISTS users')
//sql.execute """
//CREATE TABLE users   (
//    id  INT NOT NULL,
//    username VARCHAR(45) NOT NULL,
//    bio VARCHAR(45) NULL,
//    PRIMARY KEY (id)
//"""
//
//def twitterUser = [id: 2, username: 'foo', bio: 'foo']
//
//sql.execute """
//    INSERT INTO users (id, username, bio) VALUES (${twitter.id}, ${twitter.username}, ${twitter.bio})
//"""
//
//def rows = sql.rows("select * from users")
//println rows
//
//sql.eachRow('select * from users') {
//    println "Tweet: @${it.username}"
//}
//
//sql.close()