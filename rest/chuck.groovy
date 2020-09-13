import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')

/**
 * create by
 * @author hujin 2020/9/11
 */
def base = 'http://api.icndb.com'

def chuck = new RESTClient(base)
def params = [firsName: 'John', lastName: 'Doe']
chuck.contentType = ContentType.JSON

chuck.get(path: '/jokes/random', query: params) { response, json ->
    println response.status
    println json
}